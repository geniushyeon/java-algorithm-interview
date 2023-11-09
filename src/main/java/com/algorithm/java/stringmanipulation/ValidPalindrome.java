package com.algorithm.java.stringmanipulation;

/**
 * https://leetcode.com/problems/valid-palindrome
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.mySolution("Do geese see God?"));
    }

    public boolean mySolution(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length / 2; i++) {
            int j = charArray.length - 1 - i;

            if (charArray[i] != charArray[j]) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome1(String s) {
        int start = 0;
        int end = s.length() - 1;

        // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
        while (start < end) {
            // 영숫자인지 판별하고 유효하지 않으면 한 칸씩 이동
            if (Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else { // 유효한 문자라면 앞글자와 뒷글자를 모두 소문자로 변경해 비교
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    // 하나라도 일치하지 않는다면 팰린드롬이 아니므로 return false
                    return false;
                }

                // 앞쪽 문자는 한 칸 뒤로, 뒤쪽 문자는 한 칸 앞으로 이동
                start++;
                end--;
            }
        }

        return true;
    }


    public boolean isPalindrome2(String s) {
        s = s.replaceAll("\\s\\W", "").toLowerCase();
        StringBuilder reverse = new StringBuilder(s).reverse();
        return s.contentEquals(reverse);
    }
}
