package com.firelord.leet.greed;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 */
public class Problem455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {
//        int res = findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        int res = findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
        System.out.println(res);
    }
}
