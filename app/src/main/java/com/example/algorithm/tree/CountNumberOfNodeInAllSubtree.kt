package com.example.algorithm.tree

/**
 * Given a tree in the form of adjacency list we have to calculate the number of nodes
 * in the subtree of each node while calculating the number of nodes
 * in the subtree of a particular node that node will also be added
 * as a node in subtree hence the number of nodes in subtree of leaves is 1.
 */

/**
 * Adjacency list of graph
 */
data class AdjNode(
    val vertices: Int,
    val adjacency: List<Int>? = null
)

class CountNumberOfNodeInAllSubtree {

    fun execute(node: List<AdjNode>) {

    }
}