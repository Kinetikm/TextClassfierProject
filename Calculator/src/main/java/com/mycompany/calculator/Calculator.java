/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator;

/**
 *
 * @author Наташа
 */
public class Calculator {
float c;
    public Calculator() {
    }
    
    public  float add(float a, float b) {
        c= a+b;
        return c;
    }
    public  float sub(float a, float b) {
        c = a-b;
        return c;
    }
    public  float mul(float a, float b) {
         c = a*b;
        return c;
    }
    public long div(long a, long b) {
        try {
        return a/b;
        }catch (java.lang.ArithmeticException e) {
            throw new ArithmeticException();
        }
    }
    
   public static void main(String[] args) {
       
   }
}
