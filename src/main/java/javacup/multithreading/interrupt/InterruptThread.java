package javacup.multithreading.interrupt;

public class InterruptThread implements Runnable {

    @Override
    public synchronized void run() {
        Thread currentThread = Thread.currentThread();
        try {
            wait();
            System.out.printf("%s-%s: After wait\n", currentThread.getId(), currentThread.getName());
        } catch (InterruptedException e) {
            System.out.printf("%s-%s: Interrupted\n", currentThread.getId(), currentThread.getName());
        }
        System.out.printf("%s-%s: Resume\n", currentThread.getId(), currentThread.getName());
    }
}
