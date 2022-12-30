package Codesignal.Basic;

import java.util.HashMap;
import java.util.Map;

public class CommonCharacterCountWithMaps {
    private static int countCommonChars(String s1, String s2) {
        Map<Character, int[]> counterMap = new HashMap<>();

        //for the first string
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(!counterMap.containsKey(c)) {
                int[] counters = new int[2];
                counters[0] = 1;
                counterMap.put(c, counters);
            } else {
                int[] counters = counterMap.get(c);
                counters[0] += 1;
            }
        }

        //for the second string
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if(!counterMap.containsKey(c)) {
                int[] counters = new int[2];
                counters[1] = 1;
                counterMap.put(c, counters);
            } else {
                int[] counters = counterMap.get(c);
                counters[1] += 1;
            }
        }

        int totalSum = 0;
        for(int[] counters : counterMap.values()) {
            totalSum += Math.min(counters[0], counters[1]);
        }

        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(countCommonChars("jjjdjdjf", "jogsnjfnsdj"));
        System.out.println(countCommonChars("a", "aaa"));
        System.out.println(countCommonChars("aabcc", "adcaa"));

    }
}
