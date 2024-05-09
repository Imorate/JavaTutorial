package javacup.multithreading.basic;

public class NumberThread implements Runnable {
    @Override
    public void run() {
        for (char ch = '0'; ch <= '9'; ch++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.err.println(this.getClass().getSimpleName() + ":\t" + "Interrupted");
                throw new RuntimeException(e);
            }
            System.out.println(this.getClass().getSimpleName() + ":\t" + ch);
        }
    }
}
