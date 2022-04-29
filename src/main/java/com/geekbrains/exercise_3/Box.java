package com.geekbrains.exercise_3;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Box<T extends Fruit> {
    private float weight;
    private Fruit fruit;
    private ArrayList<T> fruits;

    public Box(Fruit fruit) {
        this();
        this.fruit = fruit;
    }

    public Box() {
        this.fruits = new ArrayList<>();
        this.weight = 0;
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
        this.weight += fruit.getWeight();
    }

    public void pourIntoBox(Box<T> box) {
        for (T fruit : this.fruits) {
            box.addFruit(fruit);
        }
        this.fruits.clear();
        this.weight = 0;
    }

    public boolean compare(Box box) {
        return this.weight == box.getWeight();
    }
}
