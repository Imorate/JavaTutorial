package javacup.multithreading.basic;

import javacup.common.ThreadLogger;

public class NumberThread implements Runnable {
    @Override
    public void run() {
        for (char ch = '0'; ch <= '9'; ch++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                ThreadLogger.log("Interrupted");
                throw new RuntimeException(e);
            }
            ThreadLogger.log("%c", ch);
        }
    }
}
