package lesson6.srez;


public class ThreadStoped {

    private static volatile boolean threadWorks = true;

    public static boolean executeThread() {
        return threadWorks;
    }

    public static void stopedThreads() {
        ThreadStoped.threadWorks = false;
    }
}
