package javacup.concurrency.executor;

import java.util.concurrent.Callable;

public class WordLengthCallable implements Callable<Integer> {
    private final String name;

    public WordLengthCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() {
        return name.length();
    }
}
