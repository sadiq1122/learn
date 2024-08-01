package multithreading;

public class ThreadCreation {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        System.out.println(Thread.currentThread().getName());
        Thread runner = new Thread(thread);
        TimeThread thread2 = new TimeThread();
        thread2.start();
        runner.start();
        // thread2.join();
        // runner.join();
        System.out.println(
            "main thread endeed"
        );
    }

}

class MyThread implements Runnable {
    public void run() {
        System.out.println("executing my thread");
        System.out.println(Thread.currentThread().getName());
    }
}

class TimeThread extends Thread {

    @Override
    public void run() {
        System.out.println("Running the Time Thread");
        System.out.println(Thread.currentThread().getName());
    }

}