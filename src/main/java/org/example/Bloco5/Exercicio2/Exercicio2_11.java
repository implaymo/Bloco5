package org.example.Bloco5.Exercicio2;

public class Exercicio2_11 {

    public static int[][] transposeMatrix(int[][]matrix) {
        if (Exercicio2_2.isArrayEmpty((matrix))){
            return new int[][]{{-1}, {-1}};
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        int row = 0;
        int column = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[row][column] = matrix[i][j];
                row++;
            }
            column++;
            row = 0;
        }
        return newMatrix;
    }

}
