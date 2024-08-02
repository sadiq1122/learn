package multithreading;

public class Counter {
    public static void main(String[] args) throws InterruptedException {

        Runner counter = new Runner();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task, "T1");
        Thread thread2 = new Thread(task, "T2");
        Thread thread3 = new Thread(task, "T3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(

                "Value of counter is " + counter.getCount());

    }
}

class Runner {
    int count = 0;

    public synchronized void  increment() {
        this.count = this.count + 1;
    }

    int getCount() {
        return this.count;
    }
}