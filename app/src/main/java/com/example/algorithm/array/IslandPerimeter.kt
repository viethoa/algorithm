package com.example.algorithm.array

/**
 * [Easy] https://leetcode.com/problems/island-perimeter/description/
 */
class IslandPerimeter {

    private fun islandPerimeter(grid: Array<IntArray>): Int {
        var perimeter = 0

        for (i in grid.indices) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == 1) {
                    perimeter += (4 - numberOfNeighbors(grid, i, j))
                }
            }
        }

        return perimeter
    }

    private fun numberOfNeighbors(grid: Array<IntArray>, i: Int, j: Int): Int {
        var count = 0
        val n = grid.size
        val m = grid[0].size
        // Top
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            count += 1
        }
        // Right
        if (i + 1 < n && grid[i + 1][j] == 1) {
            count += 1
        }
        // Bottom
        if (j + 1 < m && grid[i][j + 1] == 1) {
            count += 1
        }
        // Left
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            count += 1
        }

        return count
    }
}