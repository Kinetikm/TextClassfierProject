package ru.caf82.lectures.lecture12;

/**
 * Created by ilysko on 01.12.17.
 */
public class MyFirstThread {
    public static void main(String[] args) {

        class MyThread extends Thread {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(this.getClass().getSimpleName() + ": " + i);
                        Thread.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                    try {
                        for (int i = 0; i < 10; ++i) {
                            System.out.println("Runnable: " + i);
                            Thread.sleep(1);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        };

        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        try {
            for (int i = 0; i < 10; ++i) {
                System.out.println("Main: " + i);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
