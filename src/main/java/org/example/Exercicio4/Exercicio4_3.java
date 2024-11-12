package org.example.Exercicio4;

import java.util.ArrayList;

public class Exercicio4_3 {

    public static boolean findWordProvided(char[][] boardGame, ArrayList<Character> wordToFind, int beginRow,
                                           int beginColumn, int endRow, int endColumn) {



        if (beginRow == endRow && beginColumn <= endColumn ) {
            // Horizontal Left to Right
            if(Exercicio4_2.matchHorizontal(boardGame, wordToFind, beginRow, beginColumn)){
                return true;
            }
        }

        if(beginRow == endRow && beginColumn >= endColumn){
            // Horizontal Right to Left
            if(Exercicio4_2.matchHorizontalReversed(boardGame, wordToFind, beginRow, beginColumn)){
                return true;
            }
        }

        if(beginColumn == endColumn && beginRow <= endRow) {
            // Vertical Top to Bottom
            if(Exercicio4_2.matchVertical(boardGame, wordToFind, beginRow, beginColumn)){
                return true;
            }
        }

        if(beginColumn == endColumn && beginRow >= endRow) {
            // Vertical Bottom to Top
            if(Exercicio4_2.matchVerticalReversed(boardGame, wordToFind, beginRow, beginColumn)){
                return true;
            }
        }

        // Diagonal Top Left to Bottom Right
        if (beginRow < endRow && beginColumn < endColumn) {
            if (Exercicio4_2.matchDiagonalTopLeft(boardGame, wordToFind, beginRow, beginColumn)) {
                return true;
            }
        }

        // Diagonal Bottom Right to Top Left
        if (beginRow > endRow && beginColumn > endColumn) {
            if (Exercicio4_2.matchDiagonalBottomRight(boardGame, wordToFind, beginRow, beginColumn)) {
                return true;
            }
        }

        // Diagonal Top Right to Bottom Left
        if (beginRow < endRow && beginColumn > endColumn) {
            if (Exercicio4_2.matchDiagonalTopRight(boardGame, wordToFind, beginRow, beginColumn)) {
                return true;
            }
        }

        // Diagonal Bottom Left to Top Right
        if (beginRow > endRow && beginColumn < endColumn) {
            if (Exercicio4_2.matchDiagonalBottomLeft(boardGame, wordToFind, beginRow, beginColumn)) {
                return true;
            }
        }
        return false;
    }
}
