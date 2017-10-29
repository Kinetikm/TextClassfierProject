package ru.caf82.lectures.lecture04;

/**
 * Created by ilysko on 24.09.17.
 */
public class StackTraceExample {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("---------------");
        g();
        System.out.println("---------------");
        h();
    }
}
