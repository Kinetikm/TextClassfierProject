package ru.caf82.lectures.lecture12;

/**
 * Created by ilysko on 01.12.17.
 */
public class DeamonExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        Runnable runnable = () -> {
            System.out.println("Am I evil? " +
                    (Thread.currentThread().isDaemon() ? "Yes, I am! (c) James Hetfield" : "No"));
        };
        Thread daemonThread = new Thread(runnable);

        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Finish");
    }
}
