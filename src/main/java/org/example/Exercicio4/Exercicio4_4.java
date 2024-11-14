package org.example.Exercicio4;

import java.util.ArrayList;


public class Exercicio4_4 {

    public static boolean findWordProvided(char[][] boardGame, ArrayList<Character> wordOne, ArrayList<Character> wordTwo) {

        ArrayList<int[]> positionsWordOne;
        ArrayList<int[]> positionsWordTwo;

        positionsWordOne = checkPositionWord(boardGame, wordOne);
        positionsWordTwo = checkPositionWord(boardGame, wordTwo);

        if(checkIfPositionsMatch(positionsWordOne, positionsWordTwo)){
            return true;
        } else{
            return false;
        }

    }

    public static ArrayList<int[]> checkPositionWord(char[][]board, ArrayList<Character> word) {
        ArrayList<int[]> positions = new ArrayList<>();
        if(!isWordHorizontal(board, word).isEmpty()){
            positions.addAll(isWordHorizontal(board, word));
        } else if (!isWordHorizontalReversed(board, word).isEmpty()){
            positions.addAll(isWordHorizontalReversed(board, word));
        } else if (!isWordVertical(board, word).isEmpty()){
            positions.addAll(isWordVertical(board, word));
        } else if (!isWordVerticalReversed(board, word).isEmpty()){
            positions.addAll(isWordVerticalReversed(board, word));
        } else if (!isWordDiagonalTopLeft(board, word).isEmpty()){
            positions.addAll(isWordDiagonalTopLeft(board, word));
        } else if (!isWordDiagonalBottomLeft(board, word).isEmpty()){
            positions.addAll(isWordDiagonalBottomLeft(board, word));
        } else if (!isWordDiagonalTopRight(board, word).isEmpty()){
            positions.addAll(isWordDiagonalTopRight(board, word));
        } else if (!isWordDiagonalBottomRight(board, word).isEmpty()){
            positions.addAll(isWordDiagonalBottomRight(board, word));
        }
        return positions;
    }


    public static boolean checkIfPositionsMatch(ArrayList<int[]> wordOnePositions, ArrayList<int[]> wordTwoPositions) {
        for (int[] posOne : wordOnePositions) {
            for (int[] posTwo : wordTwoPositions) {
                if (posOne[0] == posTwo[0] && posOne[1] == posTwo[1]) {
                    return true;
                }
            }
        }
        return false;
    }


    public static ArrayList<int[]> isWordHorizontal(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = 0; row < boardGame.length; row++) {
            for (int column = 0; column <= boardGame[0].length - wordToFind.size(); column++) {
                ArrayList<int[]> positions = matchHorizontal(boardGame, wordToFind, row,column);
                if(positions.size() == wordToFind.size()) {
                    return positions;
                }
            }
        }
        return new ArrayList<>();
    }


    public static ArrayList<int[]> isWordHorizontalReversed(char[][] boardGame, ArrayList<Character> wordToFind){
        for (int row = 0; row < boardGame.length; row++) {
            for (int column = boardGame[0].length - 1; column >= wordToFind.size() - 1; column--) {
                ArrayList<int[]> positions = matchHorizontalReversed(boardGame, wordToFind, row ,column);
                if(positions.size() == wordToFind.size()) {
                    return positions;
                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordVertical(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int column = 0; column < boardGame[0].length; column++) {
            for (int row = 0; row <= boardGame.length - wordToFind.size(); row++) {
                ArrayList<int[]> positions = matchVertical(boardGame, wordToFind, row, column);
                if(positions.size() == wordToFind.size()) {
                    return positions;
                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordVerticalReversed(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int column = 0; column < boardGame[0].length; column++) {
            for (int row = boardGame.length - 1; row >= wordToFind.size() - 1; row--) {
                ArrayList<int[]> positions = matchVerticalReversed(boardGame, wordToFind, row, column);
                if(positions.size() == wordToFind.size()) {
                    return positions;
                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordDiagonalTopLeft(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = 0; row < boardGame.length; row++) {
            for(int column = 0; column < boardGame[0].length; column++) {
                ArrayList<int[]> positions = matchDiagonalTopLeft(boardGame, wordToFind, row, column);
                if(positions.size() == wordToFind.size()) {
                    return positions;
                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordDiagonalBottomLeft(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = boardGame.length -1 ; row > 0; row--) {
            for(int column = 0; column < boardGame[0].length; column++) {
                ArrayList<int[]> positions = matchDiagonalBottomLeft(boardGame, wordToFind, row, column);
                if(positions.size() == wordToFind.size()) {
                    return positions;
                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordDiagonalTopRight(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = 0; row < boardGame.length; row++) {
            for(int column = boardGame[0].length - 1; column > 0; column--) {
                ArrayList<int[]> positions = matchDiagonalTopRight(boardGame, wordToFind, row, column);
                if(positions.size() == wordToFind.size()) {
                    return positions;
                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordDiagonalBottomRight(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = boardGame.length - 1; row > 0; row--) {
            for(int column = boardGame[0].length - 1; column > 0; column--) {
                ArrayList<int[]> positions = matchDiagonalBottomRight(boardGame, wordToFind, row, column);
                if(positions.size() == wordToFind.size()) {
                    return positions;
                }
            }
        }
        return new ArrayList<>();
    }

    // Check Match Words in every direction

    public static ArrayList<int[]> matchHorizontal(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        ArrayList<int[]> positions = new ArrayList<>();
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row][column + i] != wordToFind.get(i)) {
                return new ArrayList<>();
            } else {
                positions.add(new int[]{row, column + i});
            }
        }
        return positions;
    }

    public static ArrayList<int[]> matchHorizontalReversed(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        ArrayList<int[]> positions = new ArrayList<>();
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row][column - i] != wordToFind.get(i)){
                return new ArrayList<>();
            } else {
                positions.add(new int[]{row, column - i});
            }
        }
        return positions;
    }


    public static ArrayList<int[]> matchVertical(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        ArrayList<int[]> positions = new ArrayList<>();
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row + i][column] != wordToFind.get(i)){
                return new ArrayList<>();

            } else {
                positions.add(new int[]{row + i, column});
            }
        }
        return positions;
    }

    public static ArrayList<int[]> matchVerticalReversed(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        ArrayList<int[]> positions = new ArrayList<>();
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row - i][column] != wordToFind.get(i)){
                return new ArrayList<>();
            } else{
                positions.add(new int[]{row - i, column});
            }
        }
        return positions;
    }


    public static ArrayList<int[]> matchDiagonalTopLeft(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        ArrayList<int[]> positions = new ArrayList<>();
        if (row + wordToFind.size() <= boardGame.length && column + wordToFind.size() <= boardGame[0].length) {
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row + i][column + i] != wordToFind.get(i)) {
                    return new ArrayList<>();
                } else {
                    positions.add(new int[]{row + i, column + i});
                }
            }

        }
        return positions;
    }

    public static ArrayList<int[]> matchDiagonalBottomLeft(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        ArrayList<int[]> positions = new ArrayList<>();
        if (row - wordToFind.size() >= -1 && column + wordToFind.size() <= boardGame[0].length) {
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row - i][column + i] != wordToFind.get(i)) {
                    return new ArrayList<>();
                } else {
                    positions.add(new int[]{row - i, column + i});
                }
            }
        }
        return positions;
    }

    public static ArrayList<int[]> matchDiagonalTopRight(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        ArrayList<int[]> positions = new ArrayList<>();
        if (row + wordToFind.size() <= boardGame.length && column - wordToFind.size() >= -1) {
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row + i][column - i] != wordToFind.get(i)) {
                    return new ArrayList<>();
                } else {
                    positions.add(new int[]{row + i, column - i});
                }
            }
        }
        return positions;
    }

    public static ArrayList<int[]> matchDiagonalBottomRight(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        ArrayList<int[]> positions = new ArrayList<>();
        if (row - wordToFind.size() >= -1 && column - wordToFind.size() >= -1) {
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row - i][column - i] != wordToFind.get(i)) {
                    return new ArrayList<>();
                } else {
                    positions.add(new int[]{row - i, column - i});
                }
            }
        }
        return positions;
    }
}

