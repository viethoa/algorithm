package com.example.algorithm.linkedlist

/**
 * Given a linked list and an integer N,
 * the task is to delete the n-th node from the end of the given linked list.
 *
 * Examples:
 * Input: 2 -> 3 -> 1 -> 7 -> Null, N = 1
 * Output: 2 -> 3 -> 1 -> Null
 *
 * Input: 2 -> 3 -> 1 -> 7 -> Null, N = 2
 * Output: 2 -> 3 -> 7 -> Null
 *
 * Input: 1 -> 2 -> 3 -> 4 -> Null, N = 4
 * Output: 2 -> 3 -> 4
 */
class RemoveNthNodeFromTheEnd {

    /**
     * Solution
     * 1. Find n-th node with [First, Second]
     * 2. Move Second n-th times
     * 3. First = head, Second = n-th node from begin
     * 4. Move Second the end together with First
     * 5. First-Node now is n-th node from the end, second is last node
     * 6. Now can just remove First node
     *
     * Question
     * - If the length of linked-list is 4, but n = 5.
     * - What should we do?
     */
    fun execute(head: Node, n: Int): Node? {
        if (n <= 0) {
            return head
        }

        var count = n
        var first: Node? = head
        var second: Node? = head
        var prevOfFirst: Node? = null
        // Move second-node to n-th node from head
        // Or move to the end (last node)
        while (second?.next != null && count > 1) {
            second = second.next
            count -= 1
        }
        // Move second-node & first-node together to the end
        while (second?.next != null) {
            prevOfFirst = first
            first = first?.next
            second = second.next
        }

        // Remove head
        if (first == head) {
            return removeHead(head)
        }
        // Remove n-th node
        prevOfFirst?.next = first?.next
        return head
    }

    private fun removeHead(head: Node): Node? {
        if (head.next == null) {
            return null
        }
        val newHead = head.next
        head.next = null
        return newHead
    }
}