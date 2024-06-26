package javacup.multithreading.basicpc;

import javacup.common.ThreadUtils;

import java.util.List;

public class Producer implements Runnable {
    private final List<Integer> list;

    public Producer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (list) {
                int num = (int) (Math.random() * 50);
                list.add(num);
                ThreadUtils.log("Produced %d", num);
                list.notify();
            }
            ThreadUtils.sleep(100);
        }
    }
}
