package org.example.Exercicio2;

public class Exercicio2_6 {


    public static int[] allPrimeNumbers(int[][]array) {
        if (Exercicio2_2.isArrayEmpty(array)) {
            return new int[]{-1};
        }

        int totalPrimeNumbers = 0;
        for (int i = 0; i < array.length; i++){
            totalPrimeNumbers += countTotalPrimeNumbers(array[i]);
        }

        int[] allPrimeNumbers = new int[totalPrimeNumbers];
        int index = 0;
        for (int j = 0; j < array.length; j++){
            for (int k = 0; k < array[j].length; k++) {
                if (isPrime(array[j][k])){
                    allPrimeNumbers[index] = array[j][k];
                    index++;
                }
            }
        }
        return allPrimeNumbers;
    }


    public static int countTotalPrimeNumbers(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

