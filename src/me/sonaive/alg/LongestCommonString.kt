package me.sonaive.alg

/**
Description

Given two strings, find the longest common substring.

Return the length of it.

The characters in substring should occur continuously in original string. This is different with subsequence.

Have you met this question in a real interview?
Example
Example 1:
	Input:  "ABCD" and "CBCE"
	Output:  2

	Explanation:
	Longest common substring is "BC"


Example 2:
	Input: "ABCD" and "EACB"
	Output:  1

	Explanation:
	Longest common substring is 'A' or 'C' or 'B'
Challenge
O(n x m) time and memory.
 */

class LongestCommonString {
    fun lcs1(s1: String?, s2: String?): Int? {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return 0
        }
        var lcs = 0
        for (i in s1.indices) {
            for (j in s2.indices) {
                var temp = 0
                while (i + temp < s1.length && j + temp < s2.length && s1[i + temp] == s2[j + temp]) {
                    ++temp
                }
                lcs = if (lcs < temp) temp else lcs
            }
        }
        return lcs
    }

    fun lcs2(s1: String?, s2: String?): Int? {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return 0
        }
        val m = s1.length
        val n = s2.length
        val dp = Array(m + 1) {IntArray(n + 1)}
        for (i in s1.indices) {
            for (j in s2.indices) {
                if (s1[i] == s2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1
                }
            }
        }
        var max = 0
        for (i in IntRange(1, s1.length)) {
            for (j in IntRange(1, s2.length)) {
                max = Math.max(max, dp[i][j])
            }
        }
        return max
    }
}

fun main() {
    val s1 = "ABCDEFABCDFE"
    val s2 = "CBCEFABC"
    val result = LongestCommonString().lcs2(s1, s2)
    print("$result")
}