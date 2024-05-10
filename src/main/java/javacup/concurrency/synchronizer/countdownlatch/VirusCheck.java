package javacup.concurrency.synchronizer.countdownlatch;

import javacup.common.ThreadUtils;

import java.util.concurrent.CountDownLatch;

public class VirusCheck implements Runnable {
    private final CountDownLatch countDownLatch;

    public VirusCheck(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        ThreadUtils.log("Scan started");
        ThreadUtils.sleep(100);
        ThreadUtils.log("Scan finished");
        countDownLatch.countDown();
        ThreadUtils.sleep(100);
        ThreadUtils.log("Virus check finalized");
    }
}
