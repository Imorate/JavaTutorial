package javacup.concurrency.synchronizer.exchanger;

import javacup.common.ThreadUtils;

import java.util.concurrent.Exchanger;

public class ExchangerThread implements Runnable {
    private final Exchanger<String> exchanger;
    private final String data;

    public ExchangerThread(Exchanger<String> exchanger, String data) {
        this.exchanger = exchanger;
        this.data = data;
    }

    @Override
    public void run() {
        String newData = "";
        try {
            newData = exchanger.exchange(data);
        } catch (InterruptedException e) {
            ThreadUtils.log("Interrupted");
        }
        ThreadUtils.log("Exchange: %s for %s", data, newData);
    }
}
