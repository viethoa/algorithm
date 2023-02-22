package com.example.algorithm.queue

import java.util.Queue

/**
 * Queue (FIFO)
 * Given an integer k and a queue of integers, The task is to reverse the order of the first k elements of the queue,
 * leaving the other elements in the same relative order.
 *
 * Only following standard operations are allowed on queue.
 * enqueue(x) : Add an item x to rear of queue
 * dequeue() : Remove an item from front of queue
 * size() : Returns number of elements in queue.
 * front() : Finds front item.
 *
 * Example
 * k = 5
 * Input: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Output: [5, 4, 3, 2, 1, 6, 7, 8, 9, 10]
 */
class ReverseKElementOfQueue {

    /**
     * Solution
     * 1. Using recursive to revert k element, but added into rear
     * 2. Loop N = Size - K times to dequeue & enqueue n elements from the Front to the rear
     * 3. Now we got the reverted K elements move the front, and N elements move back to the rear
     */
    fun execute(input: Queue<Int>, k: Int) {
        if (k <= 0) {
            return
        }
        // Question to interviewer
        var finalK = k
        if (k > input.size) {
            finalK = input.size
        }

        revertKElement(input, finalK)
        val n = input.size - finalK
        for (i in 1..n) {
            val element = input.poll()
            input.add(element)
        }
    }

    private fun revertKElement(input: Queue<Int>, k: Int) {
        if (k == 0) {
            return
        }
        // Hold K elements
        val element = input.poll()
        revertKElement(input, k - 1)

        // Add K elements to queue
        // It will be reverted
        input.add(element)
    }
}