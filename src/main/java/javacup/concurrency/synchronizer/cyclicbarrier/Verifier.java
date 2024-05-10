package javacup.concurrency.synchronizer.cyclicbarrier;

import javacup.common.ThreadUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Verifier implements Runnable {
    private final CyclicBarrier cb1;
    private final CyclicBarrier cb2;

    public Verifier(CyclicBarrier cb1, CyclicBarrier cb2) {
        this.cb1 = cb1;
        this.cb2 = cb2;
    }

    @Override
    public void run() {
        ThreadUtils.log("Starting verifier");
        ThreadUtils.sleep(100);
        ThreadUtils.log("Verifying");
        ThreadUtils.sleep(100);
        ThreadUtils.log("Step one finished");
        try {
            cb1.await();
        } catch (InterruptedException e) {
            ThreadUtils.log("%s Interrupted", cb1);
        } catch (BrokenBarrierException e) {
            ThreadUtils.log("%s Broken barrier", cb1);
        }
        ThreadUtils.log("Step two finished");
        try {
            cb2.await();
        } catch (InterruptedException e) {
            ThreadUtils.log("%s Interrupted", cb2);
        } catch (BrokenBarrierException e) {
            ThreadUtils.log("%s Broken barrier", cb2);
        }
    }
}
