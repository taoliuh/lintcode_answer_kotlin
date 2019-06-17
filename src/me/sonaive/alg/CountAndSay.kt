package me.sonaive.alg

/**
Description

The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.

11 is read off as "two 1s" or 21.

21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

The sequence of integers will be represented as a string.

Have you met this question in a real interview?
Example
Example 1:

Input: 1
Output: "1"
Example 2:

Input: 5
Output: "111221"

Input: 6
Output: "312211"
 */

class CountAndSay {
    fun countAndSay(n: Int): String {
        if (n <= 0) {
            return ""
        }
        if (n == 1) {
            return "1"
        }
        val s = countAndSay(n - 1)
        val sb = StringBuilder()
        var count = 1
        for (i in 0 until s.length) {
            if (i + 1 < s.length && s[i] == s[i + 1]) {
                ++count
            } else {
                sb.append(count).append(s[i])
                count = 1
            }
        }
        return sb.toString()
    }
}

fun main() {
    val s = CountAndSay().countAndSay(7)
    print(s)
}