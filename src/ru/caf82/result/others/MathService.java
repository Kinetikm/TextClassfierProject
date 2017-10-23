/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.result.others;

import ru.caf82.result.exceptions.EmptyArrayException;
import ru.caf82.result.exceptions.InconveninentShapeException;

/**
 *
 * @author 1
 */
public class MathService {
    
    
    public static double dotProduct(double[] a, double[] b) throws InconveninentShapeException, EmptyArrayException
    {
        if (a.length == 0 || b.length == 0) {
            throw new EmptyArrayException();
        }
        
        if (a.length != b.length) {
            throw new InconveninentShapeException();
        }
        double result = 0;
       for (int i=0;i<a.length;i++)
           result += a[i] * b[i];
       
       return result;
    }
    public static double sigmoid(double x)
    {
        return 1/(1 + Math.exp(-x));
    }
    public static double sigmoid(double[] x,double[] w) throws InconveninentShapeException, EmptyArrayException
    {
      return  sigmoid(dotProduct(x,w));
    }
    
    public static double[] vectorNormalization(double[] x) throws EmptyArrayException
    {
        if (x.length == 0) {
            throw new EmptyArrayException();
        }
        
      if(x.length==1)
          return x;
        
        double average = 0;
      
      for (double element : x)
          average += element;
      
       average /= x.length;
      
      
       double D = 0;
       
      for (double element : x)
          D += Math.pow(element - average , 2);
      
      D /= x.length - 1;
      
    for (int i = 0; i < x.length; i++)
        
        x[i] = (x[i] - average) / Math.sqrt(D);
      
      return x;
    }
    
    public static double[][] matrixNormalization(double[][] x) throws EmptyArrayException
    {
        for (int i = 0; i < x.length; i++)
            x[i] = vectorNormalization(x[i]);
        
        return x;
    }
}
