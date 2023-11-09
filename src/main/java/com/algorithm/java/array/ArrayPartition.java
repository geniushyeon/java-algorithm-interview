package com.algorithm.java.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition
 */
public class ArrayPartition {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2};

        System.out.println(new ArrayPartition().mySolution(nums));
    }

    public int mySolution(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }

        return sum;
    }

    // 짝수 번째 값 계산
    // 정렬된 상태에서는 짝수 번째에 항상 작은 값이 위치
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
