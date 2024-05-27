public class Bistro2 {
    private int seats;
    private Thread order, meal, waiter;

    public Bistro2(int n) {
        this.seats = n; // create n seat bistro

        this.waiter = new Thread(() -> serve());
        this.waiter.start(); // start waiter thread as soon as the Bistro is created
    }

    public synchronized void dine(int price) {
        while (seats == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        } // wait until at least 1 seat is free

        this.seats--; // occupy a seat

        while (order != null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        } // wait until order is not null (waiting for waiter to be free and get our order)

        this.order = Thread.currentThread(); // assign current customer thread to current order thread
        System.out.println("Guest " + this.order.getId() + " orders for " + price + "Lari");
        notifyAll(); // notify waiter that order has placed


        while (this.meal != Thread.currentThread()) {
            try {
                wait();
            } catch (InterruptedException e) {
            } // wait for order
        } // if meal is ready, check if it's guest's meal, otherwise wait again for next meal

        this.meal = null; // grab a meal (set to null) and eat
        notifyAll(); // notify waiter that guest has taken a meal (makes waiter saying enjoy!)

        System.out.println("Guest " + Thread.currentThread().getId() + " eats ...");

        // finish dining and free occupied seat. And notify all guests who are waiting for a free chair on line 13
        this.seats++;
        notifyAll();
    }

    private synchronized void serve() {
        // run a while loop to serve until shutdown is called()
        while (!waiter.isInterrupted()) { // interrupt is invoked from shutdown()
            while (this.order == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                } // wait for order
            } // wait until order is placed (awaked with notifyAll())

            this.meal = this.order; // set current meal as an order (simulating completion of an order)
            this.order = null; // free order placeholder, meaning that waiter is ready to take another order
            notifyAll(); // notifies all customers waiting to make an order

            while (this.meal != null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                } // wait for delivery
            } // waits until customer grabs a completed order (meal), after taking an order, waiter says Enjoy!

            System.out.println("Enjoy!");

            // rerun while loop to serve new order...
        }
    }

    public void shutdown() {
        // stop waiter... (we do not interrupt meal and order, because at this point all g1-4 are joined at line 97
        waiter.interrupt();
        //
    }
}