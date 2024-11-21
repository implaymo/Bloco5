package org.example.Exercicio6;

import org.example.Exercicio2.Exercicio2_3;
import org.example.Exercicio2.Exercicio2_5;

public class VectorExercise6 {

    private int[] _array;

    public VectorExercise6() {
        _array = new int[0];
    }

    public VectorExercise6(int[] array) {
        this._array = array;
    }


    public boolean isArrayEmpty() {
        if (_array.length == 0) {
            return true;
        }
        return false;
    }

    public boolean addValue(int value) {

        int[] newArray = new int[_array.length + 1];
        for (int i = 0; i < _array.length; i++) {
            newArray[i] = _array[i];
        }

        newArray[_array.length] = value;
        _array = newArray;

        return true;
    }

    public boolean removeFirstValue() {
        int[] newArray = new int[_array.length - 1];
        for (int i = 0; i < _array.length - 1; i++) {
            newArray[i] = _array[i + 1];
        }
        _array = newArray;

        return true;
    }

    public int getValue(int index) {
        return _array[index];
    }


    public int getTotalElements() {
        return Exercicio2_5.getTotalElementsInArray(_array);
    }

    public int getHighestNumber(){
        int highestNumber = 0;
        for (int i = 0; i < _array.length; i++) {
            if (_array[i] > highestNumber) {
                highestNumber = _array[i];
            }
        }
        return highestNumber;
    }

    public int getLowestNumber() {
        int lowestNumber = getHighestNumber();
        for (int i = 0; i < _array.length; i++) {
            if (_array[i] < lowestNumber) {
                lowestNumber = _array[i];
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
        int sum = Exercicio2_3.sumLineNumbers(_array);
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
        for (int i = 0; i < _array.length; i++) {
            if (_array[i] % 2 == 0) {
                sum+= _array[i];
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
        for (int i = 0; i < _array.length; i++) {
            if (_array[i] % 2 != 0) {
                sum+= _array[i];
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
        for (int i = 0; i < _array.length; i++) {
            if (_array[i] % number == 0) {
                sum+= _array[i];
                countMultipleNumbers++;
            }
        }
        average = (double) sum / countMultipleNumbers;
        return average;
    }

    public int[] sortArray(int direction) {
        if (isArrayEmpty()) {
            return new int[]{-1};
        }
        for (int i = 0; i < _array.length; i++) {
            if(direction == 0) {
                sortAscending(i);
            } else if (direction == 1) {
                sortDescending(i);
            }

        }

        return _array;
    }

    public void sortAscending(int row) {
        int temp;
        for (int j = 0; j <_array.length; j++) {
            if (row == j) {
                continue;
            }
            if (_array[row] < _array[j]) {
                temp = _array[row];
                _array[row] = _array[j];
                _array[j] = temp;
            }
        }
    }

    public void sortDescending(int row) {
        int temp;
        for (int j = 0; j <_array.length; j++) {
            if (row == j) {
                continue;
            }
            if (_array[row] > _array[j]) {
                temp = _array[row];
                _array[row] = _array[j];
                _array[j] = temp;
            }
        }
    }

}
