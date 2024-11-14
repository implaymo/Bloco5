package org.example.Exercicio3;

import org.example.Exercicio2.Exercicio2_2;

public class Exercicio3_3 {

    public static int[][] productOfTwoMatrix(int[][]matrixOne, int[][]matrixTwo) {
        if (Exercicio2_2.isArrayEmpty((matrixOne))){
            return new int[][]{{-1}, {-1}};
        } else if (Exercicio2_2.isArrayEmpty(matrixTwo)) {
            return new int[][]{{-1},{-1}};
        }

        int[][] newMatrix = new int[matrixOne.length][matrixOne.length];
        int product = 0;
        int row = 0;
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne.length; j++) {
                product = calculation(matrixOne, matrixTwo, i ,j);
                newMatrix[j][i] = product;
            }
        }
        return newMatrix;
    }

    public static int calculation(int[][] matrixOne, int[][]matrixTwo, int column, int row) {
        int sum = 0;
        for (int k = 0; k < matrixTwo.length; k++){
            sum += (matrixOne[row][k] * matrixTwo[k][column]);
        }
        return sum;
    }
}
