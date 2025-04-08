package object_senior;

import java.util.Arrays;

public class array {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 8, 2, 0, 9, 7, 3, 6};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, 5));//二分搜索

        int[] arr2 = new int[10];
        Arrays.fill(arr2,66);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        int[] target1 = Arrays.copyOf(arr3, 5);
        int[] target2 = Arrays.copyOfRange(arr3, 3, 5);
        int[] target3 = new int[10];
        System.arraycopy(arr, 0, target3, 0, 5);
        System.out.println(Arrays.toString(target1));
        System.out.println(Arrays.toString(target2));
        System.out.println(Arrays.toString(target3));

        int[][] array = new int[][]{{2, 8, 4, 1}, {9, 2, 0, 3}};
        System.out.println(Arrays.deepToString(array));
    }
}
