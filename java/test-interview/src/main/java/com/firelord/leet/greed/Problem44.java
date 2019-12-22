package com.firelord.leet.greed;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 */
public class Problem44 {
    public static boolean isMatch(String testStr, String pattern) {
        int testStrLength = testStr.length();
        int patternLength = pattern.length();
        int iStart = -1;
        int jStart = -1;
        int i = 0;
        int j = 0;
        while (i < testStrLength) {
            if (j < patternLength && pattern.charAt(j) == '*') {
                jStart = j;
                iStart = i;
                j++;
            }
            else if (j < patternLength &&
                    (testStr.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
                i++;
                j++;
            }
            else if (jStart > -1) {
                j = jStart;
                i = iStart + 1;
            }
            else {
                return false;
            }
        }

        while (j < patternLength && pattern.charAt(j) == '*') {
            j++;
        }
        return j == patternLength;
    }

    public static void main(String[] args) {
        boolean res = isMatch("aa", "a");
//        boolean res = isMatch("aa", "*");
//        boolean res = isMatch("cb", "?a");
//        boolean res = isMatch("adceb", "*a*b");
//        boolean res = isMatch("acdcb", "a*c?b");
        System.out.println(res);
    }
}
