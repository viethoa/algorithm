package com.example.algorithm.tree

/**
 *              1
 *            /   \
 *          2      3
 *        /   \     \
 *       4     5     8
 *      /       \
 *     6         7
 *
 * Input: node 4
 * Output: 2
 *
 * Input: node 1
 * Output: null
 */
class FindParentOfNode {

    /**
     * Solution
     * - Make a recursive function that take the current node and its parent as the argument.
     * - If the current node is equal to require node, then return its parent
     */
    fun solution(
        node: BinaryTreeNode,
        requireNode: BinaryTreeNode
    ): BinaryTreeNode? {
        return findParentNode(node, requireNode, null)
    }

    private fun findParentNode(
        node: BinaryTreeNode,
        requireNode: BinaryTreeNode,
        parentNode: BinaryTreeNode?
    ): BinaryTreeNode? {
        if (node.value == requireNode.value) {
            return parentNode
        }
        if (node.left != null) {
            val parent = findParentNode(node.left, requireNode, node)
            if (parent != null) {
                return parent
            }
        }
        if (node.right != null) {
            val parent = findParentNode(node.right, requireNode, node)
            if (parent != null) {
                return parent
            }
        }
        return null
    }
}