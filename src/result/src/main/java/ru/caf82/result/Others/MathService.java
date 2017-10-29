/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package result.src.main.java.ru.caf82.result.Others;

/**
 *
 * @author Наташа
 */
public class MathService {
    public static double dotProduct(double[] a, double[] b){
    double result = 0  ;
    for (int i = 0; i<a.length; i++) {
        result +=a[i]*b[i];
    }
    return result;
    }
    public static double sigmoid(double x){
        double result=1/(1+Math.exp(-x));
        return result;
    } 
     public static double sigmoid2(double[] x, double[] w){
     return sigmoid(dotProduct(x, w)); 
     }
     public static double[][] NormalizationMatrix(double[][] x) {    
     for (int j = 0; j<x.length; j++){     
     double result = 0 ;
      for (int i = 0; i<x[j].length; i++){
          result += x[j][i];
      }
      result /= x[j].length;
      double dis = 0;
      for (int t = 0; t<x[j].length; t++){
       int b=2;   
       dis += Math.pow(x[j][t]-result, b);
      }
      dis /= (x[j].length-1);
      for (int s = 0; s<x[j].length; s++){
       x[j][s] = (x[j][s]-result)/Math.sqrt(dis);
     }
     }
    return x;
     } 
}
