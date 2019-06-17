package me.sonaive.alg

class BubbleSort {
    fun bubbleSort(data: IntArray) {
        if (data.isEmpty()) {
            return
        }
        for (i in data.indices) {
            for (j in 1 until data.size - i) {
                if (data[j - 1] > data[j]) {
                    val temp = data[j]
                    data[j] = data[j - 1]
                    data[j - 1] = temp
                }
            }
        }
    }
}

fun main() {
    val data = intArrayOf(6, 5, 3, 1, 8, 7, 2, 4)
    BubbleSort().bubbleSort(data)
    for (i in data) {
        print("$i ")
    }
}