package com.algorithm.java.stringmanipulation;

/**
 * https://leetcode.com/problems/longest-palindromic-substring
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubstring().longestPalindrome("dcbabcdd"));
    }

    int left, maxLen;

    private void extendPalindrome(String s, int j, int k) {
        // 투 포인터가 유효한 범위 내에 있고, 양 끝 문자가 일치하는 팰린드롬인 경우 범위 확장
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        // 기존 최대 길이보다 큰 경우 값 교체
        if (maxLen < k - j - 1) {
            left = j + 1;
            maxLen = k - j - 1;
        }
    }

    public String longestPalindrome(String s) {
        // 문자 길이 저장
        int length = s.length();

        if (length < 2) {
            return s;
        }

        // 우측으로 한 칸씩 이동하며 투 포인터 조사
        for (int i = 0; i < length - 1; i++) {
            extendPalindrome(s, i, i + 1); // 2칸짜리 투 포인터
            extendPalindrome(s, i, i + 2); // 3칸짜리 투 포인터
        }

        return s.substring(left, left + maxLen);
    }
}
