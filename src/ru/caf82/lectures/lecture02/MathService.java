/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.lectures.lecture02;

/**
 * @author 1
 */
public class MathService {

    public static void main(String[] args) {
        System.out.println("Нормализация вектора\n");
        double[] vector = {1, 2, 0, 3};
        for (double element : vectorNormalization(vector))
            System.out.printf("%.2f ", element);

        System.out.println("\n");


        System.out.println("Нормализация матрицы\n");

        double[][] matrix = {{2, 3, 4}, {-3, 1.6, 5}, {39, 28, 1.22}};

        double proverka[][] = matrixNormalization(matrix);

        for (int i = 0; i < proverka.length; i++) {
            for (double element : proverka[i])
                System.out.printf("%.2f ", element);
            System.out.println();
        }
    }

    public static double dotProduct(double[] a, double[] b) {
        double result = 0;
        for (int i = 0; i < a.length; i++)
            result += a[i] * b[i];

        return result;
    }

    public static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public static double sigmoid(double[] x, double[] w) {
        return sigmoid(dotProduct(x, w));
    }

    public static double[] vectorNormalization(double[] x) {
        if (x.length <= 1)
            return x;

        double average = 0;

        for (double element : x)
            average += element;

        average /= x.length;


        double D = 0;

        for (double element : x)
            D += Math.pow(element - average, 2);

        D /= x.length - 1;

        for (int i = 0; i < x.length; i++)

            x[i] = (x[i] - average) / Math.sqrt(D);

        return x;
    }

    public static double[][] matrixNormalization(double[][] x) {
        for (int i = 0; i < x.length; i++)
            x[i] = vectorNormalization(x[i]);

        return x;
    }
}

