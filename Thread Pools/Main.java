

public class Main {
    public static void main(String[] args) throws Exception {
        Threadpool tp = new Threadpool(
                Runtime.getRuntime().availableProcessors());

        // create tasks and store futures
        Future[] futures = new Future[1000];
        for (int i = 0; i < futures.length; i++) {
            final int ifinal = i;
            try {
                futures[i] = tp.submit(() -> System.out.println(
                        Thread.currentThread().getName() + ": " + ifinal));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // wait for all futures to finish to prevent premature termination
        for (Future f : futures)
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        // shut down
        tp.shutdownNow();
        System.out.println("Shut down");
    }
}
