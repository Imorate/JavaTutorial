package javacup.concurrency.threadlocal;

import javacup.common.ThreadUtils;

public class ThreadLocalRunnable implements Runnable {
    private final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        threadLocal.set(threadLocal.get() == null ? 1 : threadLocal.get() + 1);
        ThreadUtils.log("ThreadLocal is " + threadLocal.get());
    }
}
