package org.example.Exercicio6;

public class BidimensionalVector {

    private int[][] _matrix;

    public BidimensionalVector(){
        this._matrix = new int[0][0];
    }


    public BidimensionalVector(int[][] newMatrix) {
        this._matrix = newMatrix;
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

    public int[] removeValue(int value, int totalValueAppear,int[] row) {
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
        int biggestValueMatrix = _matrix[0][0];
        for (int i = 0; i < _matrix.length; i++) {
            int biggestValueRow = getBiggestValueRow(_matrix[i]);
            if(biggestValueRow > biggestValueMatrix) {
                biggestValueMatrix = biggestValueRow;
            }
        }

        return biggestValueMatrix;
    }

    public int getBiggestValueRow(int[] row) {
        int biggestValue = row[0];
        for (int i = 0; i < row.length; i++) {
            int number = row[i];
            if (number > biggestValue) {
                biggestValue = number;
            }
        }
        return biggestValue;
    }
}
