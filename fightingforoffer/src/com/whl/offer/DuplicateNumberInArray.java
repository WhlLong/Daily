package com.whl.offer;

/**
 * 〈数组中重复的数字〉
 * <p>
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * <p>
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * <p>
 * Output:
 * 2
 *
 * @author whl
 * @create 2019/7/18
 * @since 1.0.0
 */
public class DuplicateNumberInArray {

    public boolean duplicate(int numbers[], int length, int[] duplication) {

        if (numbers == null || numbers.length <= 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {

                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }

                swap(numbers, i, numbers[i]);

            }
        }

        return false;
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }


    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5};
        int[] duplication = new int[1];

        DuplicateNumberInArray duplicateNumberInArray = new DuplicateNumberInArray();
        boolean result = duplicateNumberInArray.duplicate(numbers, numbers.length, duplication);
        if (result) {
            System.out.println(duplication[0]);
        } else {
            System.out.println("no");
        }
    }

}