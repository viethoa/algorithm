package com.example.algorithm.tree

/**
 * Input:
 *              1
 *            /   \
 *          2      3
 *        /   \     \
 *       4     5     8
 *      /       \
 *     6         7
 *
 * Output:  3
 * Explanation: For the above tree,
 * width of level 1 is 1,
 * width of level 2 is 2,
 * width of level 3 is 3
 * width of level 4 is 2.
 * So the maximum width of the tree is 3.
 */

class FindBinaryTreeWidth {

    /**
     * Solution: O(n), O(k) space complexity which K is height of tree
     * 1. Count node of each level
     * 2. Find the max number of node of a level
     */
    fun solution(node: BinaryTreeNode): Int {
        val nodesCount = hashMapOf<Int, Int>()
        addingLevelForEachNodes(node, 1, nodesCount)

        var nodeWidth = Integer.MIN_VALUE
        nodesCount.forEach {
            if (it.value > nodeWidth) {
                nodeWidth = it.value
            }
        }

        return nodeWidth
    }

    private fun addingLevelForEachNodes(
        node: BinaryTreeNode?,
        level: Int,
        nodesCount: HashMap<Int, Int>
    ) {
        if (node == null) {
            return
        }

        addingLevelForEachNodes(node.left, level + 1, nodesCount)
        addingLevelForEachNodes(node.right, level + 1, nodesCount)
        if (nodesCount.contains(level)) {
            nodesCount[level] = nodesCount[level]!! + 1
        } else {
            nodesCount[level] = 1
        }
    }
}