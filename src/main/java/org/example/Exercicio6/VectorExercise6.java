package org.example.Exercicio6;

import org.example.Exercicio2.Exercicio2_1;
import org.example.Exercicio2.Exercicio2_3;
import org.example.Exercicio2.Exercicio2_5;

public class VectorExercise6 {

    private int[] array;

    public VectorExercise6() {
        this.array = new int[]{};
    }

    public VectorExercise6(int[] array) {
        this.array = array;
    }


    public boolean isArrayEmpty() {
        if (array.length == 0) {
            return true;
        }
        return false;
    }

    public int[] addValue(int value) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = value;
        array = newArray;
        return array;
    }

    public int[] removeFirstValue() {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            newArray[i] = array[i + 1];
        }
        array = newArray;
        return array;
    }

    public int getValue(int index) {
        return array[index];
    }


    public int getTotalElements() {
        return Exercicio2_5.getTotalElementsInArray(array);
    }

    public int getHighestNumber(){
        int highestNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > highestNumber) {
                highestNumber = array[i];
            }
        }
        return highestNumber;
    }

    public int getLowestNumber() {
        int lowestNumber = getHighestNumber();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < lowestNumber) {
                lowestNumber = array[i];
            }
        }
        return lowestNumber;
    }


    public double getAverage() {
        if (isArrayEmpty()) {
            return -1;
        }
        double average;
        int count = getTotalElements();
        int sum = Exercicio2_3.sumLineNumbers(array);
        average = (double) sum / count;
        return average;
    }

    public double getAverageEvenNumbers(){
        if (isArrayEmpty()) {
            return -1;
        }
        double average;
        int countEvenNumbers = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sum+= array[i];
                countEvenNumbers++;
            }
        }
        average = (double) sum / countEvenNumbers;
        return average;
    }

    public double getAverageOddNumbers(){
        if (isArrayEmpty()) {
            return -1;
        }
        double average;
        int countEvenNumbers = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                sum+= array[i];
                countEvenNumbers++;
            }
        }
        average = (double) sum / countEvenNumbers;
        return average;
    }

    public double getAverageOfMultiplesOfGivenNumber(int number) {
        if (isArrayEmpty()) {
            return -1;
        }
        double average;
        int countMultipleNumbers = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % number == 0) {
                sum+= array[i];
                countMultipleNumbers++;
            }
        }
        average = (double) sum / countMultipleNumbers;
        return average;
    }
}
