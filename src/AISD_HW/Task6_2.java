package AISD_HW;

import java.util.Arrays;

public class Task6_2 {
    public static void main(String[] args) {
        int[] arr = new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        arr = merge(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] merge(int[] arr){
        int[] tmp;  //it's for swap
        int[] src = arr;
        int[] res = new int[arr.length];
        int size = 1;

        while(size< arr.length){
            for (int i=0;i< arr.length; i+=(2*size)) { // "i+=2*size" to make a couple
                mergeArr(src,i, src, i+size, res, i, size);
            }
            size*=2;
            tmp = src;
            src = res;
            res = tmp;
        }
        return res;
    }

    private static void mergeArr(int[] arr1, int start1, int[] arr2, int start2, int[] res, int startRes, int size){
        int i1 = start1;
        int i2 = start2;
        int i1L = Math.min(start1+size, arr1.length);
        int i2L = Math.min(start2+size, arr2.length);
        int resSize = i1L-i1 + i2L - i2;

        for(int i=startRes;i<startRes+resSize;i++){
            if(i1<i1L && (i2>= i2L || arr1[i1]<=arr2[i2])){
                res[i] = arr1[i1];
                i1++;
            }
            else{
                res[i] = arr2[i2];
                i2++;
            }
        }
    }
}
