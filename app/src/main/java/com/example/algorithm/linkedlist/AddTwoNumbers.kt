package com.example.algorithm.linkedlist

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 * Input: [2 -> 4 -> 3] & [5 -> 6 -> 4]
 * Output: 7 -> 0 -> 8
 * Explain: 342 + 465 = 807 => output: 7 -> 0 -> 8
 *
 * Input: [0] & [0]
 * Output: [0]
 *
 * Input: [9,9,9,9,9,9,9] & [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
class AddTwoNumbers {

    fun execute() {
        val first = Node(9, Node(9, Node(9, Node(9, Node(9, Node(9, Node(9)))))))
        val second = Node(9, Node(9, Node(9, Node(9))))
        var newNode: Node? = addTwoNumber(first, second)
        var result = ""
        while (newNode != null) {
            result += "${newNode.value} "
            newNode = newNode.next
        }

        println(result)
    }

    private fun addTwoNumber(first: Node, second: Node): Node {
        val sum = first.value + second.value
        val newHead = Node(sum % 10)

        var temp = sum / 10
        var node: Node? = newHead
        var fNext: Node? = first
        var sNext: Node? = second
        while(true) {
            fNext = fNext?.next
            sNext = sNext?.next
            if (sNext == null && fNext == null) {
                break
            }

            val sumWithTemp = temp + (fNext?.value ?: 0) + (sNext?.value ?: 0)
            temp = sumWithTemp / 10

            node?.next = Node(sumWithTemp % 10)
            node = node?.next
        }

        if (temp > 0) {
            node?.next = Node(temp)
        }

        return newHead
    }
}