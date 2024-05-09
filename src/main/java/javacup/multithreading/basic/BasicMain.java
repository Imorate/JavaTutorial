package javacup.multithreading.basic;

public class BasicMain {
    public static void main(String[] args) {
        AlphabetThread alphabetThread = new AlphabetThread("AlphabetThread");
        Thread numberThread = new Thread(new NumberThread(), "NumberThread");

        alphabetThread.start();
        numberThread.start();

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
