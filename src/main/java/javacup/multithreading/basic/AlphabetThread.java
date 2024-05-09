package javacup.multithreading.basic;

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
                System.err.println(this.getClass().getSimpleName() + ":\t" + "Interrupted");
                throw new RuntimeException(e);
            }
            System.out.println(this.getClass().getSimpleName() + ":\t" + ch);
        }
    }
}
