package com.example.algorithm.tree

import java.util.Stack

/**
 * Travel a tree without recursive
 *              1
 *            /   \
 *          2      3
 *        /   \     \
 *       4     5     8
 *      /       \
 *     6         7
 */
class TreeTraversalInIterative {

    /**
     * Using Stack
     */
    fun solution(node: BinaryTreeNode) {
        var current: BinaryTreeNode? = node
        val stack = Stack<BinaryTreeNode>()
        while (current != null || stack.isNotEmpty()) {
            // Reach the left most Node of the current Node
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            // Current must be null at this point
            current = stack.pop()
            println(current.value)
            // We have visited the node and its left subtree.
            // Now it's right subtree turn
            current = current.right
        }
    }
}