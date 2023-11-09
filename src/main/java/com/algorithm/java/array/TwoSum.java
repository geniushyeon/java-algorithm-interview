package com.algorithm.java.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        int[] answer = new TwoSum().twoSum2(nums, target);

        System.out.println(answer.length);
    }

    // 브루트 포스 풀이
    public int[] mySolution(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }

    // 첫번째 수를 뺀 결과 키 조회
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        // target에서 첫번째 수를 뺀 결과를 키로 조회하고, 현재 인덱스가 아닌 경우 정답으로 리턴
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
        }

        return null;
    }

    // 조회 구조 개선
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }

            numsMap.put(nums[i], i);
        }

        return null;
    }
}
