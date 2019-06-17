package me.sonaive.alg
/**
Problem Statement
Given a string and an offset, rotate string by offset. (rotate from left to right)

Example

Given "abcdefg".

offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
Challenge

Rotate in-place with O(1) extra memory.
 */
class RotateString {
    fun rotateString(str: CharArray, offset: Int) {
        if (str.isEmpty()) {
            return
        }
        val peak = str.size - offset % str.size
        rotate(str, 0, peak - 1)
        rotate(str, peak, str.size - 1)
        rotate(str, 0, str.size - 1)
    }

    private fun rotate(str: CharArray, left: Int, right: Int) {
        var low = left
        var high = right
        while (low < high) {
            val temp = str[low]
            str[low] = str[high]
            str[high] = temp
            ++low
            --high
        }
    }
}

fun main() {
    val str = charArrayOf('c', 'p', 'p', 'j', 'a', 'v', 'a', 'p', 'y')
    RotateString().rotateString(str, 2)
    for (ch in str) {
        print("$ch ")
    }
}