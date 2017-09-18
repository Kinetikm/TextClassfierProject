package ru.caf82.lectures.diagramBomberman;

import ru.caf82.result.machinelearning.preprocessing.PorterStemmer;

/**
 * Created by ilysko on 18.09.17.
 */
public interface Movable extends Positioanable, Tickable{
    void move();
}
