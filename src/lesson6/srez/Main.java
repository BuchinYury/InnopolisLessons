package lesson6.srez;

import java.util.Random;

/**
 * Created by yuri on 13.02.17.
 */
public class Main {

    public static void main(String[] args) {

        NumberBuffer buffer = new NumberBuffer();

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Random random = new Random();
                int randomNumber;

                if (ThreadStoped.executeThread()){
                    while (true) {
                        if (ThreadStoped.executeThread()) {
                            randomNumber = random.nextInt(100);
                            buffer.setNumber(randomNumber);
                            System.out.println(randomNumber);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (ThreadStoped.executeThread()){
                    while (true) {
                        if (ThreadStoped.executeThread()) {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(buffer.getNumbers());
                            System.out.println("Размер буфера: " + buffer.getSize());
                        }
                    }
                }

            }
        });

        thread.start();
        thread1.start();
    }

}
