package lesson6.srez;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuri on 13.02.17.
 */
public class NumberBuffer {

    private Set<Integer> set = new HashSet<>();

    public synchronized void setNumber(int number) {
        set.add(number);
        notifyAll();
    }

    public synchronized String getNumbers() {
        while (set.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String result = set.toString();

        if (set.size() > 98) ThreadStoped.stopedThreads();

        notifyAll();
        return result;
    }

    public synchronized int getSize(){
        return set.size();
    }

}

