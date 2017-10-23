package ru.caf82.lectures.lecture04;

/**
 * Created by ilysko on 24.09.17.
 */
public class WorkWithExceptions {
    void ignore() throws Exception {
        throw new Exception();
    }

    void catchHere() {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Lol, i caught it just here!");
        }
    }

    void throwAhead() {
        try {
            ignore();
        } catch (Exception e) {
            System.out.println("We didn't try to catch exception in ignore(). " +
                    "We did it here");
        }
    }

    void createNewExceptionWhileWorkingWithOld() throws MyExceptionClassExample {
        try {
            ignore();
        } catch (Exception e) {
            System.out.println("do smth");
            throw new MyExceptionClassExample(e);
        }
    }
}
