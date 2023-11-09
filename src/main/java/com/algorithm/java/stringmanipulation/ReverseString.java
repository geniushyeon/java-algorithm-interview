package com.algorithm.java.stringmanipulation;

/**
 * https://leetcode.com/problems/reverse-string
 * 입력값은 문자 뱅려이며, 리턴 없이 입력 배열 내부를 직접 조작
 */
public class ReverseString {

    public void mySolution(char[] s) {
        for (int start = 0; start < s.length / 2; start++) {
            int end = s.length - 1 - start;

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
        }
    }
}
