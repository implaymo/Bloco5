package org.example.Exercicio2;

import org.example.Exercicio1.Exercicio1_1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercicio2_10 {

    public static double[][] invertedMatrix(int[][]matrix) {
        if (Exercicio2_2.isArrayEmpty((matrix))){
            return new double[][]{{-1}, {-1}};
        }

        if (Exercicio1_1.isMatrixSquare(matrix)) {
            int[] principalDiagonal = Exercicio2_7.principalMatrixDiagonal(matrix);
            int[] secondaryDiagonal = Exercicio2_8.secundaryMatrixDiagonal(matrix);
            int determinant = determinantCalculation2By2Matrix(principalDiagonal, secondaryDiagonal);
            if(isInverseMatrix(determinant)){
                int[][] rearrangedMatrix = rearrangeMatrix(matrix);
                double[][] convertedMatrix = convertMatrixToInverseMatrix2By2(rearrangedMatrix, determinant);
                return convertedMatrix;
            }
        }
        return new double[][]{{-1}, {-1}};
    }

    public static int determinantCalculation2By2Matrix(int[]principalDiagonal, int[]secondaryDiagonal){
        int multiplicationPrincipalDiagonal = 1;
        int multiplicationSecondaryDiagonal = 1;
        int determinant = 0;
        for (int i = 0; i < principalDiagonal.length; i++) {
            multiplicationPrincipalDiagonal *= principalDiagonal[i];
            multiplicationSecondaryDiagonal *= secondaryDiagonal[i];
        }

        determinant = (multiplicationPrincipalDiagonal - multiplicationSecondaryDiagonal);
        return determinant;
    }

    public static boolean isInverseMatrix(int determinant) {
        if (determinant != 0) {
            return true;
        }
        return false;
    }

    public static int[][] rearrangeMatrix(int[][]matrix) {
        int temp = matrix[0][0];
        matrix[0][0] = matrix[1][1];
        matrix[1][1] = temp;

        matrix[0][1] = -matrix[0][1];
        matrix[1][0] = -matrix[1][0];
        return matrix;
    }

    public static double valueToMultiplyEachElementMatrix(int determinant) {
        return (double) 1 /determinant;
    }

    public static double[][] convertMatrixToInverseMatrix2By2(int[][] matrix, int determinant) {
        double valueToMultiply = valueToMultiplyEachElementMatrix(determinant);
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = newValuesForMatrix(matrix[i], valueToMultiply);
        }
        return newMatrix;
    }

    public static double[] newValuesForMatrix(int[] array, double valueToMultiply) {
        double[] newArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            BigDecimal result = BigDecimal.valueOf(array[i]).multiply(BigDecimal.valueOf(valueToMultiply));
            newArray[i] = result.setScale(1, RoundingMode.HALF_UP).doubleValue();
        }
        return newArray;
    }
}
