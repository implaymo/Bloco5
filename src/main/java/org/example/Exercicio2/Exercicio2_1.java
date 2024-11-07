package org.example.Exercicio2;

public class Exercicio2_1 {

    public static int getLowestNumber(int[][] array) {
        if (Exercicio2_2.isArrayEmpty(array)) {
            return -1;
        }

        int numberToCheck = array[0][0];
        for (int i = 0; i < array.length; i++) {
            int lowestNumberInLine = getLowestNumberInLine(array[i]);
            if (lowestNumberInLine < numberToCheck) {
                numberToCheck = lowestNumberInLine;
            }
        }
        return numberToCheck;
    }

    public static int getLowestNumberInLine(int[] array) {
        int numberToCheck = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < numberToCheck) {
                numberToCheck = array[i];
            }
        }
        return numberToCheck;
    }
}
