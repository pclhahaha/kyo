package com.amaterasu.kyo.leetcode;

/**
 * @description: 最长回文子串
 * @author: panchenlei
 * @create: 2020-03-30 13:48
 **/
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        return null;
    }

    private int lcs(String a, String b) {
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
            }
        }
        return dp[a.length()][b.length()];
    }
}
