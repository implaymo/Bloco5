package org.example.Bloco5.Exercicio2;

import org.example.Bloco5.Exercicio1.Exercicio1_1;

public class Exercicio2_11 {

    public static int[][] transposeMatrix(int[][]matrix) {
        if (Exercicio2_2.isArrayEmpty((matrix))){
            return new int[][]{{-1}, {-1}};
        }

        int sizeRows;
        int sizeColumns;
        if (Exercicio1_1.isMatrixSquare(matrix)) {
            sizeRows = matrix.length;
            sizeColumns = matrix.length;
        }  else {
            sizeRows = matrix[0].length;
            sizeColumns = matrix.length;
        }

        return transpose(matrix,sizeRows, sizeColumns);
    }

    public static int[][] transpose(int[][] matrix, int sizeRow, int sizeColumns){
        int[][] newMatrix = new int[sizeRow][sizeColumns];
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
