/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.lectures.lecture03.Diagramma1;

/**
 *
 * @author Наташа
 */
public interface Positionable extends GameObject{
    int getXPosition();
    int getYPosition();
    void move();
}
