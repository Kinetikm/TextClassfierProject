/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.result.others;

import java.util.logging.Level;
import java.util.logging.Logger;
import ru.caf82.result.exception.EmptyArrayException;
import ru.caf82.result.exception.InconveninentShapeException;

/**
 *
 * @author admin
 */
public class MathService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] a = {1,2,3};
        //double[] b = {4,5,6};
        //double[] b = {4,5,6,7};
        double[] b = {};
        //double[] t = {1,2,0,3};
        double[] t = {};
        double x = 10;
        //double c = dotProduct(a,b);
        //double q = sigmoid(a,b);
       
        System.out.print("Scalar product of vectors : ");
        try{
            System.out.println(dotProduct(a, b));
        } catch (EmptyArrayException ex){
            System.out.println("Ошибка! Массив пустой. Вектор нулевой. Так нельзя!");
        } catch(InconveninentShapeException ex){
            System.out.println("Еееееее, поймал ошибку. Нельзя умножать вектора разной длины!!! ");
        }
        
        System.out.println("Sigmoid: " + sigmoid(x));
        
        System.out.print("Sigmoid of vectors: ");
        try {
            System.out.println(sigmoid(a,b));
        } catch (EmptyArrayException ex){
            System.out.println("Ошибка! Пустой массив!");
        } catch (InconveninentShapeException ex) {
            System.out.println("Лох, вектора-то разной длины!!!");
        }
        
        System.out.print("Vector Normalize: ");
        try{
          double[] k = vectorNormalize(t);
             for (int i = 0; i < k.length; i++){
             System.out.println(k[i]);
             } 
        } catch (EmptyArrayException ex) {
            System.out.println("Нулевой вектор нельзя нормализовать!!!");
        }
         
        
        System.out.print("Matrix normalize: ");
        try{
           //double[][] r = {{8,2,3},{1,5,6},{7,4,9}};
             double [][] r = {{},{1,3,4},{}};
             double[][] v = matrixNormalize(r);
            for (int j = 0; j < v.length; j ++){
            for (int w = 0; w < v[j].length; w++)
            System.out.print(v[j][w] + " ");
            System.out.println();
            }
        } catch (EmptyArrayException ex) {
            System.out.println("Нельзя нормализовать матрицу с пустыми строчками!!!");
        }
    
    }
    
    public static double dotProduct(double[] a, double[] b) throws EmptyArrayException, InconveninentShapeException {
        if ((a.length == 0)||( b.length == 0)) {
        throw new EmptyArrayException();
    } 
        else{
            if (a.length != b.length){
              throw new InconveninentShapeException();
        }
        else{
           double result = 0;
        
           for (int i = 0; i < a.length;){
            result += a[i]*b[i];
            i++;
        }
                return result;
        }
        }
        }
        
   
    public static double sigmoid (double x) {
     return (1/(1+Math.exp(-x)));  
}
    
    public static double sigmoid(double[] x, double[] w) throws InconveninentShapeException, EmptyArrayException{
        double result = dotProduct(x,w);
        result = sigmoid(result);
        return result;
        
        
    }
    

    public static double[] vectorNormalize(double[] x) throws EmptyArrayException{
        if (x.length == 0) {
            throw new EmptyArrayException();
        } else {
        double mid = 0, d = 0;
        double[] result = new double[x.length];
        for (int i = 0; i < x.length; i++){
            mid += x[i];
        }
            mid = mid / x.length;
        for (int j = 0; j < x.length; j++){
            d += Math.pow((x[j]-mid),2);
        }    
            d = Math.sqrt(d / (x.length - 1));
        for (int q = 0; q < x.length; q++){
            result[q] = (x[q] - mid)/d;
        }
        
        return result;
        }
    }
    
    public static double[][] matrixNormalize(double[][] x) throws EmptyArrayException {
        if (x.length == 0){
            throw new EmptyArrayException();
        }
        double[][] result = new double[x.length][x[0].length];
        for (int i = 0; i < x.length; i++){
            result[i] = vectorNormalize(x[i]);
        }
        return result;
    }
    
    
}


