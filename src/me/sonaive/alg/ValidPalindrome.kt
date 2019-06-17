package me.sonaive.alg

/**
Description

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Have you met this question in a real interview?
Example
Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama"
Example 2:

Input: "race a car"
Output: false
Explanation: "raceacar"
Challenge
O(n) time without extra memory.
 */

class ValidPalindrome {
    fun isValidPalindrome(str: String?): Boolean {
        if (str.isNullOrEmpty()) {
            return true
        }
        var left = 0
        var right = str.length - 1
        while (left < right) {
            while (left < right && !str[left].isLetterOrDigit()) {
                ++left
            }
            while (left < right && !str[right].isLetterOrDigit()) {
                --right
            }
            if (!str[left].equals(str[right], true)) {
                return false
            }
            ++left
            --right
        }
        return true
    }
}

fun main() {
    val str = "A man, a plan, a canal: Panama"
    val result = ValidPalindrome().isValidPalindrome(str)
    print("$result")
}