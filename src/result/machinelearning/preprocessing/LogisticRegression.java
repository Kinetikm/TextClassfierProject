/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.machinelearning.preprocessing;

import Exeptions.EmptyArrayException;
import Exeptions.InconveninentShapeException;
import java.io.Serializable;
import java.util.Random;
import Other.MathService;

/**
 *
 * @author User
 */
public class LogisticRegression implements MlModel, Serializable {
private float alpha;
private float betta;
private boolean parralize;
private float learnRate;
private Random initializer = new Random();
private int ITERATES=1000;
private double rate=0.001;

private double[] weights;
private boolean fitted = false;

  // public LogisticRegression2(float alpha, float betta, int maxIter, float learnRate, boolean parralize) {}
   public static double sigmoid(double z){
       return 1/(1+Math.exp(-z));
   }   
   static public double[][] init(double[][]X){
       int i,j;
       double [][]Y=new double[X.length][X.length+1];
       for(i=0;i<X.length;i++){
           Y[i][1]=1;
           for(j=1;j<X[i].length+1;j++)Y[i][j]=X[i][j];
       }
       return Y;
   };
   public void train(double[][] X, int[] y) throws InconveninentShapeException, EmptyArrayException {
       double zz=0;
       double pr=0;
       double []sumdelta;
       int i,j;
       weights=new double[X.length+1];
       X=init(X);
       double delta[]=null;
       sumdelta=new double[X.length];
       for(int u=0;u<ITERATES;u++){
           delta=new double[X.length];
           for(i=0;i<X.length;i++){
               zz=MathService.doProduct(X[i], weights);
               pr=sigmoid(zz);
               for(j=0;j<X[i].length;j++)delta[i]=(pr-y[i])*X[i][j];
               for(i=0;i<X.length;i++) sumdelta[i]=sumdelta[i]+delta[i];
       }
           for(i=0;i<X.length;i++) sumdelta[i]=sumdelta[i]/X.length;
           for(i=0;i<X.length;i++)weights[i]=weights[i]-rate*sumdelta[i];
       }
   }
   public double ss(double[] X){
      double result=0;
       for(int i=0;i<X.length;i++)result=result+X[i]*weights[i];
       return result;
   }
   public double predict(double[] X) throws InconveninentShapeException {
       double ver=0;
       double v=0;
       ver =Math.exp(ss(X))/(1+Math.exp(ss(X)));
       if(ver>0.5)System.out.println("It is a dog");else if(ver<0.4)System.out.println("It is a cat");
       else System.out.println("I don't know");
       return ver;
   }
   
}
//   public double[] predictProba(double[] X) throws ModelNotFittedException, InconveninentShapeException {}
//   public void saveToFile(String filename) throws IOException {}
//   public double[] getWeights() {}
//   public float getAlpha() {}
//   public void setAlpha(float alpha) {}
//   public float getBetta() {}
//   public void setBetta(float betta) {}
//   public int getMaxIter() {}
//   public void setMaxIter(int maxIter) {}
//   public boolean isParralize() {}
//   public void setParralize(boolean parralize) {}
//   public float getLearnRate() {}
//   public void setLearnRate(float learnRate) {}
//   private double lossFunction(double[][] X, double[] W, int[] y) throws InconveninentShapeException {}
//   private double[] lossFunctionDerivative(double[][] X, double[] W,
//                                           int[] y, float alpha, float betta) throws InconveninentShapeException {}
//}
