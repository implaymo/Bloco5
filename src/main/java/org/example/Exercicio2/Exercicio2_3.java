package org.example.Exercicio2;

public class Exercicio2_3 {

    public static double averageNumber(int[][] array){
        if (Exercicio2_2.isArrayEmpty(array)){
            return -1;
        }

        double average = 0.0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += array[i].length;
            sum += sumLineNumbers(array[i]);
        }
        average = (double) sum / count;
        return average;
    }

    public static int sumLineNumbers(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
