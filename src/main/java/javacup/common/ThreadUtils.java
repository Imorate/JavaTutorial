package javacup.common;

public class ThreadUtils {
    public static void log(String template, Object... objects) {
        log(Thread.currentThread(), template, objects);
    }

    public static void log(Thread thread, String template) {
        log(thread, template, (Object) null);
    }

    public static void log(String template) {
        log(Thread.currentThread(), template, (Object) null);
    }

    public static void log(Thread thread, String template, Object... objects) {
        String threadDetails = String.format("%s-%s: ", thread.getId(), thread.getName());
        if (objects == null) {
            System.out.printf(threadDetails + template + "\n");
        } else {
            System.out.printf(threadDetails + template + "\n", objects);
        }
    }

    public static void sleep(long millis, int nanos) {
        try {
            Thread.sleep(millis, nanos);
        } catch (InterruptedException e) {
            log("Interrupted while sleeping");
        }
    }

    public static void sleep(long millis) {
        sleep(millis, 0);
    }

    public static void join(Thread thread, long millis) {
        try {
            thread.join(millis);
        } catch (InterruptedException e) {
            log("Interrupted for joining");
        }
    }

    public static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            log("Interrupted for joining");
        }
    }
}
