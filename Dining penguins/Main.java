
public class Main {
    public static void main(String[] args) {

        Table table = new Table(4);

        Penguin peter = new Penguin("peter", table, 0);
        Penguin paul = new Penguin("paul", table, 1);
        Penguin pam = new Penguin("pam", table, 2);
        Penguin paula = new Penguin("paula", table, 3);

        Thread petersThread = new Thread(peter);
        Thread paulsThread = new Thread(paul);
        Thread pamsThread = new Thread(pam);
        Thread paulasThread = new Thread(paula);

        petersThread.start();
        paulasThread.start();
        paulsThread.start();
        pamsThread.start();


        try {
            petersThread.join();
            paulsThread.join();
            pamsThread.join();
            paulasThread.join();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong. Interrupted!");
        }

    }
}
