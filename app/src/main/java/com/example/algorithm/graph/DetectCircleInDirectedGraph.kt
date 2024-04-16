package com.example.algorithm.graph

/**
 * Given the root of a Directed graph, The task is to check whether the graph contains a cycle or not.
 *  - https://www.geeksforgeeks.org/detect-cycle-in-a-graph
 *
 *  [0,     1,    2,    3]
 *   |      |     |     |
 *  [1,2]  [2]  [0,3]  [3]
 *  => Cycle: 0 -> 2 -> 0
 *
 *  0 -> 1 -> 2 -> 3
 *  |
 *  2
 *  => No Cycle
 */
class Graph {

    fun execute() {
        var graph = listOf(
            listOf(1, 2),
            listOf(2),
            listOf(0, 3),
            listOf(3)
        )
        println("Detect Circle In Directed Graph ${isCircle(graph)}")

        graph = listOf(
            listOf(1, 2),
            listOf(2),
            listOf(3),
            listOf()
        )
        println("Detect Circle In Directed Graph ${isCircle(graph)}")
    }

    /**
     * The solution is using DFS (Depth First Traversal) technique.
     * It is based on the idea that there is a cycle in a graph only if there is a Back-Edge
     * (a node points to one of its ancestors) present in the graph.
     *
     * To detect a Back-Edge, we need to keep track of the nodes visited till now
     * and the nodes that are in the current recursion stack (the current path that we are visiting).
     * If during recursion, we reach a node that is already in the recursion stack,
     * there is a cycle present in the graph.
     */
    private fun isCircle(graph: List<List<Int>>): Boolean {
        val visited = hashSetOf<Int>()
        val recursionStack = hashSetOf<Int>()
        for (i in graph.indices) {
            if (isCircle(i, graph, visited, recursionStack)) {
                return true
            }
        }

        return false
    }

    private fun isCircle(
        vertex: Int,
        graph: List<List<Int>>,
        visitedNodes: HashSet<Int>,
        recursionStack: HashSet<Int>
    ): Boolean {
        // It contains a circle graph
        if (recursionStack.contains(vertex)) {
            return true
        }
        if (visitedNodes.contains(vertex)) {
            return false
        }

        visitedNodes.add(vertex)
        recursionStack.add(vertex)
        graph[vertex]
            .forEach {
                if (isCircle(it, graph, visitedNodes, recursionStack)) {
                    return true
                }
            }

        recursionStack.remove(vertex)
        return false
    }
}