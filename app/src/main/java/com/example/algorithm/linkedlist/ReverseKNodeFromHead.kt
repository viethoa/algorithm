package com.example.algorithm.linkedlist

/**
 *  Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 *  K is equal or less than the size of linked list
 *
 *  Example
 *  Given this linked list: 1->2->3->4->5
 *  For k = 2, you should return: 2->1->3->4->5
 *  For k = 3, you should return: 3->2->1->4->5
 */

/**
 * Solution
 * 1. Revert till K nodes
 * 2. Set head.next to next node of K
 * 3. K node will be the new head
 */
class ReverseKNodeFromHead {

    /**
     * Dry run
     * Begin
     * - Next = null
     * - Prev = null
     * - Current = 1 (head)
     *
     * Step 1
     * - Next = 2
     * - 1.next = null: 1 -> null
     * - Pre = 1
     * - Curr = 2
     *
     * Step 2
     * - Next = 3
     * - 2.next = 1: 2 -> 1 -> null
     * - Pre = 2
     * - Curr = 3
     *
     * Final
     * - 2 -> 1 -> 3
     * - Return 2 as new head
     */
    fun execute(head: Node, k: Int): Node? {
        if (k <= 1) {
            return head
        }

        // 1 -> 2 -> 3
        // null <- 1
        var previous: Node? = null
        var current: Node? = head
        for (i in 1..k) {
            val next = current?.next
            current?.next = previous
            previous = current
            current = next
        }

        head.next = current
        return previous
    }
}