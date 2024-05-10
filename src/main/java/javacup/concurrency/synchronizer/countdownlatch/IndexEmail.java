package javacup.concurrency.synchronizer.countdownlatch;

import javacup.common.ThreadUtils;

import java.util.concurrent.CountDownLatch;

public class IndexEmail implements Runnable {
    private final CountDownLatch countDownLatch;

    public IndexEmail(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        ThreadUtils.log("Index email started");
        ThreadUtils.sleep(100);
        ThreadUtils.log("Index email finished");
        countDownLatch.countDown();
        ThreadUtils.sleep(100);
        ThreadUtils.log("Index email finalized");
    }
}
