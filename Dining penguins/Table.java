import java.util.Arrays;

public class Table {

    boolean[] forks;


    public Table(int forks) {
        this.forks = new boolean[forks];
        Arrays.fill(this.forks, true);
    }

    public synchronized boolean forkAvailable(int index) {
        return forks[index];
    }

    public void takeFork(int index) {
        forks[index] = false;
    }

    public void returnFork(int index) {
        forks[index] = true;
    }

}