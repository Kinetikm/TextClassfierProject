/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.lectures.lecture04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Наташа
 */
public class Delete {
    public static void main (String[] args){
        try {Scanner S = new Scanner(System.in);
        int val = S.nextInt();
        System.out.println(1000/val);
            
        }catch (InputMismatchException |ArithmeticException e){
            System.out.println("EEE");
        } finally {
            System.out.println("ugugre");
        }
        
    }
    
}
