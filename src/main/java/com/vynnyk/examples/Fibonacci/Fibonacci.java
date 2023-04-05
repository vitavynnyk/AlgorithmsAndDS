package com.vynnyk.examples.Fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(getFibonacci(100));
    }
// складність О(n), ефективний
    public static long getFibonacci(int fibonacci) {
        long[] array = new long[fibonacci + 1];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= fibonacci; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[fibonacci];

    }

    /*розглянемо метод за допомогою рекурсії з викорстанням мемоізації

    Мемоізація — це метод оптимізації, який в основному використовується для прискорення комп'ютерних програм
    шляхом зберігання результатів дорогих викликів функцій та повернення кешованого результату,
    коли виклики на однакових вхідних даних відбуваються знову.

    тобто, якщо ми раніше викликали цей метод, ми збережемо результат його виконання
    в мейн код
    int n =100;
    long [] mem = new long [n+1];
    Arrays.fill(mem, -1);
    System.out.println(getFibonacciWithRecursion(n, mem))
     якщо без мемоізації - складність О(2^n)
     з - О(n)
     */
    public static long getFibonacciWithRecursion(int fibonacci, long[] mem) {
        if (mem[fibonacci] != -1)
            return mem[fibonacci];

        if (fibonacci <= 1)
            return fibonacci;

        return getFibonacciWithRecursion(fibonacci - 1, mem)
                + getFibonacciWithRecursion (fibonacci - 2,mem);
    }
}
