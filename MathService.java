/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.result.others;

/**
 *
 * @author Вика
 */
public class MathService {
 public static double dotProduct(double[] a, double[] b){
     double result = 0;
     for (int i = 0; i < a.length; i++) {
         result += a[i]*b[i];
     }
     
     
     return result;
 }   


public static double sigmoid(double x){
    
   double d = Math.exp(-x);
    
   double result = 1/(1+d);
    
    return result;
}
public static double sigmoid(double[] p, double[] w){
   double k = 0;
     for (int i = 0; i < p.length; i++) {
        k += p[i]*w[i];
     } 
     double f = Math.exp(-k);
    
   double result = 1/(1+f);
    
    return result;
}

public static void main(String[] args) {
 double x = 2;
  double[] a = {1, 2, 3, 4};        
 double[] b = {1, 1, 1, 1};
double[] p = {1, 1, 1, 1};        
 double[] w = {1, 1, 1, 1};
 
System.out.println(MathService.dotProduct(a,b));
System.out.println(MathService.sigmoid(x));
System.out.println(MathService.sigmoid(p,w));
}

}


