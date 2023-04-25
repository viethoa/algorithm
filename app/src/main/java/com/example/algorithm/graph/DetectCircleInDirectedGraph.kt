package com.example.algorithm

/**
 * Given the root of a Directed graph, The task is to check whether the graph contains a cycle or not.
 *  - https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */
data class GraphNode(
    val value: Int,
    val linkedNodes: List<GraphNode>?
)

class DetectCircleInDirectedGraph {

    /**
     * Solution
     * 1. Travel all the adjacency and mark them as visited
     *  - Do not travel the node has been marked as visited to avoid infinity loop
     */
    fun solution(node: GraphNode): Boolean {
        return isCircleDirectedGraph(node, hashSetOf(), hashSetOf())
    }

    private fun isCircleDirectedGraph(
        node: GraphNode,
        visitedNodes: HashSet<Int>,
        stackChase: HashSet<Int>
    ): Boolean {
        // It contains a circle graph
        if (stackChase.contains(node.value)) {
            return true
        }
        if (visitedNodes.contains(node.value)) {
            return false
        }

        visitedNodes.add(node.value)
        stackChase.add(node.value)
        node.linkedNodes?.forEach {
            if (isCircleDirectedGraph(it, visitedNodes, stackChase)) {
                return true
            }
        }

        stackChase.remove(node.value)
        return false
    }
}