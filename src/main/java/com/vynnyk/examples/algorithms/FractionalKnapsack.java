package com.vynnyk.examples.algorithms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

@Data

public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3};
//сортировка О(N*logN)
        Arrays.sort(items,
                Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        System.out.println(Arrays.toString(items));

        final int W = 7;
        int weightSoFar = 0;
        double valueSoFar = 0;
        int currentItem = 0;// індекс поточного елемента

        while (currentItem < items.length && weightSoFar != W) {
            if (weightSoFar + items[currentItem].getWeight() < W) {
                // берем об'єкт повністю
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();
            } else {
                // беремо тільки частину об'єкта
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight())
                        * items[currentItem].getValue();

                weightSoFar = W;// повний рюкзак
            }
            currentItem++;
        }
        System.out.println("Цінність найкращого набору: " + valueSoFar);
    }
}

@AllArgsConstructor
@Data
class Item {
    private int weight;
    private int value;

    public double valuePerUnitOfWeight() {
        return (double) value / weight;
    }
}