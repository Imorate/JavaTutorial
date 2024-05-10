package javacup.multithreading.interrupt;

import javacup.common.ThreadUtils;

public class InterruptMain {
    public static void main(String[] args) {
        Thread interruptThread = new Thread(new InterruptThread(), "InterruptThread");
        interruptThread.start();
        ThreadUtils.log(interruptThread, "Started");
        ThreadUtils.sleep(1000);
        interruptThread.interrupt();
    }
}
