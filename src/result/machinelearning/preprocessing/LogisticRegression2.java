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
public class LogisticRegression2 implements MlModel, Serializable {
private float alpha;
private float betta;
private boolean parralize;
private float learnRate;
private Random initializer = new Random();
private int ITERATES=1000;
private double rate=0.001;

private double[] weights;
private boolean fitted = false;

   public LogisticRegression2(float alpha, float betta, int maxIter, float learnRate, boolean parralize) {}
   public static double sigmoid(double z){
       return 1/(1+Math.exp(-z));
   }   
   
   public void train(double[][] X, int[] y) throws InconveninentShapeException, EmptyArrayException {
       double zz=0;
       double pr=0;
       double delta[]=null;
       for(int u=0;u<ITERATES;u++){
           delta=new double[X.length];
           double lik=0;
           for(int i=0;i<X.length;i++){
               zz=MathService.doProduct(X[i], weights);
               pr=sigmoid(zz);
               for(int j=0;j<X.length;j++)delta[i]=(pr-y[i])*X[i][j];
               this.weights[i]=-(rate*delta[i]);
       }
       }
   }
   public static double ss(double[] X){
      double result=0;
       for(int i=0;i<X.length;i++)result=result+X[i]*weights[i];
       return result;
   }
   public double predict(double[] X) throws ModelNotFittedException, InconveninentShapeException {
       double ver=0;
       double v=
       ver =Math.exp(ss(X))/(1+Math.exp(ss(X)));
       return ver;
   }
   public double[] predictProba(double[] X) throws ModelNotFittedException, InconveninentShapeException {}
   public void saveToFile(String filename) throws IOException {}
   public double[] getWeights() {}
   public float getAlpha() {}
   public void setAlpha(float alpha) {}
   public float getBetta() {}
   public void setBetta(float betta) {}
   public int getMaxIter() {}
   public void setMaxIter(int maxIter) {}
   public boolean isParralize() {}
   public void setParralize(boolean parralize) {}
   public float getLearnRate() {}
   public void setLearnRate(float learnRate) {}
   private double lossFunction(double[][] X, double[] W, int[] y) throws InconveninentShapeException {}
   private double[] lossFunctionDerivative(double[][] X, double[] W,
                                           int[] y, float alpha, float betta) throws InconveninentShapeException {}
}
