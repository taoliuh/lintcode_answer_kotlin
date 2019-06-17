package me.sonaive.alg

/**
13. Implement strStr()

Description
For a given source string and a target string, you should output the first index(from 0) of target string in source string.

If target does not exist in source, just return -1.
Example 1:

Input: source = "source" ，target = "target"
Output: -1
Explanation: If the source does not contain the target content, return - 1.
Example 2:

Input:source = "abcdabcdefg" ，target = "bcd"
Output: 1
Explanation: If the source contains the target content, return the location where the target first appeared in the source.
Challenge
O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)

 */
class StrStr {
    fun strStr(source: CharArray, target: CharArray): Int {
        if (source.isEmpty() || target.isEmpty()) {
            return -1
        }
        val len = source.size - target.size + 1
        for (i in 0 until len) {
            for (j in target.indices) {
                if (source[j + i] != target[j]) {
                    break
                }
                if (j == target.size - 1) {
                    return i
                }
            }

        }
        return -1
    }
}

fun main() {
    val source = charArrayOf('a', 'b', 'c', 'd', 'a', 'b', 'c', 'd', 'e', 'f', 'g')
    val target = charArrayOf('a', 'b', 'c', 'd', 'e')
    val index = StrStr().strStr(source, target)
    println("$index")
}