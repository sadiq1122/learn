package java_concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Eager initialization

class SingletonA {

    private static final SingletonA instance = new SingletonA();

    private SingletonA() {
    }

    public static SingletonA getInstance() {
        return instance;
    }

}

// Lazy initialization

class SingletonB {

    private static SingletonB instance;

    private SingletonB() {
    }

    public static SingletonB getInstance() throws InterruptedException {
        synchronized (SingletonB.class) {
            if (instance == null) {
                instance = new SingletonB();
            }
        }

        return instance;
    }

}

public class Singleton {

    public static void main(String[] args) throws ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Callable<SingletonB>> tasks = new ArrayList<>();
        tasks.add(() -> SingletonB.getInstance());
        tasks.add(() -> SingletonB.getInstance());

        try {
            List<Future<SingletonB>> futures = executorService.invokeAll(tasks);
            for (Future<SingletonB> future : futures) {
                System.out.println(future.get().hashCode());
            }
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
