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

    public static double[][] matrixNormalizeBelonogova(double[][] x) {
        double[][] result = new double[x.length][];
        for (int i=0; i<x.length; i++) {
            result[i] = new double [x[i].length];
            result[i] = vectorNormalize(x[i]);
        }
        return result;
    }

    public static double[] vectorNormalizeSofia(double[] x){
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

    public static double[][] matrixNormalizeSofia(double[][] x){
        double[][] result = new double[x.length][x[0].length];
        for (int i = 0; i < x.length; i++){
            result[i] = vectorNormalize(x[i]);
        }
        return result;
    }

    public static double[][] matrixNormalizeSychev(double [][] x){
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

    public static double[][] normalizationMatrixBal(double[][] x) {
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

    public static double[][] matrixNormalizeMisha(double[][] X) {
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

    private static double sampleMean(double... sample) {
        double sum = 0;
        for (double i : sample) sum += i;
        return sum / sample.length;
    }

    private static double sampleVariance(double... sample) {
        double sampleMean = MathService.sampleMean(sample);
        double sum = 0;
        for (double i : sample) {
            sum += Math.pow(i - sampleMean, 2);
        }

        return sum/(sample.length - 1);
    }

    static double[] normalizeVectorSudakov(double... vector){
        double vectorMean = MathService.sampleMean(vector);
        double vectorVariance = MathService.sampleVariance(vector);

        double[] vectorCopy = vector.clone();

        for (int i = 0; i < vectorCopy.length; i++){
            vectorCopy[i] = (vectorCopy[i] - vectorMean)/Math.sqrt(vectorVariance);
        }

        return vectorCopy;
    }

    static double[][] normalizeMatrixSudakov(double[][] matrix){
        double[][] matrixCopy = matrix.clone();

        for (int i = 0; i < matrixCopy.length; i++){
            matrixCopy[i] = MathService.normalizeVectorSudakov(matrixCopy[i]);
        }
        return matrixCopy;
    }

    public static double[][] matrixNormalizeKlim(double[][] X) {
        double[][] Y = new double[X.length][X[0].length];
        double xi = 0;
        double D = 0;
        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < X[0].length; j++) {
                xi = xi + X[i][j];

            }

            xi = xi / (X[0].length);

            for (int j = 0; j < X[0].length; j++) {
                D = D + (Math.pow((X[i][j] - xi), 2));
            }
            D = (D / (X[0].length - 1));
            for (int j = 0; j < X[0].length; j++) {
                Y[i][j] = (X[i][j] - xi) / (Math.sqrt(D));
            }
            D = 0;
            xi = 0;
        }
        return Y;
    }

    public static double[] vectorNormalizationVysh(double[] x)
    {
        if(x.length<=1)
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

    public static double[][] matrixNormalizationVysh(double[][] x)
    {
        for (int i = 0; i < x.length; i++)
            x[i] = vectorNormalizationVysh(x[i]);

        return x;
    }

    public static double [] vectorNormalizePraskova(double[]x) {
        double average = 0;
        double[] result = new double [x.length];
        for (int i=0; i<x.length; i++) {
            average +=x[i];
        }
        double disp=0;
        average = average/x.length;
        for (int k=0; k<x.length; k++) {
            disp +=Math.pow((x[k]-average), 2);
        }
        disp=Math.sqrt(disp/(x.length-1));
        for (int m=0;m<x.length; m++){
            result[m]=(x[m]-average)/disp;
        }
        return result;
    }

    public static double [][] matrixNormalizePraskova (double [][] x)  {
        double[][] result =new double [x.length] [];
        for (int i=0; i<x.length;i++){
            result[i] = new double [x[i].length];
            result[i] = vectorNormalizePraskova(x[i]);
        }
        return result;
    }

    public static double[][] matrixNormalizeElina(double[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] normalizeMatrix = new double[rows][cols];
        for(int i = 0; i<rows; i++){
            normalizeMatrix[i] = vectorNormalizeElina(matrix[i]);
        }
        return normalizeMatrix;
    }

    public static double[] vectorNormalizeElina(double[] vector) {
        double sum = 0;
        double value;
        double dispersion = 0;
        double[] normalizeVector = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i];
        }
        value = sum / vector.length;
        for (int i = 0; i < vector.length; i++) {
            dispersion += Math.pow(vector[i] - value, 2);
        }
        dispersion /= (vector.length - 1);
        for (int i = 0; i < vector.length; i++) {
            normalizeVector[i] = (vector[i] - value) / Math.sqrt(dispersion);
        }
        return normalizeVector;
    }

    public static void main(String[] args) {
        double[][] list = {{1,2,4},{4,5,6}};
        double[][] newList = matrixNormalizeSofia(list);
        for (int i=0; i<newList.length; i++) {
            for (int j=0; j<newList[i].length; j++) {
                System.out.println(newList[i][j]);
            }
            System.out.println();
        }
    }

//    -0.8728715609439697
//    -0.2182178902359925
//    1.0910894511799618
//
//    -1.0
//    0.0
//    1.0
}