package org.example.Exercicio6;

import org.example.Exercicio2.Exercicio2_2;
import org.example.Exercicio2.Exercicio2_3;
import org.example.Exercicio2.Exercicio2_5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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

    public int[] getElementsThatDigitsIsBiggerThanTheAverage(){
        if (isArrayEmptyOrNull()) {
            return new int[]{-1};
        }
        double average = 0;
        int totalDigits = 0;
        int sizeArray = _array.length;
        for (int i = 0; i < sizeArray; i++) {
            totalDigits += countNumberDigits(_array[i]);
        }
        average = (double) totalDigits / sizeArray;

        return isNumberOfDigitsBiggerThanAverageOfDigits(average);
    }

    public int countNumberDigits(int number) {
        String numberAsString = Integer.toString(number);
        int count = 0;
        for (int i = 0; i < numberAsString.length(); i++) {
            count++;
        }
        return count;
    }

    public int[] isNumberOfDigitsBiggerThanAverageOfDigits(double average) {
        int numbersDigitsBiggerThanAverage = 0;
        for (int i = 0; i < _array.length; i++) {
            if(countNumberDigits(_array[i]) > average) {
                numbersDigitsBiggerThanAverage++;
            }
        }
        int[] finalArray = new int[numbersDigitsBiggerThanAverage];
        int index = 0;
        for (int j = 0; j < _array.length; j++) {
            if(countNumberDigits(_array[j]) > average) {
                finalArray[index] = _array[j];
                index++;
            }
        }
        return finalArray;
    }

    ////////////////////// EXERCISE 20 /////////////////////////////7

    public int[] getElementsThatHaveMoreEvenDigitsPercentageThanTheAverage(){
        if(isArrayEmptyOrNull()){
            return new int[]{-1};
        }
        double percentageEvenDigitsAllElements = getTotalPercentageOfEvenDigitsArray();
        double percentageEvenDigitsInNumber = 0;
        int totalNumbersPercentageEvenDigitsBiggerThanAllElementsPercentage = 0;

        for (int i = 0; i < _array.length; i++) {
            percentageEvenDigitsInNumber = getPercentageOfEvenDigitsInAnElement(_array[i]);
            if (percentageEvenDigitsInNumber > percentageEvenDigitsAllElements) {
                totalNumbersPercentageEvenDigitsBiggerThanAllElementsPercentage++;
            }
        }

        int[] numbersEvenDigitsPercentageBigger = new int[totalNumbersPercentageEvenDigitsBiggerThanAllElementsPercentage];
        int[] finalNumbers = addNumbersThatHaveBiggerPercentage(numbersEvenDigitsPercentageBigger,
                percentageEvenDigitsAllElements);
        return finalNumbers;
    }

    public int[] addNumbersThatHaveBiggerPercentage(int[] numbersEvenDigitsPercentageBigger,
                                                    double percentageEvenDigitsAllElements){
        double percentageEvenDigitsInNumber;
        int index = 0;
        for (int j = 0; j < _array.length; j++) {
            percentageEvenDigitsInNumber = getPercentageOfEvenDigitsInAnElement(_array[j]);
            if (percentageEvenDigitsInNumber > percentageEvenDigitsAllElements) {
                numbersEvenDigitsPercentageBigger[index] = _array[j];
                index++;
            }
        }
        return numbersEvenDigitsPercentageBigger;
    }

    public double getTotalPercentageOfEvenDigitsArray() {
        double percentage;
        int totalEvenDigits = getTotalEvenDigitsArray();
        int totalDigits = getTotalDigitsInArray();

        percentage = ((double) totalEvenDigits / totalDigits) * 100;
        return percentage;
    }

    public double getPercentageOfEvenDigitsInAnElement(int number){
        number = Math.abs(number);
        int totalDigits = 0;
        int totalEvenDigits = 0;
        double percentage;
        if (number == 0) {
            totalEvenDigits++;
            totalDigits++;
        } else{
            while (number > 0) {
                int lastDigit = number % 10;
                if (lastDigit % 2 == 0) {
                    totalEvenDigits++;
                }
                totalDigits++;
                number = number / 10;
            }
        }
        percentage =  ((double) totalEvenDigits / totalDigits) * 100;
        return percentage;
    }

    public int getTotalOfEvenDigitsElement(int number) {
        number = Math.abs(number);
        int totalEvenDigitsInElement = 0;
        int lastDigit;
        if(number == 0) {
            totalEvenDigitsInElement++;
            return totalEvenDigitsInElement;
        } else {
            while (number > 0) {
                lastDigit = number % 10;
                if (lastDigit % 2 == 0){
                    totalEvenDigitsInElement++;
                }
                number = number / 10;
            }

        }
        return totalEvenDigitsInElement;
    }

    public int getTotalEvenDigitsArray(){
        int totalEvenDigits = 0;
        for (int i = 0; i < _array.length; i++) {
            totalEvenDigits += getTotalOfEvenDigitsElement(_array[i]);
        }
        return totalEvenDigits;
    }


    public int getTotalOfDigitsInElement(int number){
        number = Math.abs(number);
        int totalDigitsInElement = 0;
        if (number == 0) {
            totalDigitsInElement++;
        } else {
            while (number > 0) {
                totalDigitsInElement++;
                number = number / 10;
            }
        }
        return totalDigitsInElement;
    }

    public int getTotalDigitsInArray(){
        int totalDigits = 0;
        for (int i = 0; i < _array.length; i++) {
            totalDigits += getTotalOfDigitsInElement(_array[i]);
        }
        return totalDigits;
    }

    ///////////////////////////////////////////////////////////////

    //////////////////// Exercise 21 //////////////////////////
    public int[] getElementsThatOnlyHaveEvenDigits(){
        if (isArrayEmptyOrNull()) {
            return new int[]{-1};
        }

        int countElementsOnlyWithEvenDigits = 0;
        for (int i = 0; i < _array.length; i++) {
            if(hasElementOnlyEvenDigits(_array[i])) {
                countElementsOnlyWithEvenDigits++;
            }
        }
        int[] allElementsOnlyWithEvenDigits = new int[countElementsOnlyWithEvenDigits];
        int[] finalNumbers = addElementsOnlyWithEvenDigits(allElementsOnlyWithEvenDigits);

        return finalNumbers;
    }


    public boolean hasElementOnlyEvenDigits(int number) {
        if (number == 0) {
            return true;
        }
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }

    public int[] addElementsOnlyWithEvenDigits(int[] arrayElementsOnlyEvenDigits){
        int index = 0;
        for (int i = 0; i < _array.length; i++) {
            if(hasElementOnlyEvenDigits(_array[i])) {
                arrayElementsOnlyEvenDigits[index] = _array[i];
                index++;
            }

        }
        return arrayElementsOnlyEvenDigits;
    }
    ///////////////////////////////////////////////////////////////////

    ////////////////////////// Exercise 22 //////////////////////////////

    public int[] getElementsThatHaveAscendingDigitsOnly(){
        if (isArrayEmptyOrNull()) {
            return new int[]{-1};
        }

        int elementsAscendingDigits = 0;
        for (int i = 0; i < _array.length; i++) {
            int [] allElementsDigits = getAllElementsDigits(getTotalOfDigitsInElement(_array[i]), _array[i]);
            if (hasAscendingDigits(allElementsDigits)) {
                elementsAscendingDigits++;
            }
        }

        int[] allElementsWithAscendingDigits = new int[elementsAscendingDigits];;

        return addElementsWithAscendingDigits(allElementsWithAscendingDigits);
    }


    public int[] getAllElementsDigits(int totalElementDigits, int number) {
        int[] allElementDigits = new int[totalElementDigits];
        int lastDigit;
        int index = totalElementDigits - 1;
        while (number > 0) {
            lastDigit = number % 10;
            allElementDigits[index] = lastDigit;
            number = number / 10;
            index--;
        }

        return allElementDigits;
    }

    public boolean hasAscendingDigits(int[] allELementDigits){
        for (int i = 0; i < allELementDigits.length - 1; i++) {
            if(allELementDigits[i] > allELementDigits[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int[] addElementsWithAscendingDigits(int[]allElementsWithAscendingDigits) {
        int index = 0;
        for (int j = 0; j < _array.length; j++) {
            int [] allElementsDigits = getAllElementsDigits(getTotalOfDigitsInElement(_array[j]), _array[j]);
            if (hasAscendingDigits(allElementsDigits)) {
                allElementsWithAscendingDigits[index] = _array[j];
                index++;
            }
        }
        return allElementsWithAscendingDigits;
    }

    /////////////////////////////////////////////////////////////////

    ///////////////////////// Exercise 23 //////////////////////////

    public int[] getAllPalindromeElements() {
        if (isArrayEmptyOrNull()){
            return new int[]{-1};
        }
        int totalOfPalindrome = 0;
        for (int i = 0; i < _array.length; i++) {
            int [] allElementsDigits = getAllElementsDigits(getTotalOfDigitsInElement(_array[i]), _array[i]);
            if (isElementPalindrome(allElementsDigits, _array[i])) {
                totalOfPalindrome++;
            }
        }
        return addPalindromeElements(totalOfPalindrome);
    }

    public boolean isElementPalindrome(int[] allElementDigits, int number){
        int lastDigit;
        int index = 0;
        while (number > 0) {
            lastDigit = number % 10;
            if (allElementDigits[index] != lastDigit) {
                return false;
            }
            number = number / 10;
            index++;
        }
        return true;
    }

    public int[] addPalindromeElements(int totalOfPalindrome) {
        int index = 0;
        int[] allPalindromeElements = new int[totalOfPalindrome];
        for (int i = 0; i < _array.length; i++) {
            int [] allElementsDigits = getAllElementsDigits(getTotalOfDigitsInElement(_array[i]), _array[i]);
            if (isElementPalindrome(allElementsDigits, _array[i])) {
                allPalindromeElements[index] = _array[i];
                index++;
            }
        }
        return allPalindromeElements;
    }
}
