package javacup.concurrency.synchronizer.semaphore.pc;

import javacup.common.ThreadUtils;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private final List<Integer> list;
    private final Semaphore semaphore;

    public Producer(List<Integer> list, Semaphore semaphore) {
        this.list = list;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (list) {
                int num = (int) (Math.random() * 100);
                list.add(num);
                ThreadUtils.log("Produced %d", num);
            }
            semaphore.release();
            ThreadUtils.sleep(100);
        }
    }
}
