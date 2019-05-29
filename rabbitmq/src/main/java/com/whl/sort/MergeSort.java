package com.whl.sort;

import java.util.Arrays;

/**
 * 〈归并排序〉
 *
 * @author whl
 * @create 2019/2/21
 * @since 1.0.0
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr, int start, int end) {
        int[] temp = new int[arr.length];
        sort(arr, start, end, temp);
    }


    public void sort(int[] arr, int start, int end, int[] temp) {
        if (arr == null || arr.length <= 0 || start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end, temp);
    }


    public void merge(int[] arr, int start, int mid, int end, int[] temp) {
        if (arr == null || arr.length <= 0 || start >= end) {
            return;
        }

        int left = start;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        while (right <= end) {
            temp[index++] = arr[right++];
        }

        index = 0;

        while (start <= end) {
            arr[start++] = temp[index++];
        }


    }

}