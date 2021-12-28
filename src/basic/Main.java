package basic;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Logic goes here
                System.out.println("We are now in Thread " + Thread.currentThread().getName());
                System.out.println("Current Thread priority is  " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("New worker Thread"); // Giving name of the Thread

        thread.setPriority(Thread.MAX_PRIORITY); // plays responsiveness of Thread

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread "
                        + t.getName() + " the error is " + e.getMessage());

            }
        });

        System.out.println("We are in Thread " + Thread.currentThread().getName() + " before starting new Thread");
        thread.start(); // how to run thread
        System.out.println("We are in Thread " + Thread.currentThread().getName() + " after starting new Thread");

        try {
            Thread.sleep(1000); //pause Thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread newThread = new NewThread();

        newThread.start();
    }
     private static class NewThread extends Thread {
        @Override
         public void run() {
            System.out.println("New Thread Running is called " + this.getName());
        }
     }

}


