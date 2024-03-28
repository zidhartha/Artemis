

import java.util.concurrent.LinkedBlockingQueue;

public class Threadpool {

    LinkedBlockingQueue<Task> queue;
    Thread[] workers;
    boolean running;

    public Threadpool(int numWorkers) {
        queue = new LinkedBlockingQueue<>();

        workers = new Thread[numWorkers];

        Runnable work = new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    try {
                        Task task = queue.take();
                        task.getRunnable().run();
                        task.getFuture().finish();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(work);
            workers[i].start();
        }

        running = true;
    }

    public Future submit(Runnable job) throws Exception {
        if (running) {
            Future future = new Future();
            Task task = new Task(job, future);
            queue.put(task);
            return future;
        } else {
            throw new ShutDownException();
        }
    }

    public void shutdownNow() {
        running = false;
		for (Thread worker : workers) {
			worker.interrupt();
		}
    }
}
