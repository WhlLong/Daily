package com.whl.offer;

/**
 * 〈二维数组中的查找〉
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数组中。
 * <p>
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 * <p>
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 *
 * @author whl
 * @create 2019/7/18
 * @since 1.0.0
 */
public class SearchInDyadicArray {

    public boolean Find(int target, int[][] array) {

        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return false;
        }

        int x = array.length - 1;
        int y = 0;
        while (x >= 0 && y < array[0].length) {
            if (target == array[x][y]) {
                return true;
            }else if(target < array[x][y]){
                x--;
            }else{
                y++;
            }
        }


        return false;
    }


    public static void main(String[] args) {
        int[][] array = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};

        SearchInDyadicArray searchInDyadicArray = new SearchInDyadicArray();
        boolean result = searchInDyadicArray.Find(20,array);
        System.out.println(result);
    }

}