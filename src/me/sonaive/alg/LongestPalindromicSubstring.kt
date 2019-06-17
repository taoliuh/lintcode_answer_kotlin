package me.sonaive.alg

/**
Description

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Have you met this question in a real interview?
Example
Example 1:

Input:"abcdzdcab"
Output:"cdzdc"
Example 2:

Input:"aba"
Output:"aba"
Challenge
O(n2) time is acceptable. Can you do it in O(n) time.
 */

class LongestPalindromicSubstring {
    fun longestPalindrome(str: String?): String? {
        if (str.isNullOrEmpty()) {
            return str
        }
        var result = str[0].plus("")
        for (i in 1 until str.length) {
            val s1 = findLongestPalindrome(str, i, i)
            val s2 = findLongestPalindrome(str, i - 1, i)
            if (result.length < s1.length) {
                result = s1
            }
            if (result.length < s2.length) {
                result = s2
            }
        }
        return result
    }

    private fun findLongestPalindrome(str: String, left: Int, right: Int): String {
        var low = left
        var high = right
        while (low >= 0 && high < str.length) {
            if (str[low] != str[high]) {
                break
            }
            --low
            ++high
        }
        return str.substring(low + 1, high)
    }
}

fun main() {
    val str = "abcdzdcab"
    val result = LongestPalindromicSubstring().longestPalindrome(str)
    print("$result")
}