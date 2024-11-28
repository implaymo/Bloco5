package org.example.Bloco5.Exercicio3;

import org.example.Bloco5.Exercicio2.Exercicio2_2;

public class Exercicio3_1 {

    public static int[][] matrixProductByConstant(int[][]matrix, int constant){
        if (Exercicio2_2.isArrayEmpty((matrix))){
            return new int[][]{{-1}, {-1}};
        }

        for (int i = 0; i < matrix.length; i++) {
            multiplyArrayByConstant(matrix[i], constant);
        }
        return matrix;
    }

    public static int[] multiplyArrayByConstant(int[]array, int constant) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= constant;
        }
        return array;
    }
}
