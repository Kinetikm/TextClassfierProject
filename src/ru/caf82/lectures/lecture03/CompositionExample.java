package ru.caf82.lectures.lecture03;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.DoublePredicate;

/**
 * Created by ilysko on 17.09.17.
 */
public class CompositionExample {
    Cat cat = new Cat(); // в точке определения
    Dog dog;
    Crocodile crocodile;
    Zoo zoo = new Zoo(new Animal[] {cat, dog, crocodile}); // с использованием инициализации экземпляров

    CompositionExample(Dog dog) {
        this.dog = dog; // в конструкторе
    }

    @Override
    public String toString() {
        if (crocodile == null) {
            this.crocodile = new Crocodile(); // перед использованием объекта
        }
        return "CompositionExample{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", crocodile=" + crocodile +
                ", zoo=" + zoo +
                '}';
    }

    public static void main(String[] args) {
        Dog dog = new Dog(true);
        CompositionExample compositionExample = new CompositionExample(dog);

        System.out.println(compositionExample.toString());

        compositionExample.crocodile.eatMeat();
        compositionExample.cat.sayMeow();
        System.out.println(compositionExample.dog.isFriendly);
        System.out.println(Arrays.toString(compositionExample.zoo.animals));
    }
}

abstract class Animal {}

class Cat extends Animal {
    int legCount = 4;
    void sayMeow() {
        System.out.println("Meow");
    }
}

class Dog extends Animal {
    boolean isFriendly;

    Dog(boolean isFriendly) {
        this.isFriendly = isFriendly;
    }
}

class Crocodile extends Animal {
    void eatMeat() {
        System.out.println("Delicious!");
    }
}

class Zoo {
    Animal[] animals;

    Zoo(Animal[] animals) {
        this.animals = animals;
    }

    void open() {
        System.out.println("open");
    }

    void close() {
        System.out.println("close");
    }
}
