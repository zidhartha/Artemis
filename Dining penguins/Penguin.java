public class Penguin implements Runnable {

    private String name;
    private Table table;
    private int index;

    public Penguin(String name, Table table, int index) {
        this.name = name;
        this.table = table;
        this.index = index;
    }

    public void getFork(int fork) {
        while (!table.forkAvailable(fork)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong. Interrupted!");
                return;
            }
        }

        table.takeFork(fork);
        System.out.println(name + " takes fork #" + fork);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong. Interrupted!");
        }
    }

    public void eat() {
        int firstFork = index;
        int secondFork = (index + 1) % 4;


        int minFork = Math.min(firstFork, secondFork);
        int maxFork = Math.max(firstFork, secondFork);

        getFork(minFork);
        getFork(maxFork);

        System.out.println(name + " ate.");

        table.returnFork(minFork);
        table.returnFork(maxFork);
    }

    @Override
    public void run() {
        eat();
    }

}