package ru.caf82.lectures.lecture03;

import java.util.Arrays;

/**
 * Created by ilysko on 17.09.17.
 */
public class PassByValue {
    static void changePrimitiveInt(int a) {
        a++;
    }

    static void changeReferenceInteger(Integer a) {
        a++;
    }

    static void replaceReferenceInteger(Integer a) {
        a = new Integer(42);
    }

    static void changeStringArray(String[] listOfBands) {
        listOfBands[2] = "Guns N' Roses";
    }

    static void doSomethingBad(String[] listOfBands) {
        listOfBands = new String[]{"Justin Bieber", "Тимати"};
    }

    public static void main(String[] args) {
        int a1 = 2;

        changePrimitiveInt(a1);
        System.out.println("int primitive after changePrimitiveInt() : " + a1);

        Integer a2 = new Integer(2);

        changeReferenceInteger(a2);
        System.out.println("Integer object after changeReferenceInteger() : " + a2);

        replaceReferenceInteger(a2);
        System.out.println("Integer object after replaceReferenceInteger() : " + a2);

        String[] listOfBands = {"Led Zeppelin", "Pink Floyd", ""};

        changeStringArray(listOfBands);
        System.out.println("String[] after changeStringArray() : " + Arrays.toString(listOfBands));

        doSomethingBad(listOfBands);
        System.out.println("String[] after something bad : " + Arrays.toString(listOfBands));
    }
}
