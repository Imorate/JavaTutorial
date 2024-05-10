package javacup.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread sendEmailThread = new Thread(new SendEmail(countDownLatch), "Send email");
        Thread virusCheck = new Thread(new VirusCheck(countDownLatch), "Virus check");
        Thread indexEmail = new Thread(new IndexEmail(countDownLatch), "Index email");
        sendEmailThread.start();
        virusCheck.start();
        indexEmail.start();
    }
}
