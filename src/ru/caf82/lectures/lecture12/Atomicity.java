package ru.caf82.lectures.lecture12;

public class Atomicity extends Thread {
        volatile static int i;
        boolean b;

        public void run() {
            while (true) {
                if (b = !b) i++;
                else i--;
            }
        }

        public static void main(String[] args) {
//        new Atomicity().start();
            new Atomicity().start();

            while (true)
                System.out.println(i);
        }
    }

