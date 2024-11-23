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
        if(isArrayEmptyOrNull()) {
            return -1;
        }
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
            int number = _array[i];
            if (number % 2 != 0){
                return false;
            }
        }
        return true;
    }

    public boolean hasOnlyOddValues() {
        for (int i = 0; i < _array.length; i++) {
            int number = _array[i];
            if (number % 2 == 0){
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
            int number = _array[i];
            totalDigits += countNumberDigits(number);
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
            int number = _array[i];
            if(countNumberDigits(number) > average) {
                numbersDigitsBiggerThanAverage++;
            }
        }
        int[] finalArray = new int[numbersDigitsBiggerThanAverage];
        int index = 0;
        for (int j = 0; j < _array.length; j++) {
            int number = _array[j];
            if(countNumberDigits(number) > average) {
                finalArray[index] = number;
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
            int number = _array[i];
            percentageEvenDigitsInNumber = getPercentageOfEvenDigitsInAnElement(number);
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
            int number = _array[j];
            percentageEvenDigitsInNumber = getPercentageOfEvenDigitsInAnElement(number);
            if (percentageEvenDigitsInNumber > percentageEvenDigitsAllElements) {
                numbersEvenDigitsPercentageBigger[index] = number;
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
            int number = _array[i];
            totalEvenDigits += getTotalOfEvenDigitsElement(number);
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
            int number = _array[i];
            totalDigits += getTotalOfDigitsInElement(number);
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
            int number = _array[i];
            if(hasElementOnlyEvenDigits(number)) {
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
            int number = _array[i];
            if(hasElementOnlyEvenDigits(number)) {
                arrayElementsOnlyEvenDigits[index] = number;
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
            int number = Math.abs(_array[i]);
            int totalDigits = getTotalOfDigitsInElement(number);
            if (hasAscendingDigits(getElementDigits(totalDigits,number))) {
                elementsAscendingDigits++;
            }
        }

        int[] allElementsWithAscendingDigits = new int[elementsAscendingDigits];;

        return addElementsWithAscendingDigits(allElementsWithAscendingDigits);
    }


    public int[] getElementDigits(int totalElementDigits, int number) {
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
            if(allELementDigits[i] >= allELementDigits[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int[] addElementsWithAscendingDigits(int[]allElementsWithAscendingDigits) {
        int index = 0;
        for (int j = 0; j < _array.length; j++) {
            int number = Math.abs(_array[j]);
            int totalDigits = getTotalOfDigitsInElement(number);
            int [] allElementsDigits = getElementDigits(totalDigits, number);
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
            int number = _array[i];
            int [] allElementDigits = getElementDigits(getTotalOfDigitsInElement(number), number);
            if (isElementPalindrome(allElementDigits, number)) {
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
            int number = _array[i];
            int [] allElementsDigits = getElementDigits(getTotalOfDigitsInElement(number), number);
            if (isElementPalindrome(allElementsDigits, number)) {
                allPalindromeElements[index] = number;
                index++;
            }
        }
        return allPalindromeElements;
    }

    //////////////////////////////////////////////////////


    ////////////////////// Exercise 24 /////////////////////////////////

    public int[] getAllElementsWithTheSameDigits(){
        if (isArrayEmptyOrNull()){
            return new int[]{-1};
        }

        int countElementsThatHaveTheSameDigits = 0;
        for (int i = 0; i < _array.length; i++) {
            int number = _array[i];
            int [] allElementDigits = getElementDigits(getTotalOfDigitsInElement(number), number);
            if (hasAllDigitsEqual(allElementDigits)) {
                countElementsThatHaveTheSameDigits++;
            }
        }


        int[] elementsWithEqualDigits = new int[countElementsThatHaveTheSameDigits];


        return addAllElementWithEqualDigits(elementsWithEqualDigits);
    }

    public boolean hasAllDigitsEqual(int[] elementDigits){
        int firstDigit = elementDigits[0];
        for (int i = 1; i < elementDigits.length; i++){
            if (firstDigit != elementDigits[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] addAllElementWithEqualDigits(int[] elementsWithEqualDigits){
        int index = 0;
        for (int i = 0; i < _array.length; i++) {
            int number = _array[i];
            int [] allElementDigits = getElementDigits(getTotalOfDigitsInElement(number), number);
            if (hasAllDigitsEqual(allElementDigits)) {
                elementsWithEqualDigits[index] = _array[i];
                index++;
            }
        }
        return elementsWithEqualDigits;
    }
    ///////////////////////////////////////////////////////////////77



    //////////////// Exercise 25 ////////////////////////////////

    public int[] getAllNotArmstrongElements(){
        if (isArrayEmptyOrNull()) {
            return new int[]{-1};
        }

        int countAllNotArmstrongElements = 0;
        for (int i = 0; i < _array.length; i++) {
            int number = _array[i];
            if (isElementNotArmstrong(number)) {
                countAllNotArmstrongElements++;
            }
        }
        int[] allNotArmstrongNumbers = new int[countAllNotArmstrongElements];

        return addAllNotArmstrongElements(allNotArmstrongNumbers);
    }

    public boolean isElementNotArmstrong(int number) {
        double sumOfDigitsCube = 0;
        int originalNumber = number;
        String numberAsString = String.valueOf(number);
        if (number == 0) {
            return false;
        }

        while (number > 0) {
            int lastDigit = number % 10;
            sumOfDigitsCube += Math.pow(lastDigit, numberAsString.length());
            number /= 10;
        }
        if (sumOfDigitsCube != originalNumber) {
            return true;
        }
        return false;
    }

    public int[] addAllNotArmstrongElements(int[] allNotArmstrongNumbers){
        int index = 0;
        for (int i = 0; i < _array.length; i++) {
            int number = _array[i];
            if (isElementNotArmstrong(number)) {
                allNotArmstrongNumbers[index] = number;
                index++;
            }
        }
        return allNotArmstrongNumbers;
    }
}
