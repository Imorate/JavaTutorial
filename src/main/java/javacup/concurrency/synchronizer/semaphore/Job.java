package javacup.concurrency.synchronizer.semaphore;

import javacup.common.ThreadUtils;

import java.util.concurrent.Semaphore;

public class Job implements Runnable {
    private final Semaphore semaphore;

    public Job(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            ThreadUtils.log("Job interrupted");
        }
        ThreadUtils.log("Job started");
        ThreadUtils.sleep(100);
        ThreadUtils.log("Job completed");
        semaphore.release();
    }
}
