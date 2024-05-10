package javacup.multithreading.basic;

import javacup.common.ThreadUtils;

public class NumberThread implements Runnable {
    @Override
    public void run() {
        for (char ch = '0'; ch <= '9'; ch++) {
            ThreadUtils.sleep(400);
            ThreadUtils.log("%c", ch);
        }
    }
}
