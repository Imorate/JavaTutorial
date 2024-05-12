package javacup.concurrency.pc;

import javacup.common.ThreadUtils;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {
    private final ArrayBlockingQueue<Integer> array;

    public Consumer(ArrayBlockingQueue<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int num = 0;
            try {
                num = array.take();
            } catch (InterruptedException e) {
                ThreadUtils.log("Consumer interrupted");
            }
            ThreadUtils.log("Consumer %d", num);
        }
    }
}
