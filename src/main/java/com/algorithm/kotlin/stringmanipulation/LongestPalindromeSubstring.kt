package com.algorithm.kotlin.stringmanipulation

class LongestPalindromeSubstring {

    private var left: Int = 0
    private var maxLen: Int = 0

    private fun extendPalindrome(s: String, j: Int, k: Int) {
        var l = j
        var r = k

        // 투 포인터가 유효한 범위 내에 있고, 양쪽 끝 문자가 일치하는 팰린드롬인 경우 범위 확장
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        // 기존 최대 길이보다 큰 경우 값 교체
        if (maxLen < r - l - 1) {
            left = l + 1
            maxLen = r - l - 1
        }
    }

    fun longestPalindrome(s: String): String {
        val length = s.length

        if (length < 2) {
            return s
        }

        for (i in 0 until length - 1) {
            extendPalindrome(s, i, i + 1)
            extendPalindrome(s, i, i + 2)
        }

        return s.substring(left, left + maxLen)
    }
}