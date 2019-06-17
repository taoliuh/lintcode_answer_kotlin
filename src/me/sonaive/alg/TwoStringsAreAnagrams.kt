package me.sonaive.alg

/**
Description
Write a method anagram(s,t) to decide if two strings are anagrams or not.

Have you met this question in a real interview?
Clarification
What is Anagram?

Two strings are anagram if they can be the same after change the order of characters.
Example
Example 1:

Input: s = "ab", t = "ab"
Output: true
Example 2:

Input:  s = "abcd", t = "dcba"
Output: true
Example 3:

Input:  s = "ac", t = "ab"
Output: false
Challenge
O(n) time, O(1) extra space

 */
private const val NUM = 256

class TwoStringsAreAnagrams {
    fun isAnagram(s1: String, s2: String): Boolean {
        if (s1.isEmpty() || s2.isEmpty() || s1.length != s2.length) {
            return false
        }
        val counter = IntArray(NUM)
        for (i in s1.indices) {
            val index1 = s1[i].toInt()
            val index2 = s2[i].toInt()
            ++counter[index1]
            --counter[index2]
        }
        for (i in counter) {
            return if (i != 0) false else continue
        }
        return true
    }
}

fun main() {
    val s1 = "abcd"
    val s2 = "dcab"
    val result = TwoStringsAreAnagrams().isAnagram(s1, s2)
    println("$result")
}