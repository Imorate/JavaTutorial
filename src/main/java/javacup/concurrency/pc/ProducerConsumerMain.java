package javacup.concurrency.pc;

import javacup.common.ThreadUtils;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        int threadCount = 4;
        Thread[] threads = new Thread[threadCount];
        ArrayBlockingQueue<Integer> array = new ArrayBlockingQueue<>(10);

        for (int i = 0; i < threadCount / 2; i++) {
            threads[i] = new Thread(new Producer(array));
        }
        for (int i = threadCount / 2; i < threadCount; i++) {
            threads[i] = new Thread(new Consumer(array));
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                ThreadUtils.log("Interrupted");
            }
        }
    }
}
