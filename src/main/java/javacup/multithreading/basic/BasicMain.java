package javacup.multithreading.basic;

import javacup.common.ThreadUtils;

public class BasicMain {
    public static void main(String[] args) {
        AlphabetThread alphabetThread = new AlphabetThread("AlphabetThread");
        Thread numberThread = new Thread(new NumberThread(), "NumberThread");

        alphabetThread.start();
        ThreadUtils.log(alphabetThread, "Started");
        numberThread.start();
        ThreadUtils.log(numberThread, "Started");

        if (args.length != 0) {
            if (args[0].equals("join")) {
                ThreadUtils.join(alphabetThread);
            }
        }
    }
}
