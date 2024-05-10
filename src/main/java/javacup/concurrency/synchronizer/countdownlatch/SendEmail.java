package javacup.concurrency.synchronizer.countdownlatch;

import javacup.common.ThreadUtils;

import java.util.concurrent.CountDownLatch;

public class SendEmail implements Runnable {
    private final CountDownLatch countDownLatch;

    public SendEmail(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            ThreadUtils.log("Send email interrupted");
        }
        ThreadUtils.log("Send email started");
        ThreadUtils.sleep(100);
        ThreadUtils.log("Send email finished");
        ThreadUtils.sleep(100);
        ThreadUtils.log("Send email finalized");
    }
}
