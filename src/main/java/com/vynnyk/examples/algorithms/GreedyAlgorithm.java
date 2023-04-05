package com.vynnyk.examples.algorithms;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Arrays.stream;

@Data
// cкупий алгоритм
public class GreedyAlgorithm {
    public static void main(String[] args) {
//        int[] array = {3, 1, 7, 9, 9, 5};
//        System.out.println(maxNumberFromDigits(array));

        int[] stations = {0, 200, 375, 550, 750, 950};
        System.out.println(minStops(stations, 400));
    }

    public static String maxNumberFromDigits(int[] digit) {
//        StringBuilder result = new StringBuilder();
//        Arrays.sort(digit);
//        for (int i = digit.length - 1; i >= 0; i--) {
//            result.append(digit[i]);
//        }
//        return result.toString();
        // використовуємо метод String.join без роздільника
        return String.join("", stream(digit)
                //масив примітивів обгортаємо в клас обгортку
                .boxed()
                // сортуємо в звор порядку
                .sorted(Collections.reverseOrder())
                //перетворюємо Integer в String
                .map(String::valueOf)
                .toArray(String[]::new));
    }

    public static int minStops(int[] station, int capacity) {
        int result = 0; // оптимальна кількість зупинок
        int currentStop = 0;
        while (currentStop < station.length - 1) {
            int nextStop = currentStop;
            while (nextStop < station.length - 1 && station[nextStop + 1] - station[currentStop] <= capacity)
                nextStop++;
            if (currentStop == nextStop) //метод повертає -1, якщо нереально доїхати з точки А до Б
                return -1;
            if (nextStop < station.length - 1)
                result++;
            currentStop = nextStop;
        }
        return result;
    }
}
