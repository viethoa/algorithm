package com.example.algorithm

/**
 * Given a matrix of 0 and 1, where 0 represents water and 1 represent land.
 * Two pieces of land are connected if they are touching each other(vertical, horizontal or diagonal)
 * Please write a method that counts the number of islands.
 *
 * Example: out put is 3
 *  0 1 1 0 0 0 1
 *  0 1 0 0 1 1 0
 *  0 1 1 0 0 1 0
 *  0 0 0 0 0 0 0
 *  0 1 1 1 1 1 0
 *
 * Example 2: out put is 4
 *  1 1 0 0 0
 *  0 1 0 0 1
 *  0 0 0 0 0
 *  0 0 0 0 0
 *  1 0 1 1 0
 */
class CountIsland {

    /**
     * Solution
     * 1. Loop through the matrix till meet 1
     * 2. Find the size of island by move vertical, horizontal and diagonal till meet 0
     * 3. Turn the matrix value to 0 to mark as counted
     */
    fun execute(matrix: ArrayList<ArrayList<Int>>): Int {
        if (matrix.isEmpty()) {
            return 0
        }

        var count = 0
        matrix.forEachIndexed { i, verticalList ->
            verticalList.forEachIndexed { j, value ->
                if (value == 1) {
                    count += 1
                    martIslandAsCounted(matrix, i, j)
                }
            }
        }

        return count
    }

    private fun martIslandAsCounted(matrix: ArrayList<ArrayList<Int>>, i: Int, j: Int) {
        if (i < 0 || i >= matrix.size || j < 0 || j >= matrix[i].size) {
            return
        }
        if (matrix[i][j] == 0) {
            return
        }
        matrix[i][j] = 0
        martIslandAsCounted(matrix, i, j + 1)
        martIslandAsCounted(matrix, i + 1, j + 1)
        martIslandAsCounted(matrix, i + 1, j)
        martIslandAsCounted(matrix, i, j - 1)
        martIslandAsCounted(matrix, i - 1, j)
        martIslandAsCounted(matrix, i - 1, j - 1)
        martIslandAsCounted(matrix, i + 1, j - 1)
        martIslandAsCounted(matrix, i - 1, j + 1)
    }
}