/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Random;
import Exceptions.InconveninentShapeException;

/**
 *
 * @author User
 */
public class MathService {
    MathService(){

    }
    MathService(String message){
        
    }
    MathService(String message, Throwable cause){
        
    }
    MathService(Throwable cause){
        
    }
    public static double doProduct(double[] a, double[] b){
        double result=0;
        for (int x=0;x<a.length;x++)result=result+a[x]*b[x];
        return result;
    }
    public static double sigmoid(double x){
        return (1/(1+Math.exp(-x)));
    }
    public static double sigmoid(double[] x, double[] w){
        double result;
        double MMM=doProduct(x,w);
        result=1/(1+Math.exp(MMM));
        return result;
    }
    public static double[][] MatrixNormalize(double [][] x){
        double SS=0;
        double DD=0;
        int j=0;
        for(int i=0;i<x.length;i++){
            for(j=0;j<x[i].length;j++)SS=SS+x[i][j];
            SS=SS/x[i].length;
            System.out.println("Medium "+SS);
            for(j=0;j<x[i].length;j++)DD=DD+(x[i][j]-SS)*(x[i][j]-SS)/(x[i].length-1);
            for(j=0;j<x[i].length;j++)x[i][j]=(x[i][j]-SS)/Math.sqrt(DD);
            SS=0;
            DD=0;
        }
        return x;
    }
    public static void main(String[] args){
        Random Rand=new Random();
        double []xx=new double[3];
        double []yy=new double[3];
        for(int x=0;x<3;x++){
            xx[x]=Rand.nextDouble();
            yy[x]=Rand.nextDouble();
        }
        System.out.println("XX: ");
        for(int x=0;x<3;x++)System.out.print(xx[x]+" ");
        System.out.println();
        System.out.println("YY: ");
        for(int x=0;x<3;x++)System.out.print(yy[x]+" ");
        double ZZ=doProduct(xx,yy);
        System.out.println();
        System.out.println("After doProduct: "+ZZ);
        double CC=12.44d;
        ZZ=sigmoid(CC);
        System.out.println();
        System.out.println("After sigmoid: "+ZZ);
        ZZ=sigmoid(xx,yy);
        System.out.println("After sigmoid for Matrix: "+ZZ);
        double [][] VV={{1d,2d,4d},{4d,5d,6d},{7d,8d,9d}};       
        System.out.println(Arrays.deepToString(VV));
        double BB[][]=MatrixNormalize(VV);
        System.out.println();
        System.out.println("AfterNormalize:");
        System.out.println(Arrays.deepToString(BB));
    }
}

 
