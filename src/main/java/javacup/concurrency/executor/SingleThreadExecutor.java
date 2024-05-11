package javacup.concurrency.executor;

import javacup.common.ThreadUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(0);
        Executor executor = Executors.newSingleThreadExecutor();
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
