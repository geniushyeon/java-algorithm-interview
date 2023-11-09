package com.algorithm.java.stringmanipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-common-word
 */
public class MostCommonWord {

    public String mySolution(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : words) {
            if (Arrays.asList(banned).contains(word)) {
                continue;
            }

            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        return Collections.max(wordsMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
