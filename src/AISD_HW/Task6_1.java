package AISD_HW;

import java.util.Arrays;

public class Task6_1 {
    public static void main(String[] args) {
        int[] arr = new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        arr = merge(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] merge(int[] arr) {
        if (arr == null)
            return null;
        if (arr.length < 2)
            return arr;
        int[] arr1 = new int[arr.length / 2];
        int[] arr2 = new int[arr.length - arr1.length];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, arr1.length, arr2, 0, arr2.length);
        return mergeArr(merge(arr1), merge(arr2));
    }

    private static int[] mergeArr(int[] arr1, int[] arr2) {
        int i1 = 0;
        int i2 = 0;
        int i1L = arr1.length;
        int i2L = arr2.length;
        int[] res = new int[arr1.length + arr2.length];
        for (int i = 0; i < res.length; i++) {
            if(i1<i1L && (i2>= i2L || arr1[i1]<=arr2[i2])){
                res[i] = arr1[i1];
                i1++;
            }
            else {
                res[i] = arr2[i2];
                i2++;
            }
        }
        return res;
    }

}
