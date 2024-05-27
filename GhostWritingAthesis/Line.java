

public class Line<T extends Thesis> {
    private String content;
    private Thesis.State state;
    private Thread[] writers;
    //array to store command line arguments
    public static String[] cmdargs = new String[6];
    public Line(T ghost, String title){
        content = title;
        state = Thesis.State.INTRO;
        writers = new Thread[5];
        writers[0] = new Thread(() -> {
            synchronized (ghost) {
                while (state != Thesis.State.INTRO) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.intro();
                state = Thesis.State.SETUP;
                ghost.notifyAll();
            }
        });
        writers[1] = new Thread(() -> {
            synchronized (ghost) {
                while (state != Thesis.State.SETUP) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.setup();
                state = Thesis.State.EXPERIMENTS;
                ghost.notifyAll();
            }
        });
        writers[2] = new Thread(() -> {
            synchronized (ghost) {
                while (state != Thesis.State.EXPERIMENTS) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.experiments();
                state = Thesis.State.CONCLUSION;
                ghost.notifyAll();
            }
        });
        writers[3] = new Thread(() -> {
            synchronized (ghost) {
                while (state != Thesis.State.CONCLUSION) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.conclusion();
                state = Thesis.State.REFS;
                ghost.notifyAll();
            }
        });

        writers[4] = new Thread(() -> {
            synchronized (ghost) {
                while (state != Thesis.State.REFS) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.refs();
                state = Thesis.State.FINISHED;
                ghost.notifyAll();
            }
        });

        for(int i = 0; i < 5; i++){
            writers[i].start();
        }

        if(state == Thesis.State.FINISHED){
            for(int i = 0; i < 5; i++){
                writers[i].interrupt();
            }
        }
    }

    public String result(){
        return content;
    }

    public static void main(String[] args) {
        class MyThesis implements Thesis{
            public String intro(){
                return args[1];
            }

            public String setup(){
                return args[2];
            }

            public String experiments(){
                return args[3];
            }

            public String conclusion(){
                return args[4];
            }

            public String refs(){
                return args[5];
            }
        }
        MyThesis myThesis = new MyThesis();
        Line<MyThesis> temp = new Line<>(myThesis, args[0]);
        for(int i = 0; i < 5; i++){
            try {
                temp.writers[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(temp.result());
    }
}
