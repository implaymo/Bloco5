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

    public boolean isNumberInRow(int number, int rowToPlay){
        for (int column = 0; column < boardGameTotalColumns; column++) {
            int numberInRow = boardGame[rowToPlay][column];
            if (numberInRow == number) {
                return true;
            }
        }
        return false;
    }


    public boolean isNumberInColumn(int number, int columnToPlay){
        for (int row = 0; row < boardGameTotalRows; row++){
            int numberInColumn = boardGame[row][columnToPlay];
            if (numberInColumn == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumberIn3x3Matrix(int number, int rowToPlay, int columnToPlay) {
        int startRow = (rowToPlay / 3) * 3;
        int startColumn = (columnToPlay / 3) * 3;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int column = startColumn; column < startColumn + 3; column++) {
                if (boardGame[row][column] == number) {
                    return true;
                }
            }
        }
        return false;
    }


}
