package com.example.algorithm.queue

import java.util.LinkedList
import java.util.Queue

/**
 * BFS: Breadth First Search
 * - https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 *
 *          1 ---- 3
 *       /  |      |
 *     0    |      |
 *      \   |      |
 *          2 ---- 4
 */
class BFS {

    private val graph: List<List<Int>> = listOf(
        listOf(1, 2),
        listOf(3, 4),
        listOf(4)
    )

    fun displayGraph() {
        val queue: Queue<Int> = LinkedList()
        val visited = hashSetOf<Int>()
        queue.add(0)
        visited.add(0)

        while (queue.isNotEmpty()) {
            val current = queue.poll()!!
            println("$current ")

            graph[current].forEach { element ->
                if (!visited.contains(element)) {
                    visited.add(element)
                    queue.add(element)
                }
            }
        }
    }
}