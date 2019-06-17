package me.sonaive.alg

/**
Description

Write a method to replace all spaces in a string with %20. The string is given in a characters array, you can assume it has enough space for replacement and you are given the true length of the string.

You code should also return the new length of the string after replacement.

If you are using Java or Python，please use characters array instead of string.

Have you met this question in a real interview?
Example
Example 1:

Input: string[] = "Mr John Smith" and length = 13
Output: string[] = "Mr%20John%20Smith" and return 17
Explanation:
The string after replacement should be "Mr%20John%20Smith", you need to change the string in-place and return the new length 17.

Challenge
Do it in-place.
 */

class SpaceReplacement {
    fun replaceSpace(str: CharArray?, len: Int): Int {
        if (str == null || str.isEmpty()) {
            return 0
        }
        var space = 0
        for (i in 0 .. len) {
            if (str[i] == ' ') {
                ++space
            }
        }
        var newLength = len + space * 2
        val resizeLength = newLength
        for (i in len downTo 0) {
            if (str[i] != ' ') {
                str[newLength--] = str[i]
            } else {
                str[newLength--] = '0'
                str[newLength--] = '2'
                str[newLength--] = '%'
            }
        }
        return resizeLength
    }
}

fun main() {
    val str = "Mr John Smith".toCharArray()
    val newStr = str.copyOf(100)
    val result = SpaceReplacement().replaceSpace(newStr, str.size)
    print("${String(newStr, 0, result)}\nlength=$result")
}