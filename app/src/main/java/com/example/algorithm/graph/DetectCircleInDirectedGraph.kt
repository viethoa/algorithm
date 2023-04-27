package com.example.algorithm.graph

/**
 * Given the root of a Directed graph, The task is to check whether the graph contains a cycle or not.
 *  - https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */
class Graph(private val v: Int) {

    private val adjacentVertex: MutableList<MutableList<Int>> = mutableListOf()

    init {
        for (i in 0 until v) {
            adjacentVertex.add(mutableListOf())
        }
    }

    fun addEdge(source: Int, dest: Int) {
        if (source < 0 || source >= adjacentVertex.size) {
            return
        }
        adjacentVertex[source].add(dest)
    }

    /**
     * Check whether Graph has circle direction
     * 1. Travel all adjacency vertexes (mark them as visited to avoid duplicated traveling)
     *  - Do not travel the node has been marked as visited
     *    + Example: 1 links to 2 & 3, and 2 also link to 3. So we should travel 3 once
     *      - 1 -> 2
     *      - 1 -> 3
     *      - 2 -> 3
     *      - 3 -> 4
     * 2. Store the vertex which has been traveled, if meet the same vertex => it is a circle graph
     *  - Remove the vertex when meet last vertex (have no adjacency)
     */
    fun isCircle(): Boolean {
        val visited = hashSetOf<Int>()
        val stackChase = hashSetOf<Int>()
        for (i in 0 until v) {
            if (isCircle(i, visited, stackChase)) {
                return true
            }
        }

        return false
    }

    private fun isCircle(
        vertex: Int,
        visitedNodes: HashSet<Int>,
        stackChase: HashSet<Int>
    ): Boolean {
        // It contains a circle graph
        if (stackChase.contains(vertex)) {
            return true
        }
        if (visitedNodes.contains(vertex)) {
            return false
        }

        visitedNodes.add(vertex)
        stackChase.add(vertex)
        adjacentVertex[vertex]
            .forEach {
                if (isCircle(it, visitedNodes, stackChase)) {
                    return true
                }
            }

        stackChase.remove(vertex)
        return false
    }
}