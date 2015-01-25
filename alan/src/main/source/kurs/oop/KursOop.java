package kurs.oop;

public class KursOop {
    public static void main(String[] args) {
        int counter = 0;
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int min = 1;
        int max = 9;
        int[] arrayResult = masiv(array, min, max);

    }

    public static int[] masiv(int[] array, int min, int max) {
        int[] resultArray;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > min && array[i] < max) {
                counter++;
            }
        }

        resultArray = new int[counter];
        counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > min && array[i] < max) {
                resultArray[counter] = array[i];
                System.out.print(array[i] + " ");
                counter++;
            }
        }
        return resultArray;


    }


}

