package org.example.Exercicio5;

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
            if (numberInBoard != 0 && sudokuRules.isNumberInRow(numberInBoard, row) || sudokuRules.isNumberInColumn(numberInBoard, column)
                    || sudokuRules.isNumberIn3x3Matrix(numberInBoard, row, column)) {
                return false;
            }
        }
        return true;
    }



}
