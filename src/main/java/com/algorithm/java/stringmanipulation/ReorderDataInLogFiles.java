package com.algorithm.java.stringmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files
 */
public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }

        // 문자 리스트 정렬
        letters.sort((s1, s2) -> {
            // 식별자와 식별자 외 나머지 부분으로 나눔
            String[] splitS1 = s1.split(" ", 2);
            String[] splitS2 = s2.split(" ", 2);

            // 문자 로그 사전순 비교
            int compared = splitS1[1].compareTo(splitS2[1]);

            // 문자가 동일한 경우 식별자 비교
            if (compared == 0) {
                return splitS1[0].compareTo(splitS2[0]);
            }

            return compared;
        });

        // 문자 리스트 뒤로 숫자 리스트 이어 붙이기
        // 숫자 로그는 '입력 순서대로'라는 조건이 있으므로 따로 정렬하지 않음
        letters.addAll(digits);

        return letters.toArray(new String[0]);
    }
}
