package lessons;

import java.util.Arrays;

public class lesson1_1 {

    public static void main(String[] args) {
        int counter = 0;
        int[] arr = {0, 1, 2, 3, 4, 5,};
        System.out.println(Arrays.toString( addNamberToArray(arr, counter)));
        System.out.println(Arrays.toString( addNamberToArray(arr, counter)));
    }

    static int[] addNamberToArray(int[] arr, int counter) {
        counter ++;
        int namberToAdd = counter;
        int[] resaltArr = new int[arr.length + 1];
        resaltArr[resaltArr.length - 1] = namberToAdd;
        for (int i = 0; i < arr.length; i++) {
            resaltArr[i] = arr[i];

        }

        return resaltArr;
    }
}
