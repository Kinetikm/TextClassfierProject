package ru.caf82.lectures.lecture12;

/**
 * Created by ilysko on 01.12.17.
 */
public class ThreadStatesExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getState());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(thread.getState());
        thread.start();
        Thread.sleep(20);
        System.out.println(thread.getState());
        Thread.sleep(100);
        System.out.println(thread.getState());
    }
}
