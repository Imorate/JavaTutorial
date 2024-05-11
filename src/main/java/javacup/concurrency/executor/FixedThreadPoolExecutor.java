package javacup.concurrency.executor;

import javacup.common.ThreadUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutor {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                ThreadUtils.log("%d", i);
            }
        };
        for (int i = 0; i < 3; i++) {
            executor.execute(task);
        }
    }
}
