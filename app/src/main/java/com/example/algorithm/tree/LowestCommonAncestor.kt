package com.example.algorithm.tree

/**
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */
class LowestCommonAncestor {

    /**
     * Same solution with Find-Parent-Of-Two-Node
     */
    fun solution(
        node: BinaryTreeNode,
        node1: BinaryTreeNode,
        node2: BinaryTreeNode
    ): BinaryTreeNode? {
        return FindParentOfTwoNode().solution(node, node1, node2)
    }
}