package com.example.algorithm.hastable

import com.example.algorithm.linkedlist.Node

/**
 * Given a linked list, check if the linked list has a loop (cycle) or not.
 * The below diagram shows a linked list with a loop.
 *
 * 1 --> 2 --> 3 --> 4
 *             |     |
 *             6 <-- 5
 *
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
class DetectLoopInALinkedList {

    fun solution(head: Node): Boolean {
        val hashSet = hashSetOf<Int>()
        var node: Node? = head

        while (node != null) {
            if (hashSet.contains(System.identityHashCode(node))) {
                return true
            }

            hashSet.add(System.identityHashCode(node))
            node = node.next
        }

        return false
    }
}