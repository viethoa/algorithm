package com.example.algorithm.queue

import java.util.*

/**
 * You're given a list of n integers arr, which represent elements in a queue (in order from front to back).
 * You're also given an integer x, and must perform x iterations of the following 3-step process:
 * 1. Pop x elements from the front of queue (or, if it contains fewer than x elements, pop all of them),
 *  Of the elements that were popped, find the one with the largest value (if there are multiple such elements,
 *  take the one which had been popped the earliest), and remove it
 * 2. For each one of the remaining elements that were popped (in the order they had been popped),
 *  decrement its value by 1 if it's positive (otherwise, if its value is 0, then it's left unchanged),
 *  and then add it back to the queue
 * 3.Compute a list of x integers output, the i-th of
 *  which is the 1-based index in the original array of the element
 *  which had been removed in step 2 during the ith iteration.
 *
 * Example
 * n = 6, x = 5
 * arr = [1, 2, 2, 3, 4, 5]
 * output = [5, 6, 4, 1, 2]
 * Explanation
 * 1. In the first iteration, the first 5 elements are popped off the queue, leaving just [5].
 *  Of the popped elements, the largest one is the 4, which was at index 5 in the original array.
 *  The remaining elements are then decremented and added back onto the queue,
 *  whose contents are then [5, 0, 1, 1, 2].
 * 2. In the second iteration, all 5 elements are popped off the queue.
 *  The largest one is the 5, which was at index 6 in the original array.
 *  The remaining elements are then decremented (aside from the 0) and added back onto the queue,
 *  whose contents are then [0, 0, 0, 1].
 * 3. In the third iteration, all 4 elements are popped off the queue.
 *  The largest one is the 1, which had the initial value of 3 at index 4 in the original array.
 *  The remaining elements are added back onto the queue,
 *  whose contents are then [0, 0, 0].
 * 4. In the fourth iteration, all 3 elements are popped off the queue.
 *  Since they all have an equal value, we remove the one that was popped first,
 *  which had the initial value of 1 at index 1 in the original array.
 *  The remaining elements are added back onto the queue,
 *  whose contents are then [0, 0].
 * 5. In the final iteration, both elements are popped off the queue.
 *  We remove the one that was popped first,
 *  which had the initial value of 2 at index 2 in the original array.
 */

data class Element(
    val value: Int,
    val index: Int
) {
    fun decrease(): Element {
        var newValue = value - 1
        if (newValue < 0) {
            newValue = 0
        }
        return Element(newValue, index)
    }
}

class QueueRemoval {

    /**
     * Solution
     * 1. Store original index and value
     * 2. Do the 3 steps with x times
     * 3. Return the list of original index
     */
    fun execute(input: Queue<Int>, x: Int): List<Int> {
        if (input.isEmpty() || x <= 0) {
            return emptyList()
        }

        // Hold original index
        val queue = LinkedList<Element>()
        input.forEachIndexed { index, e -> queue.add(Element(e, index + 1)) }

        // Doing the 3 steps
        val result = arrayListOf<Int>()
        for (i in 1..x) {
            result.addAll(performRemove(queue, x))
        }

        return result
    }

    private fun performRemove(queue: LinkedList<Element>, x: Int): List<Int> {
        if (queue.isEmpty() || x <= 0) {
            return emptyList()
        }

        var max = Element(Int.MIN_VALUE, -1)
        val popList = arrayListOf<Element>()

        // find max element
        for (i in 1..x) {
            if (queue.isEmpty()) {
                break
            }
            val element = queue.pop()
            popList.add(element)
            if (element.value > max.value) {
                max = element
            }
        }

        // Put element back to queue
        popList.forEach { element ->
            if (element != max) {
                queue.add(element.decrease())
            }
        }

        return listOf(max.index)
    }
}