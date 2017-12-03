package ru.caf82.lectures.lecture12;

/**
 * Created by ilysko on 03.12.17.
 */
public class InterruptExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 100; ++i) {
               System.out.println("i=" + i);
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        t1.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
