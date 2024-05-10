package javacup.multithreading.basic;

import javacup.common.ThreadLogger;

public class BasicMain {
    public static void main(String[] args) {
        AlphabetThread alphabetThread = new AlphabetThread("AlphabetThread");
        Thread numberThread = new Thread(new NumberThread(), "NumberThread");

        alphabetThread.start();
        ThreadLogger.log(alphabetThread, "Started");
        numberThread.start();
        ThreadLogger.log(numberThread, "Started");

        if (args.length != 0) {
            if (args[0].equals("join")) {
                try {
                    alphabetThread.join();
                } catch (InterruptedException e) {
                    System.err.println("Main thread interrupted");
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
