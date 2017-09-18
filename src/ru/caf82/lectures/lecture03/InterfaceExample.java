package ru.caf82.lectures.lecture03;

/**
 * Created by ilysko on 17.09.17.
 */
public interface InterfaceExample {
    default void printSomething() {
        System.out.println("Something");
    }

    String returnName();

    // можно не писать static final, это "по умолчанию"
    static final int amount1 = 3;
    int amount2 = 4;

}
