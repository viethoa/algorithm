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
     * 1) Create an empty stack S.
     * 2) Initialize current node as root
     * 3) Push the current node to S and set current = current->left until current is NULL
     * 4) If current is NULL and stack is not empty then
     *  a) Pop the top item from stack.
     *  b) Print the popped item, set current = popped_item->right
     *  c) Go to step 3.
     * 5) If current is NULL and stack is empty then we are done.
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