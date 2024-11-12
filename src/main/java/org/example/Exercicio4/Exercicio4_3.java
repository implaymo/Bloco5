package org.example.Exercicio4;

import java.util.ArrayList;

public class Exercicio4_3 {

    public static boolean findWordProvided(char[][] boardGame, ArrayList<Character> wordToFind, int rowBeginWord,
                                           int columnBeginWord, int rowEndWord, int columnEndWord) {



        if (rowBeginWord == rowEndWord && columnBeginWord <= columnEndWord) {
            // Horizontal Left to Right
        }

        if(rowBeginWord == rowEndWord && columnBeginWord >= columnEndWord){
            // Horizontal Right to Left
        }

        if(columnBeginWord == columnEndWord && rowBeginWord <= rowEndWord) {
            // Vertical Top to Bottom
        }

        if(columnBeginWord == columnEndWord && rowBeginWord >= rowEndWord) {
            // Vertical Bottom to Top
        }

        if(rowBeginWord == columnBeginWord && rowEndWord == columnEndWord && rowBeginWord < rowEndWord) {
            // Diagonal Top Left or Right
        }

        if(rowBeginWord == columnBeginWord && rowEndWord == columnEndWord && rowBeginWord > rowEndWord) {
            // Diagonal Bottom Left or Right
        }
        return false;
    }
}
