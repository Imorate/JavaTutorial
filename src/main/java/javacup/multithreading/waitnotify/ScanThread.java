package javacup.multithreading.waitnotify;

import javacup.common.ThreadUtils;

public class ScanThread implements Runnable {
    private final String str;

    public ScanThread(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        ThreadUtils.sleep(1000);
        ThreadUtils.log("Scan");
        synchronized (str) {
            str.notify();
        }
        ThreadUtils.log("Other jobs");
    }
}
