package org.example.Exercicio2;

public class Exercicio2_5 {

    public static int[] exercicio2_5(int[][] array) {
        if (Exercicio2_2.isArrayEmpty(array)) {
            return new int[]{-1};
        }
        int totalElements = 0;

        for (int i = 0; i < array.length; i++) {
            totalElements += countAllElements(array[i]);
        }
        int indexNewArray = 0;
        int[] arrayAllElements = new int[totalElements];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                arrayAllElements[indexNewArray] = array[i][j];
                indexNewArray++;
            }
        }
        int totalNumbersNotRepeated = 0;
        for (int k = 0; k < arrayAllElements.length; k++) {
            if (!isNumberRepeated(arrayAllElements, arrayAllElements[k], k)) {
                totalNumbersNotRepeated += 1;
            }
        }
        int index = 0;
        int[] numbersNotRepeated = new int[totalNumbersNotRepeated];
        for (int l = 0; l < arrayAllElements.length; l++) {
            if (!isNumberRepeated(arrayAllElements, arrayAllElements[l], l)) {
                numbersNotRepeated[index] = arrayAllElements[l];
                index++;
            }
        }

        return numbersNotRepeated;
    }

    public static int countAllElements(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
        }
        return count;
    }

    public static boolean isNumberRepeated(int[] array, int number, int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index){
                continue;
            } else if (number == array[i]) {
                return true;
            }

        }
        return false;
    }
}

