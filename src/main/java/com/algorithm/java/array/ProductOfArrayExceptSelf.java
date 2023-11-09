package com.algorithm.java.array;

/**
 * https://leetcode.com/problems/product-of-array-except-self
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7};
        int[] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);

        for (int num : result) {
            System.out.println(num);
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }

        return result;
    }
}
