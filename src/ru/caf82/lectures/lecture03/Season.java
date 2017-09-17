package ru.caf82.lectures.lecture03;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by ilysko on 16.09.17.
 */
public enum Season {
    WINTER ("Зима"),
    SPRING ("Весна"),
    SUMMER ("Лето"),
    AUTUMN ("Осень");

    private String russianName;
    Season(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }

    public static void printMonthsOfSeason(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("December, January and February");
                break;
            case AUTUMN:
                System.out.println("September, October and November");
                break;
            case SUMMER:
                System.out.println("June, July and August");
                break;
            case SPRING:
                System.out.println("April, March and May");
                break;
        }
    }

    public static void main(String[] args) {
        Season season = Season.AUTUMN;
        System.out.println(season);

        // get all enum values
        System.out.println(Arrays.toString(Season.values()));

        printMonthsOfSeason(season);

        System.out.println(season.getRussianName());
    }
}
