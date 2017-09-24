package ru.caf82.lectures.lecture04;

public class ExceptionCatchingIhExample {

    public static void main(String[] args) {
//        try {
//            System.out.println(6 / 0);
//        } catch (Exception ex) {
//            System.out.println("Ошибка верхнего увроня");
//        } catch (ArithmeticException ex) {
//            System.out.println("Ошибка! Ошибка!");
//            System.out.println(ex.toString());
//        }

        try {
            System.out.println(Long.parseLong("Mama"));
        } catch (NumberFormatException ex) {
            System.out.println("Снова косяк!");
            System.out.println(ex.toString());
        } catch (Exception ex) {
            System.out.println("Ошибка верхнего уровня");
        }
    }
}
