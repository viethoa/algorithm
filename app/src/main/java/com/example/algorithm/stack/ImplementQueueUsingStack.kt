package com.example.algorithm.stack

import java.util.*

/**
 * Easy - Implement Queue using stacks
 *
 * Implement the following operations of a queue using stacks.
 * enqueue(x) : Insert an item x to the rear of queue.
 * dequeue() : Remove an item from front of queue and return that element
 * peek() : Get the front item.
 * isEmpty() : Return whether the queue is empty.
 */
class ImplementQueueUsingStack

/**
 * The idea is Keep The First Item as Last Item of the Stack
 * => When Pop() will get the first item of the Queue
 */
class NewQueue<T> {

    private val stack: Stack<T> = Stack()
    private val tempStack: Stack<T> = Stack()

    fun enqueue(element: T) {
        // Move all item to tempStack
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop())
        }
        // Push as first item
        stack.push(element)
        // Push all item back
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop())
        }
    }

    fun dequeue(): T? {
        return when {
            stack.isEmpty() -> null
            else -> stack.pop()
        }
    }

    fun peak(): T? {
        return when {
            stack.isEmpty() -> null
            else -> stack.peek()
        }
    }

    fun isEmpty(): Boolean = stack.isEmpty()
}