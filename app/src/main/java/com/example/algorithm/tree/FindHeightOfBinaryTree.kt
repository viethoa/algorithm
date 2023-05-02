package com.example.algorithm.tree

/**
 * Find height of a binary tree
 *            5
 *           / \
 *          3   6
 *         / \
 *        2   4
 *       /
 *      1
 */
data class BinaryTreeNode(
    val value: Int,
    val left: BinaryTreeNode? = null,
    val right: BinaryTreeNode? = null
)

class FindHeightOfBinaryTree {

    /**
     * Solution
     * 1. Using recursive to look all Left & Right Node
     * 2. Increase height ech time look through a level
     * 3. Return the largest height
     */
    fun execute(node: BinaryTreeNode): Int {
        return findBinaryTreeHeight(node, 1)
    }

    private fun findBinaryTreeHeight(node: BinaryTreeNode, level: Int): Int {
        if (node.left == null && node.right == null) {
            return level
        }

        var leftLevel = level
        if (node.left != null) {
            leftLevel = findBinaryTreeHeight(node.left, level + 1)
        }
        var rightLevel = level
        if (node.right != null) {
            rightLevel = findBinaryTreeHeight(node.right, level + 1)
        }

        return leftLevel.coerceAtLeast(rightLevel)
    }

}