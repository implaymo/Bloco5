package org.example.Bloco5.Exercicio5;

public class SudokuBoardValidation {

    private final int boardGameTotalColumns;
    private final int boardGameTotalRows;
    private final SudokuRules sudokuRules;

    public SudokuBoardValidation(int[][] boardGame) {
        this.boardGameTotalColumns = boardGame[0].length;
        this.boardGameTotalRows = boardGame.length;
        this.sudokuRules = new SudokuRules(boardGame);
    }


    public boolean isBoardValid(int[][] boardGame){
        for (int row = 0; row < boardGameTotalRows; row++) {
            if(!isRowValid(boardGame, row)) {
                return false;
            }
        }
        return true;

    }

    public boolean isRowValid(int[][] boardGame, int row) {
        for (int column = 0; column < boardGameTotalColumns; column++) {
            int numberInBoard = boardGame[row][column];
            int numberInBoardRow = row;
            int numberInBoardColumn = column;
            if(numberInBoard > 0) {
                if (!sudokuRules.isNumberValidInRow(numberInBoard, row, numberInBoardColumn) ||
                    !sudokuRules.isNumberValidInColumn(numberInBoard, column, numberInBoardRow) ||
                    !sudokuRules.isNumberValidIn3x3Matrix(numberInBoard, row, column)) {
                    return false;
                }
            }
        }
        return true;
    }



}
