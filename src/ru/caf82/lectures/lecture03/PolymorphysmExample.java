package ru.caf82.lectures.lecture03;

/**
 * Created by ilysko on 17.09.17.
 */
public class PolymorphysmExample {
    static void wash(Washable washable) {
        System.out.println("cleaning " + washable.toString());
    }

    public static void main(String[] args) {
        Kitty kitty = new Kitty();
        Dishware dishware = new Dishware();

        wash(kitty);
        wash(dishware);
    }
}

interface Washable{}

class Kitty implements Washable {
    @Override
    public String toString() {
        return "Kitty";
    }
}

class Dishware implements Washable {
    @Override
    public String toString() {
        return "Dishware";
    }
}