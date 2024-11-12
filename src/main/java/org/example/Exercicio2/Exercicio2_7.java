package org.example.Exercicio2;

import org.example.Exercicio1.Exercicio1_1;
import org.example.Exercicio1.Exercicio1_2;

public class Exercicio2_7 {

    public static int[] principalMatrixDiagonal(int[][]array){
        if (Exercicio2_2.isArrayEmpty(array)) {
            return new int[]{-1};
        }

        int[] principalDiagonalNumbers = new int[array.length];

        if(Exercicio1_1.isMatrixSquare(array)){
            for (int i = 0; i < array.length; i++){
                principalDiagonalNumbers[i] = getPrincipalDiagonalNumber(array[i], i);
            }
        }
        else {
            return new int[]{-1};
        }

        return principalDiagonalNumbers;
    }

    public static int getPrincipalDiagonalNumber(int[]array, int index){
        int number = 0;
        number = array[index];
        return number;
    }

}
