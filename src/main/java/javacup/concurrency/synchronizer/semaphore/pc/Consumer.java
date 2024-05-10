package javacup.concurrency.synchronizer.semaphore.pc;

import javacup.common.ThreadUtils;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private final List<Integer> list;
    private final Semaphore semaphore;

    public Consumer(List<Integer> list, Semaphore semaphore) {
        this.list = list;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                ThreadUtils.log("Consumer interrupted");
            }
            synchronized (list) {
                int num = list.remove(0);
                ThreadUtils.log("Consumed %d", num);
            }
        }
    }
}
