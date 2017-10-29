package ru.caf82.lectures.lecture04;

/**
 * Created by ilysko on 24.09.17.
 */
public class MyExceptionClassExample extends TemplateForMyExceptionClass {
    int amountOfSmth;

    void someMethod() {
        System.out.println(amountOfSmth);
    }

    void f() {
        someMethod();
    }

    public MyExceptionClassExample() {
        super();
    }

    public MyExceptionClassExample(Exception e) {
        super(e);
    }

    public MyExceptionClassExample(int amountOfSmth) {
        super();
        this.amountOfSmth = amountOfSmth;
    }

    public MyExceptionClassExample(String messageFullOfAnger) {
        super(messageFullOfAnger);
    }

    public static void main(String[] args) {
        System.out.println("let's throw an exception!");
//        throw new MyExceptionClassExample("lol");
    }
}

class TemplateForMyExceptionClass extends Exception {
    TemplateForMyExceptionClass() {
        super();
    }

    TemplateForMyExceptionClass(String message) {
        super(message);
    }

    TemplateForMyExceptionClass(Exception e) {
        super(e);
    }
}
