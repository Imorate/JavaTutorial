package javacup.concurrency.threadlocal;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FixedThreadPoolThreadLocal {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);

        ThreadLocalRunnable runnable = new ThreadLocalRunnable();

        for (int i = 0; i < 10; i++) {
            executor.execute(runnable);
        }
    }
}
