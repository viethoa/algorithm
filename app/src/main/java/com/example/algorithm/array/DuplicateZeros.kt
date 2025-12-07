package com.example.algorithm.array

/**
 * Given a fixed-length integer array arr, duplicate each occurrence of zero,
 * shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 *
 * Example 1:
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 */
class DuplicateZeros {

    fun duplicateZeros(arr: IntArray): Unit {
        val temp = arrayListOf<Int>()
        for (i in arr.indices) {
            if (arr[i] == 0) {
                temp.add(0)
                temp.add(0)
            } else {
                temp.add(arr[i])
            }
        }

        for (i in arr.indices) {
            arr[i] = temp[i]
        }
    }
}