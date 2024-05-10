package javacup.multithreading.basicpc;

import javacup.common.ThreadLogger;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerMain {
    public static void main(String[] args) throws InterruptedException {
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
            ThreadLogger.log("%s-%s started", thread.getId(),thread.getName());
        }

        for (Thread thread : threads) {
            thread.join();
        }

        ThreadLogger.log("Finished all threads with size of list: %d", list.size());
    }
}
