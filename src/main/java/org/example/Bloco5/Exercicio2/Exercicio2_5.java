package org.example.Bloco5.Exercicio2;


public class Exercicio2_5 {

    public static int[] notRepeatedElements(int[][] array) {
        if (Exercicio2_2.isArrayEmpty(array)) {
            return new int[]{-1};
        }
        // count all the elements in the array
        int totalElements = 0;
        for (int i = 0; i < array.length; i++) {
            totalElements += getTotalElementsInArray(array[i]);
        }
        int[] arrayAllElements = addAllElementsToOneDimensionalArray(array, totalElements);
        int totalNumbersNotRepeated = countAllElementsNotRepeated(arrayAllElements);
        int[] numbersNotRepeated = addNotRepeatedNumbers(totalNumbersNotRepeated, arrayAllElements);

        return numbersNotRepeated;
    }

    public static int getTotalElementsInArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
        }
        return count;
    }

    public static boolean isNumberRepeated(int[] array, int number, int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            if (number == array[i]) {
                return true;
            }

        }
        return false;
    }

    public static int[] addAllElementsToOneDimensionalArray(int[][] array, int totalElements) {
        int indexAllElements = 0;
        int[] arrayAllElements = new int[totalElements];
        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            indexAllElements = addElementToOneDimensionalArray(arrayAllElements, array, currentIndex, indexAllElements);
        }
        return arrayAllElements;
    }

    public static int addElementToOneDimensionalArray(int[] arrayAllElements, int[][] array, int currentIndex, int indexAllElements) {
        for (int j = 0; j < array[currentIndex].length; j++) {
            arrayAllElements[indexAllElements] = array[currentIndex][j];
            indexAllElements++;
        }
        return indexAllElements;
    }

    public static int countAllElementsNotRepeated(int[] arrayAllElements) {
        int totalNumbersNotRepeated = 0;
        for (int k = 0; k < arrayAllElements.length; k++) {
            if (!isNumberRepeated(arrayAllElements, arrayAllElements[k], k)) {
                totalNumbersNotRepeated += 1;
            }
        }
        return totalNumbersNotRepeated;
    }

    public static int[]addNotRepeatedNumbers(int totalNumbersNotRepeated, int[] arrayAllElements) {
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
}

