package javacup.concurrency.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Job(semaphore), "Job");
            threads[i].start();
        }
    }
}
