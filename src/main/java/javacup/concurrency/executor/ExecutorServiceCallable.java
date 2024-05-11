package javacup.concurrency.executor;

import javacup.common.ThreadUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Set<String> names = new HashSet<>();
        names.add("Ali");
        names.add("Amir");
        names.add("Mohammad");

        Set<Future<Integer>> futures = new HashSet<>();

        for (String name : names) {
            Callable<Integer> wordLengthCallable = new WordLengthCallable(name);
            Future<Integer> future = executorService.submit(wordLengthCallable);
            futures.add(future);
        }

        int sum = 0;
        for (Future<Integer> future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                ThreadUtils.log("Interrupted");
            } catch (ExecutionException e) {
                ThreadUtils.log("Execution exception");
            }
        }
        System.out.println("Sum of names length: " + sum);
    }
}
