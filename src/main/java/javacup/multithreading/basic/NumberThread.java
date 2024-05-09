package javacup.multithreading.basic;

public class NumberThread implements Runnable {
    @Override
    public void run() {
        for (char ch = '0'; ch <= '9'; ch++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.err.printf("%s-%s:\tInterrupted\n", Thread.currentThread().getId(), this.getClass().getSimpleName());
                throw new RuntimeException(e);
            }
            System.out.printf("%s-%s:\t%c\n", Thread.currentThread().getId(), this.getClass().getSimpleName(), ch);
        }
    }
}
