package javacup.concurrency.synchronizer.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerMain {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread firstExchanger = new Thread(new ExchangerThread(exchanger, "Hello"), "First");
        Thread secondExchanger = new Thread(new ExchangerThread(exchanger, "World"), "Second");
        firstExchanger.start();
        secondExchanger.start();
    }
}
