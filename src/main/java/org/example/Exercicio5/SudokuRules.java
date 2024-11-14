package org.example.Exercicio5;

public class SudokuRules {

    private int[][] boardGame;
    private int boardGameTotalColumns;
    private int boardGameTotalRows;

    public SudokuRules(int[][] boardGame) {
        this.boardGame = boardGame;
        this.boardGameTotalColumns = boardGame[0].length;
        this.boardGameTotalRows = boardGame.length;
    }

    public boolean isNumberPossibleToPlayInRow(int numberToCheckIfCanBePlayed, int rowToPlay, int columnToPlay){
        int boardGameTotalRows = boardGame.length;
        for (int row = 0; row < boardGameTotalRows; row++){
            if(!isNumberInRow(row, numberToCheckIfCanBePlayed)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInRow(int row, int number){
        for (int column = 0; column < boardGameTotalColumns; column++) {
            int numberInRow = boardGame[row][column];
            if (numberInRow == number) {
                return true;
            }
        }
        return false;
    }


    public boolean isNumberPossibleToPlayInColumn(int numberToCheckIfCanBePlayed, int rowToPlay, int columnToPlay){
        for (int column = 0; column < boardGameTotalColumns; column++) {
            if(!isNumberInColumn(column, numberToCheckIfCanBePlayed)){
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInColumn(int column, int number){
        for (int row = 0; row < boardGameTotalRows; row++){
            int numberInColumn = boardGame[row][column];
            if (numberInColumn == number) {
                return true;
            }
        }
        return false;
        }
}
