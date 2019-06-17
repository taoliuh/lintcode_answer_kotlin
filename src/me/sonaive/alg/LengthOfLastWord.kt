package me.sonaive.alg

/**
Description

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

A word is defined as a character sequence consists of non-space characters only.

Have you met this question in a real interview?
Example
Example 1:

Input: "Hello World"
Output: 5
Example 2:

Input: "Hello LintCode"
Output: 8
 */

class LengthOfLastWord {
    fun lengthOfLastWord(str: String?): Int {
        if (str.isNullOrEmpty()) {
            return 0
        }
        var length = 0
        for (i in str.length - 1 downTo 0) {
            if (str[i] == ' ') {
                if (length != 0) {
                    return length
                }
            } else{
                ++length
            }
        }
        return length
    }
}

fun main() {
    val str = "Hello World   "
    val length = LengthOfLastWord().lengthOfLastWord(str)
    print("$length")
}