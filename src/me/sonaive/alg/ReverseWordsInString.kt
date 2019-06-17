package me.sonaive.alg

/**
Description

Given an input string, reverse the string word by word.

Have you met this question in a real interview?
Clarification
What constitutes a word?
A sequence of non-space characters constitutes a word and some words have punctuation at the end.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
Example
Example 1:
	Input:  "the sky is blue"
	Output:  "blue is sky the"

	Explanation:
	return a reverse the string word by word.

Example 2:
	Input:  "hello world"
	Output:  "world hello"

	Explanation:
	return a reverse the string word by word.

 */

class ReverseWordsInString {
    fun reverseWords(str: String?): String? {
        if (str.isNullOrBlank()) {
            return str
        }
        val split = str.split(' ')
        var result = ""
        for (i in split.size - 1 downTo 0) {
            if (split[i] != "") {
                if (result.isNotEmpty()) {
                    result = result.plus(" ")
                }
                result = result.plus(split[i])
            }
        }
        return result
    }
}

fun main() {
    val str = "the sky is blue"
    val result = ReverseWordsInString().reverseWords(str)
    print("$result")
}