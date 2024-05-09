package javacup.multithreading.waitnotify;

import javacup.multithreading.common.ThreadLogger;

public class ScanThread implements Runnable {
    private final String str;

    public ScanThread(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            ThreadLogger.log(e.getMessage());
        }
        ThreadLogger.log("Scan");
        synchronized (str) {
            str.notify();
        }
        ThreadLogger.log("Other jobs");
    }
}
