package org.example.Exercicio1;

public class Exercicio1_2 {

    public static boolean exercicio1_2(int[][] array){
        int totalColumns = array.length;

        for (int i = 0; i < array.length; i++){
            if (Exercicio1_3.isColumnsDifferent(array, array[i])) {
                return false;
            }
            if (totalColumns == array[i].length) {
                return false;
            }
        }
        return true;
    }
}
