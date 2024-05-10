package javacup.multithreading.basicpc;

import javacup.common.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Thread[] threads = new Thread[4];

        for (int i = 0; i < threads.length / 2; i++) {
            threads[i] = new Thread(new Producer(list), "Producer");
        }
        for (int i = threads.length / 2; i < threads.length; i++) {
            threads[i] = new Thread(new Consumer(list), "Consumer");
        }

        for (Thread thread : threads) {
            thread.start();
            ThreadUtils.log("%s-%s started", thread.getId(), thread.getName());
        }

        for (Thread thread : threads) {
            ThreadUtils.join(thread);
        }

        ThreadUtils.log("Finished all threads with size of list: %d", list.size());
    }
}
