package com.example.algorithm.hastable

import com.example.algorithm.linkedlist.Node

/**
 * Given a linked list, check if the linked list has a loop (cycle) or not. The below diagram shows a linked list with a loop.
 *
 * 1 --> 2 --> 3 --> 4
 *             |     |
 *             6 <-- 5
 */
class DetectLoopInALinkedList {

    fun solution(head: Node): Boolean {
        val hashSet = hashSetOf(System.identityHashCode(head))
        var node = head

        while (node.next != null) {
            if (hashSet.contains(System.identityHashCode(node.next))) {
                return true
            }
            hashSet.add(System.identityHashCode(node))
            node = node.next!!
        }

        return false
    }
}