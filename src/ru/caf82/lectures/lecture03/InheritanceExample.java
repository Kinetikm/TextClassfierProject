package ru.caf82.lectures.lecture03;

/**
 * Created by ilysko on 17.09.17.
 */
public class InheritanceExample {
    void tryToGetAnimalName(AbstractAnimal abstractAnimal) {
        // нисходящее преобразование
        abstractAnimal.sayYourName();

        // нельзя, т.к. мы работаем с AbstractAnimal
        //abstractAnimal.jump()
    }

    public static void main(String[] args) {
        AbstractAnimal tiger = new Tiger();
        tiger.move();
        tiger.sayYourName();
        System.out.println(tiger.legsAmount);
    }
}

class Tiger extends AbstractAnimal {

    protected Tiger() {
        super(4, "Tiger");
    }

    @Override
    public void move() {
        System.out.println("run");
    }

    public void jump() {
        System.out.println("jump");
    }
}


