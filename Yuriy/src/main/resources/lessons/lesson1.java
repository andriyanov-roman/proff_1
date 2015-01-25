package lessons;

import java.util.Arrays;

public class lesson1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int min = 1;
        int max = 5;
        System.out.println(Arrays.toString(specifiedRange(arr, min, max)));

    }

    static int[] specifiedRange(int[] arr, int min, int max) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min && arr[i] < max) {
                counter++;
            }

        }

        int[] arraySecond = new int[counter];
        counter = 0;    // в этом случае счетчик ограничивает размер нового массива !!!
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min && arr[i] < max) {
                arraySecond[counter] = arr[i];
                counter++;
            }
        }
        return arraySecond;

    }
}