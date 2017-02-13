package lesson6.srez;

/**
 * Created by yuri on 13.02.17.
 */
public class ThreadStoped {

    private static volatile boolean threadWorks = true;

    public static boolean executeThread() {
        return threadWorks;
    }

    public static void stopedThreads() {
        ThreadStoped.threadWorks = false;
    }
}
