package javacup.multithreading.basic;

import javacup.common.ThreadUtils;

public class AlphabetThread extends Thread {

    public AlphabetThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            ThreadUtils.sleep(200);
            ThreadUtils.log("%c", ch);
        }
    }
}
