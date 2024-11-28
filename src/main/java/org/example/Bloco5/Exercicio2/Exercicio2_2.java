package org.example.Bloco5.Exercicio2;

public class Exercicio2_2 {

    public static int getHighestNumber(int[][] array) {
            if (isArrayEmpty(array)) {
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


        public static boolean isArrayEmpty(int[][] array){
            for (int i = 0; i < array.length; i++) {
                if (array[i].length == 0) {
                    return true;
                }
            }
            return false;
        }
}
