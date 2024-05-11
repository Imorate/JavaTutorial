package javacup.concurrency.executor;

import javacup.common.ThreadUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutor {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                ThreadUtils.log("%d", i);
            }
        };

        for (int i = 0; i < 3; i++) {
            executor.execute(task);
        }

        ThreadUtils.sleep(1000);
        executor.execute(task);
    }
}
