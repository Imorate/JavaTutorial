package javacup.concurrency.pc;

import javacup.common.ThreadUtils;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable {
    private final ArrayBlockingQueue<Integer> array;

    public Producer(ArrayBlockingQueue<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int num = (int) (Math.random() * 100);
            try {
                array.put(num);
            } catch (InterruptedException e) {
                ThreadUtils.log("Producer interrupted");
            }
            ThreadUtils.log("Produced %d", num);
            ThreadUtils.sleep(100);
        }
    }
}
