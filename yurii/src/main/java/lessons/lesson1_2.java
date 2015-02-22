package lessons;

import java.util.Arrays;

public class lesson1_2 {

    public static void main(String[] args) {

        int []arr = {1,2,3};
        main2(arr);
        System.out.println(Arrays.toString(main2(arr)));;

    }

    private static int[] main2(int[] arr) {
        arr [0] = 5;
        arr = new int[10];
        return arr;
    }


}
