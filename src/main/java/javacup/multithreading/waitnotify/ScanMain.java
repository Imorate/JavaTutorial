package javacup.multithreading.waitnotify;

import javacup.multithreading.common.ThreadLogger;

public class ScanMain {
    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public static void main(String[] args) throws InterruptedException {
        String str = "";
        Thread scanThread = new Thread(new ScanThread(str), "ScanThread");
        scanThread.start();
        ThreadLogger.log("Started");
        synchronized (str) {
            str.wait();
        }
        ThreadLogger.log("Other jobs");
    }
}
