package me.sonaive.alg

/**
Description

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Have you met this question in a real interview?
Example
Example 1

Input:
"aa"
"a"
Output: false
Example 2

Input:
"aa"
"aa"
Output: true
Example 3

Input:
"aaa"
"aa"
Output: false
Example 4

Input:
"aa"
"*"
Output: true
Explanation: '*' can replace any string
Example 5

Input:
"aa"
"a*"
Output: true
Example 6

Input:
"ab"
"?*"
Output: true
Explanation: '?' -> 'a' '*' -> 'b'
Example 7

Input:
"aab"
"c*a*b"
Output: false
Related Problems
 */

class WildcardMatching {
    fun isMatch1(s: String?, p: String?): Boolean {
        if (s.isNullOrEmpty() || p.isNullOrEmpty()) {
            return false
        }
        val m = s.length
        val n = p.length
        val dp = Array(m + 1) {BooleanArray(n + 1)}
        dp[0][0] = true
        for (i in 1 .. n) {
            if (p[i - 1] == '*') {
                dp[0][i] = dp[0][i - 1]
            }
        }
        for (i in 1 .. m) {
            for (j in 1 .. n) {
                if (p[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '?')
                }
            }
        }
        return dp[m][n]
    }

    fun isMatch2(s: String?, p: String?): Boolean {

        return false
    }


}

fun main() {
    val s = "abdfgddv"
    val p = "*d?g*v"
    val result = WildcardMatching().isMatch1(s, p)
    print("$result")
}