package com.algorithm.kotlin.array

import java.util.*

class ArrayPartition {

    fun arrayPairSum(nums: IntArray): Int {
        var sum = 0
        Arrays.sort(nums)

        for ((i, n) in nums.withIndex()) {
            if (i % 2 == 0) {
                sum += n
            }
        }

        return sum
    }
}