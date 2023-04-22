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
 * Input: node 4, node 5
 * Output: 2
 *
 * Input: node 1, node 1
 * Output: null
 *
 * Input: node 4, node 3
 * Output: 1
 *
 * Input: node 5, node 7
 * Output: 2
 *
 * Input: node 4, node 5
 * Output: 2
 *
 * Input: node 5, node 8
 * Output: 1
 *
 * Input: node 6, node 6
 * Output: 4
 */

class FindParentOfTwoNode {

    /**
     * Solution
     * - Set the parent for each node
     * - Find the parent of 2 require nodes, if they are not the same node then
     * get its parent and repeat finding the parent of them until they are same node.
     */
    fun solution(
        node: BinaryTreeNode,
        node1: BinaryTreeNode,
        node2: BinaryTreeNode
    ): BinaryTreeNode? {
        if (node.value == node1.value || node.value == node2.value) {
            return null
        }

        var parent1 = findParentNode(node, node1, null)
        var parent2 = findParentNode(node, node2, null)
        if (parent1 == null || parent2 == null) {
            return null
        }

        while (!sameNode(parent1!!, parent2!!)) {
            // Chane node 1 parent and compare again
            val temp1 = findParentNode(node, parent1, null)
            if (temp1 != null && sameNode(temp1, parent2)) {
                return temp1
            }
            // Chane node 2 parent and compare again
            val temp2 = findParentNode(node, parent2, null)
            if (temp2 != null && sameNode(temp2, parent1)) {
                return temp2
            }
            // Higher parent level and compare again
            if (temp1 != null) {
                parent1 = temp1
            }
            if (temp2 != null) {
                parent2 = temp2
            }
        }

        // parent1 and parent2 should be equally at this point
        return parent1
    }

    private fun sameNode(node1: BinaryTreeNode, node2: BinaryTreeNode): Boolean {
        return node1.value == node2.value
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