package com.example.algorithm.matrix

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Link: https://leetcode.com/problems/rotate-image/description/
 *
 * Example
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
class RotateImage {

    fun execute() {
        val input = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        rotate(input)
        displayMatrix(input)
    }

    /**
     * Time Complexity: O(n*m)
     * Space Complexity: O(1)
     *
     * 1 2 3   =>  1 4 7  =>  7 4 1
     * 4 5 6       2 5 8      8 5 2
     * 7 8 9       3 6 9      9 6 3
     */
    private fun rotate(image: Array<IntArray>) {
        val n = image.size
        // Transpose the image
        for (i in 0 until n) {
            for (j in i until n) {
                val temp = image[i][j]
                image[i][j] = image[j][i]
                image[j][i] = temp
            }
        }
        // Reverse each row
        for (row in image) {
            row.reverse()
        }
    }

    private fun displayMatrix(matrix: Array<IntArray>) {
        val n = matrix.size
        val m = matrix[0].size
        for (i in 0 until n) {
            var string = ""
            for (j in 0 until m) {
                string += "${matrix[i][j]} "
            }
            println("$string \n")
        }
    }
}