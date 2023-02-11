package com.example.algorithm.tree

/**
 * Given a Binary Search Tree (BST) of integer values and a range [low, high],
 * return the count of nodes where all the nodes under that node
 * (or subtree rooted with that node) lie in the given range.
 *
 * @note Binary Search Tree is a sorted binary tree
 * @link https://www.geeksforgeeks.org/count-bst-subtrees-that-lie-in-given-range
 *
 * Example:
 *       10
 *     /   \
 *    5    50
 *   /    /  \
 *  1   40   100
 *
 *  Range: [5, 45]
 *  Output: 1, There is only 1 node whose subtree is in the given range. The node is 40
 *
 *  Example 2 (same input)
 *  Range: [1, 45]
 *  Output: 3, there are three nodes whose subtree is in the given range. The nodes are 1, 5 and 40
 */
class CountBSTSubtreeNode {

    /**
     * Solution
     * 1. Loop to the end of left node to get the lowest number
     * 2. Loop to the end of right node to get the highest number
     * 3. Compare the lowest and highest with the rank
     *
     * Time Complexity: O(n)
     * Auxiliary space: O(n)
     */
    fun execute(node: BinaryTreeNode, rank: Pair<Int, Int>): Pair<Int, List<Int>> {
        if (node.left == null && node.right == null) {
            return checkSingleNodeByRank(node, rank)
        }

        val (count, subNodes, _) = countSubNode(node, rank)
        return Pair(count, subNodes)
    }

    private fun countSubNode(node: BinaryTreeNode?, rank: Pair<Int, Int>): Triple<Int, List<Int>, List<Int>> {
        if (node == null) {
            return Triple(0, emptyList(), emptyList())
        }

        // Count sub-node for left node
        val (leftCount, leftSubNodes, leftNodes) = countSubNode(node.left, rank)
        // Count sub-node for right node
        val (rightCount, rightSubNodes, rightNodes) = countSubNode(node.right, rank)

        // Count sub-node for the root
        val currentCount = leftCount + rightCount
        val currentSubNodes = arrayListOf<Int>()
        currentSubNodes.addAll(leftSubNodes)
        currentSubNodes.addAll(rightSubNodes)
        return  checkRootedNodeByRank(node, leftNodes, rightNodes, currentSubNodes, currentCount, rank)
    }

    private fun checkRootedNodeByRank(
        root: BinaryTreeNode,
        leftNodes: List<Int>,
        rightNodes: List<Int>,
        currentSubNodes: List<Int>,
        currentCount: Int,
        rank: Pair<Int, Int>
    ): Triple<Int, List<Int>, List<Int>> {
        val nodeList = arrayListOf<Int>()
        nodeList.addAll(leftNodes)
        nodeList.addAll(rightNodes)
        nodeList.add(root.value)
        nodeList.forEach { value ->
            if (value < rank.first || value > rank.second) {
                return Triple(currentCount, currentSubNodes, nodeList)
            }
        }
        return Triple(currentCount + 1, nodeList, nodeList)
    }

    private fun checkSingleNodeByRank(node: BinaryTreeNode, rank: Pair<Int, Int>): Pair<Int, List<Int>> {
        var count = 0
        val list = arrayListOf<Int>()
        if (node.value >= rank.first && node.value <= rank.second) {
            count += 1
            list.add(node.value)
        }
        return Pair(count, list)
    }
}