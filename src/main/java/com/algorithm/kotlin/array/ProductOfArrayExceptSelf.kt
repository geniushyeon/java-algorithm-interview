package com.algorithm.kotlin.array

class ProductOfArrayExceptSelf {

    fun productOfArrayExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        var left = 1
        for (i in nums.indices) {
            result[i] = left
            left *= result[i]
        }

        var right = 1
        for (i in nums.indices.reversed()) {
            result[i] *= right
            right *= nums[i]
        }

        return result
    }
}