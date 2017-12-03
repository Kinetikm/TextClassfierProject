package ru.caf82.lectures.lecture11;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by ilysko on 20.11.17.
 */
public class Hack {
    final static String PATH = "/home/ilysko/Desktop/WorkLearn/Coding" +
            "/Java/JavaTeachingInMiphyaga/TextClassfierProject/";

    static void serToFile(Object object, String fileName) {
        try (FileOutputStream fileOut =
                     new FileOutputStream(PATH + fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);) {

            out.writeObject(object);
            out.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Object serFromFile(String fileName) {
        Object object = null;

        try (FileInputStream fileIn = new FileInputStream(PATH + fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn);) {

            object = in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

    public static void main(String[] args) {
        A a = new A();
//        B b = new B();
//        SingltoneC c = SingltoneC.createInstance(new Object(), "friend");

        String fileName = "task.ser";
        serToFile(a, fileName);
        A a_new = (A) serFromFile(fileName);
//        B b_new = (B) serFromFile(fileName);
//        SingltoneC c_new = (SingltoneC) serFromFile(fileName);

        Class clazz = a_new.getClass();

        for (Field field : clazz.getFields()) {
            System.out.println(field);
        }
    }
}

class SuperClassForA {
}

class A extends SuperClassForA implements Serializable {
    private Integer seeecreeeeeet;

    public A() {
        seeecreeeeeet = 657823485;
    }
}


abstract class SuperClassForB {
    String getHint() {
        throw new UnsupportedOperationException();
    }
    protected Integer[] getSecret(B b) {
        throw new UnsupportedOperationException();
    }
}

class B extends SuperClassForB implements Serializable {
    @Override
    String getHint() {
       return "Find non-zero answer";
    }

    @Override
    protected Integer[] getSecret(B b) {
        Integer[] ar = new Integer[1000];
        ar[654] = 4656656;
        return ar;
    }
}


class SuperClassForC {
    protected String getHint;
}

class SingltoneC extends SuperClassForC implements Serializable {
    private static SingltoneC instance = null;

    private SingltoneC(String val) throws Exception {
        throw new UnsupportedOperationException("Wrong way");
    }

    private SingltoneC(Integer val) throws Exception {
        if (val != 64726349) {
            throw new UnsupportedOperationException("Given val doesn't look good!");
        }
    }

    protected static SingltoneC createInstance(Object object, String neededVal) {
        if (!neededVal.equals("friend")) {
            throw new IllegalArgumentException("You need to solve problem!");
        }
        if (instance == null) {
            try {
                instance = new SingltoneC(64726349);
            } catch (Exception _) {}
            instance.getHint = "The Doors of Durin — Lord of Moria. Speak, friend, and enter.";
            return instance;
        }
        return instance;
    }
}