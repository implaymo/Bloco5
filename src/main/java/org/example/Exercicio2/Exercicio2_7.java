package org.example.Exercicio2;

import org.example.Exercicio1.Exercicio1_1;
import org.example.Exercicio1.Exercicio1_2;

public class Exercicio2_7 {

    public static int[] principalMatrixDiagonal(int[][]array){
        if (Exercicio2_2.isArrayEmpty(array)) {
            return new int[]{-1};
        }

        int[] principalDiagonalNumbers = new int[array[0].length];
        if(Exercicio1_1.isMatrixSquare(array) || Exercicio1_2.isMatrixRectangle(array)){
            int index = 0;
            for (int i = 0; i < array[0].length; i++){
                principalDiagonalNumbers[index] = getDiagonalNumbers(array[i], index);
                index++;
            }
            return principalDiagonalNumbers;
        }
        return new int[]{-1};
    }

    public static int getDiagonalNumbers(int[]array, int index){
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            number = array[index];
        }
        return number;
    }

}
