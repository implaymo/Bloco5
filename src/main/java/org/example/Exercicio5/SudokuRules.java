package org.example.Exercicio5;

public class SudokuRules {

    private final int[][] boardGame;
    private final int boardGameTotalColumns;
    private final int boardGameTotalRows;

    public SudokuRules(int[][] boardGame) {
        this.boardGame = boardGame;
        this.boardGameTotalColumns = boardGame[0].length;
        this.boardGameTotalRows = boardGame.length;
    }

    public boolean isNumberValidInRow(int number, int numberRow, int numberColumn){
        for (int column = 0; column < boardGameTotalColumns; column++) {
            int numberInRow = boardGame[numberRow][column];
            if(column == numberColumn) {
                continue;
            }
            if (numberInRow == number) {
                return false;
            }
        }
        return true;
    }


    public boolean isNumberValidInColumn(int number, int numberColumn, int numberRow){
        for (int row = 0; row < boardGameTotalRows; row++){
            int numberInColumn = boardGame[row][numberColumn];
            if(row == numberRow) {
                continue;
            }
            if (numberInColumn == number) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumberValidIn3x3Matrix(int number, int numberRow, int columnRow) {
        int startRow = (numberRow / 3) * 3;
        int startColumn = (columnRow / 3) * 3;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int column = startColumn; column < startColumn + 3; column++) {
                if(row == numberRow && column == columnRow) {
                    continue;
                }
                if (boardGame[row][column] == number) {
                    return false;
                }
            }
        }
        return true;
    }


}
