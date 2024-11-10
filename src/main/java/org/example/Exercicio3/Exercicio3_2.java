package org.example.Exercicio3;

import org.example.Exercicio2.Exercicio2_2;

public class Exercicio3_2 {

    public static int[][] sumTwoMatrix(int[][] matrixOne, int[][]matrixTwo) {
        if (Exercicio2_2.isArrayEmpty((matrixOne))){
            return new int[][]{{-1}, {-1}};
        } else if (Exercicio2_2.isArrayEmpty(matrixTwo)) {
            return new int[][]{{-1},{-1}};
        }

        int[][] newMatrix = new int[matrixOne.length][matrixOne[0].length];
        for (int i = 0; i < matrixOne.length; i++) {
            newMatrix[i] = sumBothMatrix(matrixOne[i], matrixTwo[i]);
        }

        return newMatrix;
    }

    public static int[] sumBothMatrix(int[] arrayOne, int[] arrayTwo){
        int[] newArray = new int[arrayOne.length];
        for (int i = 0; i < arrayOne.length; i++) {
            newArray[i] = arrayOne[i] + arrayTwo[i];
        }
        return newArray;
    }
}
