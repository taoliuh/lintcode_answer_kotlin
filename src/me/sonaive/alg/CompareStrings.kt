package me.sonaive.alg

/**
Description
Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

The characters of B in A are not necessary continuous or ordered.

Have you met this question in a real interview?
Example
For A = "ABCD", B = "ACD", return true.

For A = "ABCD", B = "AABC", return false.
 */

private const val NUM = 26

class CompareStrings {
    fun compare(s1: String, s2: String): Boolean {
        if (s1.isEmpty() || s2.isEmpty() || s1.length < s2.length) {
            return false
        }
        val counter = IntArray(NUM)
        for (i in s1.indices) {
            val index1 = s1[i] - 'A'
            ++counter[index1]
        }
        for (i in s2.indices) {
            val index2 = s2[i] - 'A'
            --counter[index2]
            if (counter[index2] < 0) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val s1 = "ABCD"
    val s2 = "ACD"
    val result = CompareStrings().compare(s1, s2)
    println("$result")
}