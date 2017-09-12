/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.lectures.lecture02;

import java.util.Arrays;
import java.util.Random;


/**
 *
 * @author User
 */
public class MathService {
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
        int j=0;
        for(int i=0;i<x.length;i++){
            for(j=0;j<x[i].length;j++)SS=SS+x[i][j];
            SS=SS/x[i].length;
            for(j=0;j<x[i].length;j++)x[i][j]=Math.sqrt((x[i][j]-SS)*(x[i][j]-SS)/(x[i].length-1));
            
            SS=0;
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
        double [][] VV=new double [3][3];
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++)VV[x][y]=Rand.nextDouble();
        }
        System.out.println(Arrays.deepToString(VV));
        double BB[][]=MatrixNormalize(VV);
        System.out.println();
        System.out.println("AfterNormalize:");
        System.out.println(Arrays.deepToString(BB));
    }
}

