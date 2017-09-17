package ru.caf82.lectures.lecture02;

import java.util.Arrays;

/**
 * Created by ilysko on 11.09.17.
 */
public class MathService {

    public static float dotProduct(double[] a, double[] b) {
        float result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }

        return result;
    }

    public static double[] vectorNormalize (double[] x) {
        double average = 0, denom = 0;
        double[] result = new double[x.length];
        for (int i=0; i<x.length; i++) {
            average+=x[i];
        }
        average=average/x.length;
        for (int j=0; j<x.length; j++) {
            denom+=Math.pow((x[j]-average), 2);
        }
        denom=Math.sqrt(denom/(x.length-1));
        for (int k=0; k<x.length; k++) {
            result[k]= (x[k]-average)/denom;
        }
        return result;
    }

    public static double[][] matrixNormalize(double[][] x) {
        double[][] result = new double[x.length][];
        for (int i=0; i<x.length; i++) {
            result[i] = new double [x[i].length];
            result[i] = vectorNormalize(x[i]);
        }
        return result;
    }

    public static double[][] matrixNormalize2(double[][] X) {
        double meanValue;
        double stdValue = 0;
        for(int i = 0; i < X.length; i++) {
            meanValue = Arrays.stream(X[i]).sum() / X[i].length;
            for(double value : X[i]) {
                stdValue += (value - meanValue) * (value - meanValue);
            }
            stdValue /= (X[i].length - 1);
            if(stdValue != 0) {
                for(int j = 0; j < X[i].length; j++) {
                    X[i][j] = (X[i][j] - meanValue) / Math.sqrt(stdValue);
                }
            }
        }
        return X;
    }

    public static void main(String[] args) {
        double[][] list = {{1,2,3},{4,5,6}};
        double[][] newList = matrixNormalize(list);
        double[][] newList2 = matrixNormalize2(list);
        for (int i=0; i<newList.length; i++) {
            for (int j=0; j<newList[i].length; j++) {
                System.out.println(newList[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i=0; i<newList2.length; i++) {
            for (int j=0; j<newList2[i].length; j++) {
                System.out.println(newList2[i][j]);
            }
            System.out.println();
        }
    }
}