package org.example.Bloco5.Exercicio1;

public class Exercicio1_2 {

    public static boolean isMatrixRectangle(int[][] array){
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
