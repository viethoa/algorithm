package com.example.algorithm.linkedlist

import java.util.LinkedList

/**
 * Given the pointer to the head node of a linked list and an integer to insert at a certain position.
 * Create a new node with the given integer as its data attribute, insert this node at the desired position
 * and return the head node.
 *
 * A position of 0 indicates head, a position of 1 indicates one node away from the head and so on.
 * The head pointer given may be null meaning that the initial list is empty.
 *
 * Example:
 * head: 1 -> 2 -> 3
 * data = 4
 * position = 2
 * => 1 -> 2 -> 4 -> 3
 */
class InsertIntoSpecificPosition {

    fun execute() {
        val input = Node(1, Node(2, Node(3)))
        var result: Node? = insertNode(input, 4, 2)
        while (result != null) {
            println("${result.value} ")
            result = result.next
        }
    }

    private data class Node(
        val value: Int,
        var next: Node? = null
    )

    private fun insertNode(head: Node?, data: Int, position: Int): Node {
        // New list
        if (head == null) {
            return Node(data)
        }
        // Insert into head
        if (position == 0) {
            return Node(data, head)
        }

        var count = 1
        var node = head
        while (count < position && node?.next != null) {
            node = node.next
            count += 1
        }

        // Insert into bottom
        if (node?.next == null) {
            node?.next = Node(data)
            return head
        }

        // Insert between 2 nodes
        val newNode = Node(data, node.next)
        node.next = newNode
        return head
    }
}