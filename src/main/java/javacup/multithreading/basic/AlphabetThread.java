package javacup.multithreading.basic;

import javacup.multithreading.common.ThreadLogger;

public class AlphabetThread extends Thread {

    public AlphabetThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                System.err.printf("%s-%s:\tInterrupted\n", this.getId(), this.getClass().getSimpleName());
                throw new RuntimeException(e);
            }
            ThreadLogger.log("%c", ch);
        }
    }
}
