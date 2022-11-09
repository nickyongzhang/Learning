package academy.learnprogramming;

import static academy.learnprogramming.ThreadColor.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE+"Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("=== Another Thread ===");
        anotherThread.start(); // start() will really run the another thread, if using run() it will run on main thread

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN+"Hello from the anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED+"Hello from the anonymous class's implementation of run()");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED+"AnotherThread terminated or timed out, so I'm running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED+"I couldn't wait after all. I was interrupted");
                }
            }
        });
        myRunnableThread.start();

//        anotherThread.interrupt();


        // The order of print in main and another thread depends on system timing
        System.out.println(ANSI_PURPLE+"Hello again from the main thread");

    }
}
