package ru.caf82.lectures.lecture03;

/**
 * Created by ilysko on 16.09.17.
 */
public abstract class AbstractAnimal {
    final int legsAmount;
    final String animalName;

    public abstract void move();

    public void sayYourName() {
        System.out.println("My name is " + animalName);
    }

    protected AbstractAnimal(int legsAmount, String animalName) {
        this.legsAmount = legsAmount;
        this.animalName = animalName;
    }
}
