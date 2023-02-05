package com.example.algorithm.linkedlist

/**
 * Given pointers to the heads of two sorted linked lists, merge them into a single, sorted linked list.
 * Either head pointer may be null meaning that the corresponding list is empty.
 *
 * Example 1
 * head A: refers to 1 -> 3 -> 7 -> NULL
 * head B: refers to 1 -> 2 -> NULL
 * The new list is 1 -> 1 -> 2 -> 3 -> 7 -> NULL
 *
 * Example 2
 * head A: refers to 5 -> 10 -> 15 -> NULL
 * head B: refers to 2 -> 3 -> 20 -> NULL
 * The new list is 2 -> 3 -> 5 -> 10 -> 15 -> 20 ->NULL
 */
data class Node(
    val value: Int,
    var next: Node? = null
)

class MergeTwoSortedLinkedList {

    /**
     * Solution: Insert each node of Node-A into Node-B
     * 1. Node-element can be added as new head
     * - Reset head to new head
     * 2. Node-element can be added in end of linked list
     * 3. Node-element can be added in the middle of linked list
     */
    fun execute(headA: Node?, headB: Node?): Node? {
        var nodeA: Node? = headA ?: return headB
        var nodeB: Node? = headB ?: return headA

        var headOfResult = headB
        while (nodeA != null) {
            // Find position to insert nodeA into Linked-List B
            // Or until end of list
            while (nodeB?.next != null && nodeA.value >= nodeB.value) {
                val next = nodeB.next!!
                when {
                    nodeA.value >= next.value -> {
                        nodeB = nodeB.next
                    }
                    else -> break
                }
            }
            when {
                // Add as new head
                nodeB == headOfResult && nodeB?.value!! > nodeA.value -> {
                    headOfResult = addHead(nodeB, Node(nodeA.value))
                }
                // Add in front of node
                nodeB?.value!! > nodeA.value -> {
                    addNode(nodeB, Node(nodeA.value))
                }
                // Add behind of node
                else -> {
                    addNode(nodeB, Node(nodeA.value))
                }
            }

            nodeA = nodeA.next
            nodeB = headOfResult
        }

        return headOfResult
    }

    private fun addNode(head: Node, node: Node) {
        val next = head.next
        head.next = node
        node.next = next
    }

    private fun addHead(head: Node, node: Node): Node {
        node.next = head
        return node
    }
}