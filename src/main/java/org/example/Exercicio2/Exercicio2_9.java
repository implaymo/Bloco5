package org.example.Exercicio2;

import org.example.Exercicio1.Exercicio1_1;
import org.example.Exercicio1.Exercicio1_2;

public class Exercicio2_9 {

    public static boolean isIdentityMatrix(int[][]array){
        if (Exercicio2_2.isArrayEmpty(array)) {
            return false;
        }

        if (Exercicio1_1.isMatrixSquare(array)){
            int index = 0;
            boolean allZeros = true;
            for (int i = 0; i < array.length; i++){
                if(!isAllNotDiagonalNumbersZero(array[i], index)){
                    allZeros = false;
                }
                index++;
            }
            if (checkPrincipalDiagonal(array) && allZeros) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAllNotDiagonalNumbersZero(int[]array, int index){
        for (int i = 0; i < array.length; i++){
            if (i == index){
                continue;
            }
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPrincipalDiagonal(int[][]array) {
        int[] principalDiagonal = Exercicio2_7.principalMatrixDiagonal(array);
        for (int i = 0; i < principalDiagonal.length; i++){
            if (principalDiagonal[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
