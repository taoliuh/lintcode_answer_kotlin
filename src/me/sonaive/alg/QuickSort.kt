package me.sonaive.alg

class QuickSort {
    fun quickSort(data: IntArray, left: Int, right: Int) {
        if (data.isEmpty() || left >= right || left < 0 || right >= data.size) {
            return
        }
        val pivotIndex = partition(data, left, right)
        quickSort(data, left, pivotIndex - 1)
        quickSort(data, pivotIndex + 1, right)
    }

    private fun partition(data: IntArray, left: Int, right: Int): Int {
        var low = left
        var high = right
        val pivot = data[right]
        while (low < high) {
            while (low < high && data[low] < pivot) {
                ++low
            }
            while (low < high && data[high] >= pivot) {
                --high
            }
            swap(data, low, high)
        }
        if (data[low] >= data[right]) {
            swap(data, low, right)
        } else {
            ++low
        }
        return low
    }

    private fun swap(data: IntArray, left: Int, right: Int) {
        val temp = data[left]
        data[left] = data[right]
        data[right] = temp
    }
}

fun main() {
    val data = intArrayOf(13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 39, 10)
    QuickSort().quickSort(data, 0, data.size - 1)
    for (i in data) {
        print("$i ")
    }
}