package org.example.Exercicio2;

public class Exercicio2_2 {

    public static int exercicio2_2(int[][] array) {
            if (array[0].length == 0) {
                return -1;
            }

            int numberToCheck = array[0][0];
            for (int i = 0; i < array.length; i++) {
                int highestNumberInLine = getHighestValue(array[i]);
                if (highestNumberInLine > numberToCheck) {
                    numberToCheck = highestNumberInLine;
                }
            }
            return numberToCheck;
        }

        public static int getHighestValue(int[] array) {
            int numberToCheck = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > numberToCheck) {
                    numberToCheck = array[i];
                }
            }
            return numberToCheck;
        }
}
