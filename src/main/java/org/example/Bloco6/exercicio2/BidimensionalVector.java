package org.example.Bloco6.exercicio2;

import org.example.Bloco5.Exercicio1.Exercicio1_1;
import org.example.Bloco5.Exercicio2.*;
import org.example.Bloco6.exercicio1.VectorExercise6;

import java.util.Arrays;
import java.util.Vector;

public class BidimensionalVector {

    private int[][] _matrix;

    public BidimensionalVector(){
        this._matrix = new int[0][0];
    }


    public BidimensionalVector(int[][] matrix) {
        if (matrix == null) {
            this._matrix = null;
        } else{
            this._matrix = copyMatrix(matrix);
        }
    }

    public int[][] copyMatrix(int[][] matrix) {
        int[][] copyMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i] == null) {
                return null;
            }
            VectorExercise6 vectorExercise6 = new VectorExercise6(matrix[i]);
            int[] row = vectorExercise6.copyVector(matrix[i]);
            copyMatrix[i] = row;
        }
        return  copyMatrix;
    }

    /// ///////////////////////// Exercise 3 /////////////////////////////
    public boolean hasAddValue(int value, int rowToAddValue) {
        for (int i = 0; i < _matrix.length; i++) {
            if (i == rowToAddValue) {
                int[] rowToAddColumn = _matrix[i];
                _matrix[i] = addValueToRow(value, rowToAddColumn);
                return true;
            }
        }

        return false;
    }

    public int[] addValueToRow(int value, int[] rowToAddColumn) {
        int[] newRow = new int[rowToAddColumn.length + 1];
        for (int i = 0; i < newRow.length; i++) {
            int lastColumnNewRow = newRow.length - 1;
            if (i == lastColumnNewRow) {
                newRow[i] = value;
            } else {
                newRow[i] = rowToAddColumn[i];
            }
        }
        return newRow;
    }

    /// //////////////////////////////////////////////////

    /// ///////////////////////// Exercise 4 ////////////////////////////

    public boolean hasRemovedValue(int value) {
        for (int i = 0; i < _matrix.length; i++) {
            int[] row = _matrix[i];
            int totalValueAppear = totalTimesValueAppear(value, row);
            if (totalValueAppear > 0) {
                removeValue(value, totalValueAppear, row);
            }
        }
        return true;
    }

    public int totalTimesValueAppear(int value, int[] row) {
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            int number = row[i];
            if (number == value) {
                count++;
            }
        }
        return count;
    }

    public int[] removeValue(int value, int totalValueAppear, int[] row) {
        int newSizeOfRow = row.length - totalValueAppear;
        int[] newRow = new int[newSizeOfRow];
        int index = 0;
        for (int i = 0; i < row.length; i++) {
            int number = row[i];
            if (number == value) {
                continue;
            }
            newRow[index] = row[i];
            index++;
        }
        return  newRow;
    }

    /// /////////////////////////////////////////////////////

    /// /////////////////////// Exercise 5 ///////////////////////////////////

    public boolean isMatrixNullOrEmpty(){
        if (_matrix == null) {
            return true;
        }

        for (int i = 0; i < _matrix.length; i++) {
            if(isRowNullOrEmpty(_matrix[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isRowNullOrEmpty(int[] row){
        if (row == null || row.length == 0) {
            return true;
        }
        return false;
    }

    /// /////////////////////////////////////////////////////

    /// ///////////////// Exercise 6 ////////////////////////

    public int getBiggestValueMatrix() {
        if (isMatrixNullOrEmpty()) {
            return -1;
        }
        int biggestValueMatrix = Exercicio2_2.getHighestNumber(_matrix);

        return biggestValueMatrix;
    }

    /// //////////////////////////////////////77

    /// /////////////// Exercise7 ////////////////////////////

    public int getLowestValueMatrix() {
        if(isMatrixNullOrEmpty()){
            return -1;
        }

        int lowestValueMatrix = Exercicio2_1.getLowestNumber(_matrix);
        return lowestValueMatrix;
    }

    ////////////////////////////////////////////////////

    public double getAverageMatrix() {
        if (isMatrixNullOrEmpty()) {
            return -1;
        }

        return Exercicio2_3.averageNumber(_matrix);
    }


    /// ///////////////////////// Exercise 9 ////////////////////////////

    public int[] getRowsSum(){
        if (isMatrixNullOrEmpty()) {
            return new int[]{-1};
        }

        int[] arrayOfSumMatrixRow = new int[_matrix.length];
        for (int i = 0; i < _matrix.length; i++) {
            arrayOfSumMatrixRow[i] = Exercicio2_3.sumLineNumbers(_matrix[i]);
        }
        return arrayOfSumMatrixRow;
    }

    /// /////////////////////////////////////////////////////

    /// ////////////////////////// Exercise 10 //////////////////////

    public int[] getSumOfEachColumn(){
        if (isMatrixNullOrEmpty()) {
            return new int[]{-1};
        }

        int[] sumEachColumn = new int[_matrix.length];

        for (int column = 0; column < _matrix.length; column++) {
            sumEachColumn[column] = getSumOfColumn(column);
        }
        return sumEachColumn;
    }

    public int getSumOfColumn(int column){
        int sumColumn = 0;
        for (int row = 0; row < _matrix.length; row++) {
            int sizeOfRow = _matrix[row].length;
            if (column < sizeOfRow) {
                sumColumn += _matrix[row][column];
            }
        }
        return sumColumn;
    }

    /// //////////////////////////////////////////////////////////////////

    /// /////////////////////////// Exercise 11 ////////////////////////

    public int getIndexArrayWithBiggestSumOfElements(){
        if (isMatrixNullOrEmpty()) {
            return -1;
        }

        int arrayWithBiggestSum = 0;
        int sumElementsArray = 0;
        int indexOfArrayBiggestSum = 0;
        for (int i = 0; i < _matrix.length; i++){
            sumElementsArray = Exercicio2_3.sumLineNumbers(_matrix[i]);
            if (sumElementsArray > arrayWithBiggestSum) {
                arrayWithBiggestSum = sumElementsArray;
                indexOfArrayBiggestSum = i;
            }
        }

        return indexOfArrayBiggestSum;
    }

    /// //////////////////////////////////////////////////////////////////////////

    /// //////////////////////// Exercise 12 ///////////////////////////////////

    public boolean isMatrixSquare() {
        if (isMatrixNullOrEmpty()) {
            return false;
        }
        return Exercicio1_1.isMatrixSquare(_matrix);
    }

    /// /////////////////////////////////////////////////////////////////////////

    /// ////////////////////////// Exercise 13 ////////////////////////////////

    public boolean isMatrixSquareAndSymmetric(){
        int[][] transposeMatrix = Exercicio2_11.transposeMatrix(_matrix);
        if(Arrays.deepEquals(_matrix, transposeMatrix)){
            return true;
        }
        return false;
    }

    /// //////////////////////////////////////////////////////////////////////

    /// ///////////////////////// Exercise 14 //////////////////////////////

    public int getTotalOfNoneNegativeNumbersInPrincipalDiagonal(){
        if (isMatrixNullOrEmpty() || !isMatrixSquare()) {
            return -1;
        }
        int[] principalDiagonal = Exercicio2_7.principalMatrixDiagonal(_matrix);
        int totalNoneNegativeNumbers = 0;
        for (int i = 0; i < principalDiagonal.length; i++){
            if (principalDiagonal[i] >= 0) {
                totalNoneNegativeNumbers++;
            }
        }
        return totalNoneNegativeNumbers;
    }

    /// /////////////////////////////// Exercise 15 ///////////////////////////////

    public boolean isPrincipalDiagonalEqualSecondaryDiagonalAndSameDigitOrder(){
        int[] principalDiagonal = Exercicio2_7.principalMatrixDiagonal(_matrix);
        int[] secondaryDiagonal = Exercicio2_8.secundaryMatrixDiagonal(_matrix);
        if (Arrays.equals(principalDiagonal, secondaryDiagonal)) {
            return true;
        }
        return false;
    }

    /// /////////////////////////////////////////////////////////////////////

    /// //////////////////////// Exercise 16 //////////////////////////////

    public int[] getAllElementsWhichHaveHigherEvenDigitsPercentageThanTheAverageOfEvenDigits(){

        return new int[] {-1};
    }

    /// /////////////////////////////////////////////////////////////////

}
