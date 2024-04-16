package com.example.algorithm.linkedlist

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * Input: 1 -> 2 -> 3 -> 4 -> 5, left = 2, right = 4
 * Output: 1 -> 4 -> 3 -> 2 -> 5
 *
 * Input: [5], left = 1, right = 1
 * Output: [5]
 */
class RevertLinkedListII {

    fun execute() {
        val head = Node(1, Node(2, Node(3, Node(4, Node(5)))))
        var node: Node? = revertLinkedList(head, 2, 4)
        var result = ""
        while (node != null) {
            result += "${node.value} "
            node = node.next
        }

        println(result)
    }

    private fun revertLinkedList(head: Node, left: Int, right: Int): Node {
        // Move to the left position
        var prevLeft: Node? = null
        var node: Node? = head
        while (node != null && node.value != left) {
            prevLeft = node
            node = node.next
        }

        val leftRevertedNode = revertLinkedList(node!!, right)

        // Left Node is Head Node
        if (prevLeft == null) {
            return leftRevertedNode
        }

        prevLeft.next = leftRevertedNode
        return head
    }

    private fun revertLinkedList(head: Node, right: Int): Node {
        var prev: Node? = null
        var node: Node? = head

        // Revert until Right Node
        while (node != null && node.value != right) {
            val temp = node.next
            if (prev != null) {
                node.next = prev
            }
            prev = node
            node = temp
        }

        val next = node?.next
        if (prev != null) {
            node?.next = prev
        }

        // Point old head to new Node which is next of right Node
        head.next = next

        return node!!
    }
}


