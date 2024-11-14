package org.example.Exercicio4;

import java.util.ArrayList;

public class Exercicio4_2 {

    public static boolean wordSearchGame(char[][] boardGame, ArrayList<Character> wordToFind){
        if (isWordVertical(boardGame, wordToFind) || isWordVerticalReversed(boardGame, wordToFind) ||
                isWordHorizontal(boardGame, wordToFind) || isWordHorizontalReversed(boardGame, wordToFind) ||
                isWordDiagonalTopLeft(boardGame, wordToFind) || isWordDiagonalTopRight(boardGame, wordToFind) ||
                isWordDiagonalBottomLeft(boardGame, wordToFind) || isWordDiagonalBottomRight(boardGame, wordToFind)){
            return true;
        } else{
            return false;
        }
    }

    public static boolean isWordHorizontal(char[][] boardGame, ArrayList<Character> wordToFind){
        for (int row = 0; row < boardGame.length; row++) {
            for (int column = 0; column <= boardGame[0].length - wordToFind.size(); column++) {
                if(matchHorizontal(boardGame, wordToFind, row, column)){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean isWordHorizontalReversed(char[][] boardGame, ArrayList<Character> wordToFind){
        for (int row = 0; row < boardGame.length; row++) {
            for (int column = boardGame[0].length - 1; column >= wordToFind.size() - 1; column--) {
                if(matchHorizontalReversed(boardGame, wordToFind, row ,column)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordVertical(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int column = 0; column < boardGame[0].length; column++) {
            for (int row = 0; row <= boardGame.length - wordToFind.size(); row++) {
                if(matchVertical(boardGame, wordToFind, row, column)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordVerticalReversed(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int column = 0; column < boardGame[0].length; column++) {
            for (int row = boardGame.length - 1; row >= wordToFind.size() - 1; row--) {
                if(matchVerticalReversed(boardGame, wordToFind, row, column)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordDiagonalTopLeft(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = 0; row < boardGame.length; row++) {
            for(int column = 0; column < boardGame[0].length; column++) {
                if(matchDiagonalTopLeft(boardGame, wordToFind, row, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordDiagonalBottomLeft(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = boardGame.length -1 ; row > 0; row--) {
            for(int column = 0; column < boardGame[0].length; column++) {
                if(matchDiagonalBottomLeft(boardGame, wordToFind, row, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordDiagonalTopRight(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = 0; row < boardGame.length; row++) {
            for(int column = boardGame[0].length - 1; column > 0; column--) {
                if(matchDiagonalTopRight(boardGame, wordToFind, row, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordDiagonalBottomRight(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = boardGame.length - 1; row > 0; row--) {
            for(int column = boardGame[0].length - 1; column > 0; column--) {
                if(matchDiagonalBottomRight(boardGame, wordToFind, row, column)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean matchHorizontal(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row][column + i] != wordToFind.get(i)){
                return false;
            }
        }
        return true;
    }

    public static boolean matchHorizontalReversed(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row][column - i] != wordToFind.get(i)){
                return false;
            }
        }
        return true;
    }


    public static boolean matchVertical(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row + i][column] != wordToFind.get(i)){
                return false;
            }
        }
        return true;
    }

    public static boolean matchVerticalReversed(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row - i][column] != wordToFind.get(i)){
                return false;
            }
        }
        return true;
    }


    public static boolean matchDiagonalTopLeft(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        if (row + wordToFind.size() <= boardGame.length && column + wordToFind.size() <= boardGame[0].length) {
            boolean match = true;
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row + i][column + i] != wordToFind.get(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    public static boolean matchDiagonalBottomLeft(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        if (row - wordToFind.size() >= -1 && column + wordToFind.size() <= boardGame[0].length) {
            boolean match = true;
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row - i][column + i] != wordToFind.get(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    public static boolean matchDiagonalTopRight(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        if (row + wordToFind.size() <= boardGame.length && column - wordToFind.size() >= -1) {
            boolean match = true;
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row + i][column - i] != wordToFind.get(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    public static boolean matchDiagonalBottomRight(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        if (row - wordToFind.size() >= -1 && column - wordToFind.size() >= -1) {
            boolean match = true;
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row - i][column - i] != wordToFind.get(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}