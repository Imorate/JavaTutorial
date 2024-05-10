package javacup.multithreading.interrupt;

import javacup.common.ThreadUtils;

public class InterruptThread implements Runnable {

    @Override
    public synchronized void run() {
        try {
            wait();
            ThreadUtils.log("After wait");
        } catch (InterruptedException e) {
            ThreadUtils.log("Interrupted");

        }
        ThreadUtils.log("Resume");
    }
}
