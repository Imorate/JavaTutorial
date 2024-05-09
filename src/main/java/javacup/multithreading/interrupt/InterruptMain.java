package javacup.multithreading.interrupt;

import javacup.multithreading.common.ThreadLogger;

public class InterruptMain {
    public static void main(String[] args) throws InterruptedException {
        Thread interruptThread = new Thread(new InterruptThread(), "InterruptThread");
        interruptThread.start();
        ThreadLogger.log(interruptThread, "Started");
        Thread.sleep(1000);
        interruptThread.interrupt();
    }
}
