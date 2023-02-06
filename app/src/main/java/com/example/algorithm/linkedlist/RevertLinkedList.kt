package com.example.algorithm.linkedlist

/**
 * Given a pointer to the head node of a linked list,
 * the task is to reverse the linked list.
 * We need to reverse the list by changing the links between nodes.
 *
 * Examples:
 * Input: Head of following linked list
 * 1->2->3->4->NULL
 * Output: Linked list should be changed to,
 * 4->3->2->1->NULL
 *
 * Input: Head of following linked list
 * 1->2->3->4->5->NULL
 * Output: Linked list should be changed to,
 * 5->4->3->2->1->NULL
 */
class RevertLinkedList {

    /**
     * Solution
     * 1. Keep Prev, Current, Next
     * 2. Every move,
     *  - Set Next to New Next
     *  - Set Current.next = prev
     * 3. Set New Head = prev
     */
    fun solution1(head: Node): Node {
        if (head.next == null) {
            return head /* Only one 1 in the list */
        }

        var prev: Node? = null
        var current: Node? = head
        var next: Node? = null
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }

        return prev!! /* after revert Prev will be New Head */
    }

    /**
     * Solution
     * 1. Get the last node as New Head
     * 2. Revert the linked-list by recursive
     * 3. Set old head.next to null
     */
    fun solution2(head: Node): Node {
        if (head.next == null) {
            return head /* Only one 1 in the list */
        }

        var newHead = head
        while (newHead.next != null) {
            newHead = newHead.next!!
        }

        revertByRecursive(head)
        head.next = null
        return newHead
    }

    private fun revertByRecursive(node: Node) {
        // Remove all the linked between nodes
        // And hold next node for revert the linking
        val nextNode = node.next
            ?: return

        revertByRecursive(nextNode)

        // Revert the linking
        nextNode.next = node
    }
}