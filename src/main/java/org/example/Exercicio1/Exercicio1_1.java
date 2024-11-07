package org.example.Exercicio1;

public class Exercicio1_1 {

    public static boolean exercicio1_1(int[][] array){
        int totalColumns = array.length;
        for (int i = 0; i < array.length; i++) {
            if (totalColumns != array[i].length) {
                return false;
            }
        }
        return true;
    }
}
