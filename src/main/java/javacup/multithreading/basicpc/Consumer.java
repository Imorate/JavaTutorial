package javacup.multithreading.basicpc;

import javacup.common.ThreadLogger;

import java.util.List;

public class Consumer implements Runnable {
    private final List<Integer> list;

    public Consumer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (list) {
                while (list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        ThreadLogger.log("Thread interrupted");
                    }
                }
                int x = list.remove(0);
                ThreadLogger.log("Consumed " + x);
            }
        }
    }
}
