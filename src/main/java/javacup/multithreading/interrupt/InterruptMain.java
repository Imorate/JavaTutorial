package javacup.multithreading.interrupt;

public class InterruptMain {
    public static void main(String[] args) throws InterruptedException {
        Thread interruptThread = new Thread(new InterruptThread(), "InterruptThread");
        interruptThread.start();
        Thread.sleep(1000);
        interruptThread.interrupt();
    }
}
