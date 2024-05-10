package javacup.concurrency.synchronizer.semaphore.pc;

import javacup.common.ThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreMain {
    public static void main(String[] args) {
        int threadCount = 4;
        Thread[] threads = new Thread[threadCount];

        List<Integer> list = new ArrayList<>();
        Semaphore semaphore = new Semaphore(0);

        for (int i = 0; i < threadCount / 2; i++) {
            threads[i] = new Thread(new Producer(list, semaphore), "Producer");
        }

        for (int i = threadCount / 2; i < threads.length; i++) {
            threads[i] = new Thread(new Consumer(list, semaphore), "Consumer");
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
