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
data class NodeWithParent(
    val value: Int,
    val left: NodeWithParent? = null,
    val right: NodeWithParent? = null,
    var parent: NodeWithParent? = null
) {
    override fun toString(): String {
        return value.toString()
    }
}

class FindParentOfTwoNode {

    /**
     * Solution
     * - Set the parent for each node
     * - Find the parent of 2 require nodes, if they are not the same node then
     * get its parent and repeat finding the parent of them until they are same node.
     */
    fun solution(
        node: NodeWithParent,
        node1: NodeWithParent,
        node2: NodeWithParent
    ): NodeWithParent? {
        if (node.value == node1.value || node.value == node2.value) {
            return null
        }

        setParentNode(node, null)
        var parent1 = findNode(node, node1)?.parent
        var parent2 = findNode(node, node2)?.parent
        if (parent1 == null || parent2 == null) {
            return null
        }

        while (!sameNode(parent1!!, parent2!!)) {
            // Chane node 1 parent and compare again
            var temp = parent1.parent
            if (temp != null && sameNode(temp, parent2)) {
                return temp
            }
            // Chane node 2 parent and compare again
            temp = parent2.parent
            if (temp != null && sameNode(temp, parent1)) {
                return temp
            }
            // Higher parent level and compare again
            if (parent1.parent != null) {
                parent1 = parent1.parent
            }
            if (parent2.parent != null) {
                parent2 = parent2.parent
            }
        }

        // parent1 and parent2 should be equally at this point
        return parent1
    }

    private fun sameNode(node1: NodeWithParent, node2: NodeWithParent): Boolean {
        return node1.value == node2.value
    }

    private fun findNode(node: NodeWithParent, requireNode: NodeWithParent): NodeWithParent? {
        if (node.value == requireNode.value) {
            return node
        }
        if (node.left != null) {
            val myNode = findNode(node.left, requireNode)
            if (myNode != null) {
                return myNode
            }
        }
        if (node.right != null) {
            val myNode = findNode(node.right, requireNode)
            if (myNode != null) {
                return myNode
            }
        }
        return null
    }

    private fun setParentNode(node: NodeWithParent, parent: NodeWithParent?) {
        node.parent = parent
        if (node.left != null) {
            setParentNode(node.left, node)
        }
        if (node.right != null) {
            setParentNode(node.right, node)
        }
    }
}