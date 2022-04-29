package com.geekbrains.exercise_3;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        //add apple to basket
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        System.out.println(appleBox.getWeight());

        //add orange to basket
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange);
        System.out.println(orangeBox.getWeight());

        //compare weight apples and oranges
        System.out.println(appleBox.compare(orangeBox));

        //pour into another box
        Box<Apple> appleBox2 = new Box<>();
        appleBox.pourIntoBox(appleBox2);

        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());
    }
}
