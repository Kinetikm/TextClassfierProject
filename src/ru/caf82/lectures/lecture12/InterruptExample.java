package ru.caf82.lectures.lecture12;

/**
 * Created by ilysko on 03.12.17.
 */
public class InterruptExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           int i = 0;
            while (!Thread.currentThread().isInterrupted() && i < 100) {
               System.out.println("i=" + i);
               ++i;
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
//                   return;
                   Thread.currentThread().interrupt();
               }
           }
        });

        t1.start();
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}