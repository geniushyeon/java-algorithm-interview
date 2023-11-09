package com.algorithm.java.stringmanipulation;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"cat", "tan", "ant", "ate", "tea"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.mySolution(strs);

        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public List<List<String>> mySolution(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

        for (String s : strs) {
            String key = sort(s);

            if (!results.containsKey(key)) {
                results.put(key, new ArrayList<>());
            }

            results.get(key).add(s);
        }

        return new ArrayList<>(results.values());
    }

    private String sort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        return String.valueOf(charArray);
    }
}
