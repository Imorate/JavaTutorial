package javacup.concurrency.synchronizer.phaser;

import javacup.common.ThreadUtils;

import java.util.concurrent.Phaser;

public class PhaseJob implements Runnable {
    private final Phaser phaser;

    public PhaseJob(Phaser phaser) {
        this.phaser = phaser;
        phaser.register();
    }

    @Override
    public void run() {
        ThreadUtils.log("Phase 0 started");
        phaser.arriveAndAwaitAdvance();

        ThreadUtils.sleep(500);

        ThreadUtils.log("Phase 1 started");
        phaser.arriveAndAwaitAdvance();

        ThreadUtils.sleep(500);

        ThreadUtils.log("Phase 2 started");
        phaser.arriveAndDeregister();
    }
}
