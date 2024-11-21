package org.example.Exercicio6;

import org.example.Exercicio2.Exercicio2_2;
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
        if(isArrayEmptyOrNull()){
            return -1;
        }
        return _array[index];
    }


    public int getTotalElements() {
        return Exercicio2_5.getTotalElementsInArray(_array);
    }

    public int getHighestNumber(){
        if(isArrayEmptyOrNull()){
            return -1;
        }
        return Exercicio2_2.getHighestValue(_array);
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
        if (isArrayEmptyOrNull()) {
            return -1;
        }
        double average;
        int count = getTotalElements();
        int sum = Exercicio2_3.sumLineNumbers(_array);
        average = (double) sum / count;
        return average;
    }

    public double getAverageEvenNumbers(){
        if (isArrayEmptyOrNull()) {
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
        if (isArrayEmptyOrNull()) {
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
        if (isArrayEmptyOrNull()) {
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
        if (isArrayEmptyOrNull()) {
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

    public boolean isArrayEmptyOrNull() {
        if (_array == null) {
            return true;
        }
        else if (_array.length == 0) {
            return true;

        }
        return false;
    }

    public boolean hasOnlyOneValue() {
        if (_array.length == 1) {
            return true;
        }
        return false;
    }

    public boolean hasOnlyEvenValues() {
        for (int i = 0; i < _array.length; i++) {
            if (_array[i] % 2 != 0){
                return false;
            }
        }
        return true;
    }

    public boolean hasOnlyOddValues() {
        for (int i = 0; i < _array.length; i++) {
            if (_array[i] % 2 == 0){
                return false;
            }
        }
        return true;
    }

    public boolean hasDuplicatedValues(){
        if(isArrayEmptyOrNull()) {
            return false;
        }
        for (int i = 0; i < _array.length; i++) {
            for (int j = 0; j < _array.length; j++) {
                if (i == j) {
                    continue;
                }

                if (_array[i] == _array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] elementsThatDigitsIsBiggerThanTheAverage(){
        return new int[]{};
    }


}
