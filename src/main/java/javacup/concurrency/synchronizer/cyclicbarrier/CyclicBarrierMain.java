package javacup.concurrency.synchronizer.cyclicbarrier;

import javacup.common.ThreadUtils;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {
    public static void main(String[] args) {
        CyclicBarrier cb1 = new CyclicBarrier(2, () -> ThreadUtils.log("All step one verify accomplished"));
        CyclicBarrier cb2 = new CyclicBarrier(2, () -> ThreadUtils.log("All step two verify accomplished"));
        Thread verifier1 = new Thread(new Verifier(cb1, cb2));
        Thread verifier2 = new Thread(new Verifier(cb1, cb2));
        verifier1.start();
        verifier2.start();
    }
}
