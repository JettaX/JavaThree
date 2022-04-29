package com.geekbrains.exercise_1_2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArraysUtil<Integer> utilInteger = new ArraysUtil<>();
        ArraysUtil<String> utilString = new ArraysUtil<>();

        //Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        Integer[] arrOneIntegers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        utilInteger.swapElements(arrOneIntegers, 3, 7);
        System.out.println(Arrays.toString(arrOneIntegers));
        System.out.println("_____________________________________________________________________");

        String[] arrOneStrings = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        utilString.swapElements(arrOneStrings, 3, 7);
        System.out.println(Arrays.toString(arrOneStrings));
        System.out.println("_____________________________________________________________________");


        //Написать метод, который преобразует массив в ArrayList;
        Integer[] arrIntegers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listIntegers = utilInteger.arrayToArrayList(arrIntegers);
        System.out.println(listIntegers.getClass().getSimpleName());
        System.out.println(listIntegers);
        System.out.println("_____________________________________________________________________");

        String[] arrStrings = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        List<String> listStrings = utilString.arrayToArrayList(arrStrings);
        System.out.println(listStrings.getClass().getSimpleName());
        System.out.println(listStrings);
        System.out.println("_____________________________________________________________________");
    }
}
