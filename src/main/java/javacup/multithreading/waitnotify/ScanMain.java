package javacup.multithreading.waitnotify;

import javacup.common.ThreadUtils;

public class ScanMain {
    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public static void main(String[] args) throws InterruptedException {
        String str = "";
        Thread scanThread = new Thread(new ScanThread(str), "ScanThread");
        scanThread.start();
        ThreadUtils.log("Started");
        synchronized (str) {
            str.wait();
        }
        ThreadUtils.log("Other jobs");
    }
}
