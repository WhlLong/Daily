package com.whl.sort;


import java.util.Arrays;

/**
 * 〈快速排序〉
 *
 * @author whl
 * @create 2019/2/21
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,2,4,6,8};
        QuickSort sort = new QuickSort();
        sort.sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 从大到小排序
     * @param arr
     * @param start
     * @param end
     */
    private void sort(int arr[], int start, int end) {

        if (arr == null || arr.length <= 1 || start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int val = arr[(left + right) / 2];
        while (left <= right) {
            while (val < arr[left]) {
                left++;
            }
            while(val > arr[right]){
                right--;
            }

            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }else if(left == right){
                left++;
            }
        }

        sort(arr,start,right);
        sort(arr,left,end);

    }

}