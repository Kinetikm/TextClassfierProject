package ru.caf82.lectures.lecture12;

/**
 * Created by ilysko on 03.12.17.
 */
public class JoinExample {
    static void withJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; ++i) {
                System.out.println("t1, i=" + i);
            }
        });

        System.out.println("Start");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
    }

    static void withoutJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; ++i) {
                System.out.println("t1, i=" + i);
            }
        });

        System.out.println("Start");
        t1.start();
        System.out.println("Finish");
    }

    static void withTimedJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; ++i) {
                System.out.println("t1, i=" + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Start");
        t1.start();
        try {
            t1.join(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
    }

    public static void main(String[] args) {
        withJoin();
//        withoutJoin();
//        withTimedJoin();
    }
}
