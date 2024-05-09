package javacup.multithreading.interrupt;

import javacup.multithreading.common.ThreadLogger;

public class InterruptThread implements Runnable {

    @Override
    public synchronized void run() {
        try {
            wait();
            ThreadLogger.log("After wait");
        } catch (InterruptedException e) {
            ThreadLogger.log("Interrupted");

        }
        ThreadLogger.log("Resume");
    }
}
