package me.sonaive.alg

/**
Description
Given an array of strings, return all groups of strings that are anagrams.

All inputs will be in lower-case

Have you met this question in a real interview?
Example
Example 1:

Input:["lint", "intl", "inlt", "code"]
Output:["lint", "inlt", "intl"]
Example 2:

Input:["ab", "ba", "cd", "dc", "e"]
Output: ["ab", "ba", "cd", "dc"]
Challenge
What is Anagram?

Two strings are anagram if they can be the same after change the order of characters.
 */

class GroupAnagrams {
    fun groupAnagrams(list: List<String>?): List<String> {
        val result = ArrayList<String>()
        if (list == null || list.isEmpty()) {
            return result
        }
        val map = HashMap<String, ArrayList<String>>()
        for (s in list) {
            val arr = s.toCharArray()
            arr.sort()
            val sortedStr = String(arr)
            if (!map.containsKey(sortedStr)) {
                map[sortedStr] = ArrayList()
            }
            map[sortedStr]?.add(s)
        }
        for (v in map.values) {
            if (v.size > 1) {
                result.addAll(v)
            }
        }
        return result
    }
}

fun main() {
    val list = listOf("lint", "intl", "inlt", "code")
    val result = GroupAnagrams().groupAnagrams(list)
    for (s in result) {
        print("$s ")
    }
}