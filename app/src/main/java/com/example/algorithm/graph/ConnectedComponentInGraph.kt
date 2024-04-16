package com.example.algorithm.graph

/**
 * Given an undirected graph, the task is to print all
 * the connected components line by line.
 * - https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/
 *
 *  Example
 *  input: 0-1-2 3-4
 *  output:
 *  - 0 1 2
 *  - 3 4
 */
class ConnectedComponentInGraph {

    fun execute() {
        val graph = listOf(
            listOf(1),
            listOf(2),
            listOf(),
            listOf(4),
            listOf()
        )
        println(connectedComponentInGraph(graph))
    }

    /**
     * Dry run:
     * 1. vertex: 0, visited: [0,1,2], isConnected[0,1,2]
     * 2. vertex: 1 => skipped
     * 3. vertex: 2 => skipped
     * 4. vertex: 3 visited: [0,1,2,3,4], isConnected[3,4]
     */
    private fun connectedComponentInGraph(graph: List<List<Int>>) {
        val visited = hashSetOf<Int>()
        for (i in graph.indices) {
            val connected = arrayListOf<Int>()
            findConnected(i, graph, visited, connected)
            if (connected.isNotEmpty()) {
                println(connected)
            }
        }
    }

    /**
     * Dry run: {[1], [2], [], [4], []}
     * Begin: visited: [], connected: []
     * Step1: visited: [0,1,2], connected: [0,1,2]
     */
    private fun findConnected(
        vertex: Int,
        graph: List<List<Int>>,
        visited: HashSet<Int>,
        connected: ArrayList<Int>
    ) {
        if (visited.contains(vertex)) {
            return
        }

        visited.add(vertex)
        connected.add(vertex)
        graph[vertex].forEach { element ->
            findConnected(element, graph, visited, connected)
        }
    }
}