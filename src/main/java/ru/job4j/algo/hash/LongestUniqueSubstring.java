package ru.job4j.algo.hash;

import java.util.HashMap;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        String substr = "";
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }
            map.put(c, end);

            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                substr = str.substring(start, end + 1);
            }
        }

        return substr;
    }
}
