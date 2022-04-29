package com.geekbrains.exercise_1_2;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArraysUtil<T> {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public void swapElements(T[] arr, int elemOne, int elemTwo) {
        if (elemOne < 0 || elemOne > arr.length - 1 || elemTwo < 0 || elemTwo > arr.length - 1) {
            logger.log(Level.WARNING, "Index out of bounds");
            return;
        }
        Object temp = arr[elemOne];
        arr[elemOne] = arr[elemTwo];
        arr[elemTwo] = (T) temp;
    }

    public List<T> arrayToArrayList(T[] arr) {
        List<T> list = new ArrayList<>();
        for (Object o : arr) {
            list.add((T) o);
        }
        return list;
    }
}
