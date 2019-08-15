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
 * @author 1
 */
public class DivideOnZero {
    public static void main(String[] args)
    {
        /*try
        {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(1000/x);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Поймали ошибку со строкой! Е-еее!");
        }
        
        catch (ArithmeticException e)
        {
            System.out.println("Поймали ошибку с делением на 0! Е-еее");
        }
        
        finally
        {
            System.out.println("А тут мы всегда");
        } */
        
        System.out.println(f());
    }
    
   static int f()
    {
        try
        {
            return 3;
        }
        
        finally
        {
            return 2;
        }
    }
}
