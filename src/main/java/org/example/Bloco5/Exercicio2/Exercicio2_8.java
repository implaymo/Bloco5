package org.example.Bloco5.Exercicio2;

import org.example.Bloco5.Exercicio1.Exercicio1_1;
import org.example.Bloco5.Exercicio1.Exercicio1_2;

public class Exercicio2_8 {

    public static int[] secundaryMatrixDiagonal(int[][] array) {
        if (Exercicio2_2.isArrayEmpty(array)) {
            return new int[]{-1};
        }

        int[] secundaryDiagonalNumbers = new int[array[0].length];
        if(Exercicio1_1.isMatrixSquare(array)){
            int index = array[0].length - 1;
            for (int row = 0; row < array.length; row++){
                secundaryDiagonalNumbers[row] = getNumberBelongsSecundaryDiagonal(array[row],index);
                index--;
            }
            return secundaryDiagonalNumbers;
        }
        return new int[]{-1};
    }

    public static int getNumberBelongsSecundaryDiagonal(int[] array,int index){
        int number = array[index];
        return number;
    }
}
