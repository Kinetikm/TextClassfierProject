package ru.caf82.lectures.lecture04;

public class ThrowExample {

    public static int divide(int a, int b) throws ArithmeticException, NegException {
        if (b == 0) {
            throw new ArithmeticException("Ты че как лох-то, на нуль делить нельзя");
        } else if( b < 0) {
            throw new NegException("Мы решили, что на отрицательные числа делить нельзя");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            System.out.println(divide(5, 2));
            System.out.println(divide(5, 0));
        } catch (ArithmeticException ex){
            System.out.println("Мы поймали ошибку!");
        } catch (Exception ex) {
            //
        }
        try {
            System.out.println(divide(5, 2));
            System.out.println(divide(5, -1));
        } catch (NegException ex){
            System.out.println("Мы поймали ошибку!");
        } catch (Exception ex) {
            //
        }
        try {
            System.out.println(divide(5, -1));
            System.out.println(divide(5, 0));
        } catch (ArithmeticException ex){
            System.out.println("Мы поймали ошибку!");
        } catch (NegException ex) {
            System.out.println("Отрицательное деление");
        }

    }


    public static class NegException extends Exception {
        NegException(){
            super();
        }
        NegException(String message) {
            super(message);
        }
    }
}
