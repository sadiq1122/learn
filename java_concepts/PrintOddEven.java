package java_concepts;

public class PrintOddEven {

    int n = 100;
    int counter = 1;

    public synchronized void printOdd() {
        while (counter <= n) {
            if (counter % 2 == 1) {
                System.out.println(counter + " " + Thread.currentThread().getName());
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public synchronized void printEven() {
        while (counter <= n) {
            if (counter % 2 == 0) {
                System.out.println(counter + " " + Thread.currentThread().getName());
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public static void main(String[] args) {
        PrintOddEven runner = new PrintOddEven();
        new Thread(() -> runner.printEven(), "even").start();
        new Thread(() -> runner.printOdd(), "odd").start();

    }

}
