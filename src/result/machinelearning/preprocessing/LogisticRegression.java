/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.machineLearning.preprocessing;
/**
 *
 * @author User
 */
import Exeptions.InconveninentShapeException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import result.machinelearning.preprocessing.MlModel;
public class LogisticRegression implements MlModel, Serializable{
private float alpha;
private float betta;
private int maxIter;
private boolean parralize;
private float learnRate;
private Random initializer = new Random();
private double[] weights;
private int ITERATIONS=1000;
private boolean fitted = false;
public static class Instance {
public int label;
public int[] x;

public Instance(int label, int[] x) {
this.label = label;
this.x = x;
}
}
private double classify(int[] x) {
double logit = .0;
for (int i=0; i<weights.length;i++) {
logit += weights[i] * x[i];
}
return sigmoid(logit);
}
private static double sigmoid(double z){
    return 1.0/(1.0+Math.exp(-z));
}


 public LogisticRegression(float alpha, float betta, int maxIter, float learnRate, boolean parralize) {}
   
 
       public void train(List<Instance> instances) {
 for (int n=0; n<ITERATIONS; n++) {
 double lik = 0.0;
 for (int i=0; i<instances.size(); i++) {
 int[] x = instances.get(i).x;
 double predicted = classify(x);
 int label = instances.get(i).label;
 for (int j=0; j<weights.length; j++) {
 weights[j] = weights[j] + rate * (label - predicted) * x[j];
 }
 // not necessary for learning
 lik += label * Math.log(classify(x)) + (1-label) * Math.log(1- classify(x));
 }
 System.out.println("iteration: " + n + " " + Arrays.toString(weights) + " mle: " + lik);
 }
 }

       /*double []sm1=null;
       double []sm2=null;
       double []z=null;
       for(int i=0;i<X.length;i++){
           weights=new double[X.length];
           z=new double[X.length];
           for(int j=0;j<X.length;j++)z[i]=z[i]+weights[j]*X[i][j];
               }
       for(int i=0;i<X.length;i++){
           weights=new double[X.length];
           sm1=new double[X.length];
           sm2=new double[X.length];
           for(int j=0;j<X.length;j++){
           sm1[i]=sm1[i]*Math.log(1/(1+Math.exp(-z[i])));
           sm1[i]=sm1[i]*Math.log(1/(1+Math.exp(-z[i])));
       }
   }*/
   }
   public int predict(double[] X) throws ModelNotFittedException, InconveninentShapeException 
   {
   }
   public double[] predictProba(double[] X)// throws ModelNotFittedException, InconveninentShapeException 
    {
       
    }
   public void saveToFile(String filename) throws IOException {
       File Input = new File(filename);
            try{
                if(!Input.exists())Input.createNewFile();
            }
            catch(IOException e){
                throw new RuntimeException(e);
            }
            System.out.println("Write the text");
            double s=0;
            for(double x: weights)s=x;
            FileWriter fr = null;
            BufferedWriter br = null;
            try {
                fr = new FileWriter(Input,true);
                br = new BufferedWriter(fr);
                br.newLine();
                br.append((char) s);                        
            } 
            catch (IOException e) {
                e.printStackTrace();
            } 
            finally{
                try {
                    br.close();
                    fr.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
   }
   public double[] getWeights() {
       return;
   }
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
