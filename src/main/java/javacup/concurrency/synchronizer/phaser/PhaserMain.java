package javacup.concurrency.synchronizer.phaser;

import javacup.common.ThreadUtils;

import java.util.concurrent.Phaser;

public class PhaserMain {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        phaser.register();

        Thread phaserJob1 = new Thread(new PhaseJob(phaser));
        Thread phaserJob2 = new Thread(new PhaseJob(phaser));
        phaserJob1.start();
        phaserJob2.start();

        int currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        ThreadUtils.log("Phase %d finished", currentPhase);

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        ThreadUtils.log("Phase %d finished", currentPhase);

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        ThreadUtils.log("Phase %d finished", currentPhase);

        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) {
            ThreadUtils.log("Phaser is terminated");
        }
    }
}
