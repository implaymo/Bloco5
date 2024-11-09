package org.example.Exercicio2;

import org.example.Exercicio1.Exercicio1_1;

public class Exercicio2_10_2 {

    public static double[][] invertedMatrix3x3OrMore(int[][]matrix){
        if (Exercicio2_2.isArrayEmpty((matrix))){
            return new double[][]{{-1}, {-1}};
        }

        if (Exercicio1_1.isMatrixSquare(matrix)) {
            int [] arrayOfDeterminants = determinantOfAll2x2Matrix(matrix);
            int determinant = getDeterminant(arrayOfDeterminants);
            checkIfMatrixInvertible(determinant);
            int coFactor = getCoFactor(coFactorOfAll2x2Matrix(matrix));
        }
        return new double[][]{{-1}, {-1}};
    }

    public static boolean checkIfMatrixInvertible(int determinant) {
        if (determinant == 0) {
            return false;
        }
        return true;
    }

    public static int[] determinantOfAll2x2Matrix(int[][]matrix) {
        int index = 0;
        int row = 0;
        int column = 0;
        int[][] temporary2x2Matrix = new int[2][2];
        int[] determinantsOfAll2x2Matrix = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (i == index || j == index){
                    continue;
                }
                temporary2x2Matrix[row][column] = matrix[i][j];
                column++;
                if (column == 2) {
                    column = 0;
                    row++;
                }
                int[] principalDiagonal = Exercicio2_7.principalMatrixDiagonal(temporary2x2Matrix);
                int[] secondaryDiagonal = Exercicio2_8.secundaryMatrixDiagonal(temporary2x2Matrix);
                int temporaryDeterminant = Exercicio2_10_1.determinantCalculation2By2Matrix(principalDiagonal,secondaryDiagonal);
                determinantsOfAll2x2Matrix[i] = temporaryDeterminant;
            }
            index++;
        }
        return determinantsOfAll2x2Matrix;
    }

    public static int getDeterminant(int[] arrayOfDeterminants) {
        int determinant = 0;
        for (int i = 0; i < arrayOfDeterminants.length; i++) {
            if (i % 2 == 0) {
                determinant += arrayOfDeterminants[i];
            } else {
                determinant -= arrayOfDeterminants[i];
            }
        }
        return determinant;
    }

    public static int[] coFactorOfAll2x2Matrix(int[][]matrix){
        int index = 0;
        int row = 0;
        int column = 0;
        int[][] temporary2x2Matrix = new int[2][2];
        int[] coFactorOfAll2x2Matrix = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                temporary2x2Matrix[row][column] = matrix[i][j];
                column++;
                if (column == 2) {
                    column = 0;
                    row++;
                }
                int[] principalDiagonal = Exercicio2_7.principalMatrixDiagonal(temporary2x2Matrix);
                int[] secondaryDiagonal = Exercicio2_8.secundaryMatrixDiagonal(temporary2x2Matrix);
                int temporaryDeterminant = Exercicio2_10_1.determinantCalculation2By2Matrix(principalDiagonal,secondaryDiagonal);
                coFactorOfAll2x2Matrix[i] = temporaryDeterminant;
            }
            index++;
        }
        return coFactorOfAll2x2Matrix;
    }

    public static int getCoFactor(int[]arrayOfCofactors) {
        int coFactor = 0;
        for (int i = 0; i < arrayOfCofactors.length; i++) {
            if (i % 2 == 0) {
                coFactor += arrayOfCofactors[i];
            } else {
                coFactor -= arrayOfCofactors[i];
            }
        }
        return coFactor;
    }
}
