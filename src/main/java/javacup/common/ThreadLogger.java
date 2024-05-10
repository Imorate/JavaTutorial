package javacup.common;

public class ThreadLogger {
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
}
