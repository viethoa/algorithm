package com.example.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithm.array.CountAllPalindromeSubString
import com.example.algorithm.array.CountSubArray
import com.example.algorithm.array.KthLargestElementInArray
import com.example.algorithm.array.MinAbsoluteSumPair
import com.example.algorithm.array.MinimumAbsoluteDifference
import com.example.algorithm.array.SwapToHaveLargestNumber
import com.example.algorithm.hastable.LongestConsecutiveSequence
import com.example.algorithm.hastable.PairWithGivenSum
import com.example.algorithm.hastable.SumThreeNumberEqualToZero
import com.example.algorithm.hastable.UniqueCharacterInString
import com.example.algorithm.hastable.ValidAnagram
import com.example.algorithm.linkedlist.*
import com.example.algorithm.queue.QueueRemoval
import com.example.algorithm.queue.ReverseKElementOfQueue
import com.example.algorithm.stack.CheckBalanceOfParenthesis
import com.example.algorithm.stack.ReverseStackUsingRecursion
import com.example.algorithm.stack.SortAStackUsingAnotherStack
import com.example.algorithm.tree.BinaryTreeNode
import com.example.algorithm.tree.CountBSTSubtreeNode
import com.example.algorithm.tree.FindBinaryTreeWidth
import com.example.algorithm.tree.FindHeightOfBinaryTree
import com.example.algorithm.tree.FindParentOfNode
import com.example.algorithm.tree.FindParentOfTwoNode
import com.example.algorithm.tree.NodeWithParent
import java.util.*

class MainActivity : AppCompatActivity() {

    /**
     * Array algorithm
     */
    private val minAbsoluteSumPair by lazy { MinAbsoluteSumPair() }
    private val uniqueCharacterInString by lazy { UniqueCharacterInString() }
    private val countSubArray by lazy { CountSubArray() }
    private val minimumAbsoluteDifference by lazy { MinimumAbsoluteDifference() }
    private val reverseStack by lazy { ReverseStackUsingRecursion() }
    private val sortStackUsingAnotherStack by lazy { SortAStackUsingAnotherStack() }
    private val checkBalanceOfParenthesis by lazy { CheckBalanceOfParenthesis() }
    private val pairWithGivenSum by lazy { PairWithGivenSum() }
    private val validAnagram by lazy { ValidAnagram() }
    private val longestConsecutiveSequence by lazy { LongestConsecutiveSequence() }
    private val mergeSortedLinkedList by lazy { MergeTwoSortedLinkedList() }
    private val reverseLinkedList by lazy { ReverseLinkedList() }
    private val removeNthNodeFromTheEnd by lazy { RemoveNthNodeFromTheEnd() }
    private val reverseKElementOfQueue by lazy { ReverseKElementOfQueue() }
    private val queueRemoval by lazy { QueueRemoval() }
    private val findHeightOfBinaryTree by lazy { FindHeightOfBinaryTree() }
    private val countBSTSubtreeNode by lazy { CountBSTSubtreeNode() }
    private val countIsland by lazy { CountIsland() }
    private val reverseKNodeFromHead by lazy { ReverseKNodeFromHead() }
    private val swapToHaveLargestNumber by lazy { SwapToHaveLargestNumber() }
    private val sumThreeNumberEqualToZero by lazy { SumThreeNumberEqualToZero() }
    private val kthLargestElementInArray by lazy { KthLargestElementInArray() }
    private val findBinaryTreeWidth by lazy { FindBinaryTreeWidth() }
    private val countAllPalindromeSubString by lazy { CountAllPalindromeSubString() }
    private val findParentOfNode by lazy { FindParentOfNode() }
    private val findParentOfTwoNode by lazy { FindParentOfTwoNode() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testFindParentOfTwoNode()
        //testFindParentOfNode()
        //testCountAllPalindromeSubString()
        //testFindBinaryTreeWidth()
        //testKthLargestElementInArray()
        //testSumThreeNumberEqualToZero()
        //testSwapToHaveLargestNumber()
        //testReverseKNodeFromHead()
        //testCountIsland()
        //testCountBSTSubtreeNode()
        //testFindHeightOfBinaryTree()
        //testQueueRemoval()
        //testReverseKElementOfQueue()
        //testRemoveNthNodeFromTheEnd()
        //testReverseLinkedList()
        //testMergeSortedLinkedList()
        //testLongestConsecutiveSequence()
        //testValidAnagram()
        //testPairWithGivenSum()
        //testCheckBalanceOfParenthesis()
        //testSortStartUsingAnotherStack()
        //testReverseStack()
        //testMinimumAbsoluteDifference()
        //testCountSubArray()
        //testUniqueCharacterInString()
        //testMinAbsSumPair()
    }

    private fun testFindParentOfTwoNode() {
        val head = NodeWithParent(
            1,
            NodeWithParent(
                2,
                NodeWithParent(4, left = NodeWithParent(6)),
                NodeWithParent(5, right = NodeWithParent(7))
            ),
            NodeWithParent(3, right = NodeWithParent(8))
        )
        println(findParentOfTwoNode.solution(head, NodeWithParent(4), NodeWithParent(5)))
        println(findParentOfTwoNode.solution(head, NodeWithParent(1), NodeWithParent(1)))
        println(findParentOfTwoNode.solution(head, NodeWithParent(4), NodeWithParent(3)))
        println(findParentOfTwoNode.solution(head, NodeWithParent(5), NodeWithParent(7)))
        println(findParentOfTwoNode.solution(head, NodeWithParent(4), NodeWithParent(5)))
        println(findParentOfTwoNode.solution(head, NodeWithParent(5), NodeWithParent(8)))
        println(findParentOfTwoNode.solution(head, NodeWithParent(6), NodeWithParent(6)))
    }

    private fun testFindParentOfNode() {
        val head = BinaryTreeNode(
            1,
            BinaryTreeNode(
                2,
                BinaryTreeNode(4, left = BinaryTreeNode(6)),
                BinaryTreeNode(5, right = BinaryTreeNode(7))
            ),
            BinaryTreeNode(3, right = BinaryTreeNode(8))
        )
        println(findParentOfNode.solution(head, BinaryTreeNode(1)))
        println(findParentOfNode.solution(head, BinaryTreeNode(4)))
    }

    private fun testCountAllPalindromeSubString() {
        println(countAllPalindromeSubString.solution("aa"))
        println(countAllPalindromeSubString.solution("bbb"))
        println(countAllPalindromeSubString.solution("abaab"))
        println(countAllPalindromeSubString.solution("abbaeae"))
    }

    private fun testFindBinaryTreeWidth() {
        val head = BinaryTreeNode(
            1,
            BinaryTreeNode(
                2,
                BinaryTreeNode(4, left = BinaryTreeNode(6)),
                BinaryTreeNode(5, right = BinaryTreeNode(7))
            ),
            BinaryTreeNode(3, right = BinaryTreeNode(8))
        )
        println(findBinaryTreeWidth.solution(head))
    }

    private fun testKthLargestElementInArray() {
        println(kthLargestElementInArray.solution(listOf(3, 2, 1, 5, 6, 4), 2))
        println(kthLargestElementInArray.solution(listOf(6, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }

    private fun testSumThreeNumberEqualToZero() {
        println("Loop Solution")
        println(sumThreeNumberEqualToZero.useLoopSolution(listOf(2, -3, 1)))
        println(sumThreeNumberEqualToZero.useLoopSolution(listOf(0, -1, 2, -3, 1)))
        println(sumThreeNumberEqualToZero.useLoopSolution(listOf(1, -2, -2, 0, 5)))
        println(sumThreeNumberEqualToZero.useLoopSolution(listOf(0, -1, 5, 10, 14, -7, -3, 4, 1)))
        println(sumThreeNumberEqualToZero.useLoopSolution(listOf(0, -3, 5, 10, 14, -7, -6, 2, 1)))
        println(sumThreeNumberEqualToZero.useLoopSolution(listOf(3, 3, -2, 10, -7, 3, -6, 1)))
        println(sumThreeNumberEqualToZero.useLoopSolution(listOf(0, 1, 5, 10, -7, 3, 8, 1)))
        println("Sort Solution")
        println(sumThreeNumberEqualToZero.useHashSetSolution(listOf(2, -3, 1)))
        println(sumThreeNumberEqualToZero.useHashSetSolution(listOf(0, -1, 2, -3, 1)))
        println(sumThreeNumberEqualToZero.useHashSetSolution(listOf(1, -2, -2, 0, 5)))
        println(sumThreeNumberEqualToZero.useHashSetSolution(listOf(0, -1, 5, 10, 14, -7, -3, 4, 1)))
        println(sumThreeNumberEqualToZero.useHashSetSolution(listOf(0, -3, 5, 10, 14, -7, -6, 2, 1)))
        println(sumThreeNumberEqualToZero.useHashSetSolution(listOf(3, 3, -2, 10, -7, 3, -6, 1)))
        println(sumThreeNumberEqualToZero.useHashSetSolution(listOf(0, 1, 5, 10, -7, 3, 8, 1)))
    }

    private fun testSwapToHaveLargestNumber() {
        println("Loop Solution")
        println(swapToHaveLargestNumber.useLoopSolution(listOf(1, 9, 7, 3)))
        println(swapToHaveLargestNumber.useLoopSolution(listOf(9, 2, 8, 8, 3)))
        println(swapToHaveLargestNumber.useLoopSolution(listOf(9, 8, 3, 2)))
        println("Sort Solution")
        println(swapToHaveLargestNumber.useSortSolution(listOf(1, 9, 7, 3)))
        println(swapToHaveLargestNumber.useSortSolution(listOf(9, 2, 8, 8, 3)))
        println(swapToHaveLargestNumber.useSortSolution(listOf(9, 8, 3, 2)))
    }

    private fun testReverseKNodeFromHead() {
        println("Test Case 1")
        var head = Node(1, Node(2, Node(3, Node(4, Node(5)))))
        var result: Node? = reverseKNodeFromHead.execute(head, 2)
        while (result != null) {
            println(result.value)
            result = result.next
        }
        println("Test Case 2")
        head = Node(1, Node(2, Node(3, Node(4, Node(5)))))
        result = reverseKNodeFromHead.execute(head, 5)
        while (result != null) {
            println(result.value)
            result = result.next
        }
    }

    private fun testCountIsland() {
        var matrix = arrayListOf(
            arrayListOf(0, 1, 1, 0, 0, 0, 1),
            arrayListOf(0, 1, 0, 0, 1, 1, 0),
            arrayListOf(0, 1, 1, 0, 0, 1, 0),
            arrayListOf(0, 0, 0, 0, 0, 0, 0),
            arrayListOf(0, 1, 1, 1, 1, 1, 0)
        )
        println(countIsland.execute(matrix))
        matrix = arrayListOf(
            arrayListOf(1, 1, 0, 0, 0),
            arrayListOf(0, 1, 0, 0, 1),
            arrayListOf(0, 0, 0, 0, 0),
            arrayListOf(0, 0, 0, 0, 0),
            arrayListOf(1, 0, 1, 1, 0)
        )
        println(countIsland.execute(matrix))
    }

    private fun testCountBSTSubtreeNode() {
        val node = BinaryTreeNode(
            10,
            BinaryTreeNode(
                5,
                BinaryTreeNode(1)
            ),
            BinaryTreeNode(
                50,
                BinaryTreeNode(40),
                BinaryTreeNode(100)
            )
        )
        println(countBSTSubtreeNode.execute(node, Pair(5, 45)))
        println(countBSTSubtreeNode.execute(node, Pair(1, 45)))
    }

    private fun testFindHeightOfBinaryTree() {
        val node = BinaryTreeNode(
            5,
            BinaryTreeNode(
                3,
                BinaryTreeNode(
                    2,
                    BinaryTreeNode(1)
                ),
                BinaryTreeNode(4)
            ),
            BinaryTreeNode(6)
        )
        println(findHeightOfBinaryTree.execute(node))
    }

    private fun testQueueRemoval() {
        val input = LinkedList<Int>()
        input.addAll(listOf(1, 2, 2, 3, 4, 5))
        println(queueRemoval.execute(input, 5))
    }

    private fun testReverseKElementOfQueue() {
        val input = LinkedList<Int>()
        input.addAll(listOf(1, 2, 3, 5, 6, 7, 8, 9, 10))
        reverseKElementOfQueue.execute(input, 1)
        input.forEach { println(it) }
    }

    private fun testRemoveNthNodeFromTheEnd() {
        println("Test Case 1")
        var head = Node(2, Node(3, Node(1, Node(7))))
        var result: Node? = removeNthNodeFromTheEnd.execute(head, 1)
        while (result != null) {
            println(result.value)
            result = result.next
        }
        println("Test Case 2")
        head = Node(1, Node(2, Node(3, Node(4))))
        result = removeNthNodeFromTheEnd.execute(head, 5)
        while (result != null) {
            println(result.value)
            result = result.next
        }
    }

    private fun testReverseLinkedList() {
        println("Test Case 1")
        var head = Node(1, Node(2, Node(3, Node(4))))
        var result: Node? = reverseLinkedList.solution1(head)
        while (result != null) {
            println(result.value)
            result = result.next
        }
        println("Test Case 2")
        head = Node(5, Node(4, Node(3, Node(2, Node(1)))))
        result = reverseLinkedList.solution1(head)
        while (result != null) {
            println(result.value)
            result = result.next
        }
    }

    private fun testMergeSortedLinkedList() {
        println("Test Case 1")
        var nodeA = Node(1, Node(3, Node(7)))
        var nodeB = Node(1, Node(2))
        var result = mergeSortedLinkedList.execute(nodeB, nodeA)
        while (result != null) {
            println(result.value)
            result = result.next
        }
        println("Test Case 2")
        nodeA = Node(5, Node(10, Node(15)))
        nodeB = Node(2, Node(3, Node(20)))
        result = mergeSortedLinkedList.execute(nodeB, nodeA)
        while (result != null) {
            println(result.value)
            result = result.next
        }
    }

    private fun testLongestConsecutiveSequence() {
        println(longestConsecutiveSequence.execute(listOf(1, 9, 3, 10, 4, 20, 2)))
        println(longestConsecutiveSequence.execute(listOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
        println(longestConsecutiveSequence.execute(listOf(36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42)))
    }

    private fun testValidAnagram() {
        println(validAnagram.solution1("listen", "silent"))
        println(validAnagram.solution1("anagram", "nagaram"))
        println(validAnagram.solution1("rat", "car"))
    }

    private fun testPairWithGivenSum() {
        println(pairWithGivenSum.execute(listOf(1, 5, 7, -1, 5), 6))
        println(pairWithGivenSum.execute(listOf(2, 5, 17, -1), 7))
        println(pairWithGivenSum.execute(listOf(1, 5, 3, 3, 3), 6))
    }

    private fun testCheckBalanceOfParenthesis() {
        println(checkBalanceOfParenthesis.isBalance("(([](){}))"))
        println(checkBalanceOfParenthesis.isBalance("(([]({)}))"))
    }

    private fun testSortStartUsingAnotherStack() {
        val stack = Stack<Int>()
        stack.addAll(listOf(4, 3, 1, 6, 2, 5))
        val output = sortStackUsingAnotherStack.execute(stack)
        output.forEach { println(it) }
    }

    private fun testReverseStack() {
        val stack1 = Stack<Int>()
        stack1.addAll(listOf(1, 5, 3, 2, 4))
        reverseStack.execute(stack1)
        stack1.forEach { println(it) }
        val stack2 = Stack<Int>()
        stack2.addAll(listOf(5, 17, 100, 11))
        reverseStack.execute(stack2)
        stack2.forEach { println(it) }
    }

    private fun testMinimumAbsoluteDifference() {
        println(minimumAbsoluteDifference.execute(listOf(5, 3, 2, 4)))
        println(minimumAbsoluteDifference.execute(listOf(2, 4, 7, 13, 17)))
        println(minimumAbsoluteDifference.execute(listOf(1, 7, -12, 22, -8, -16, 18)))
    }

    private fun testCountSubArray() {
        println(countSubArray.execute(listOf(1, 5, 7, 8, 2, 3, 9), 6))
        println(countSubArray.execute(listOf(1, 10, 12, 4, 5, 3, 2, 7), 9))
    }

    private fun testUniqueCharacterInString() {
        println(uniqueCharacterInString.execute("afteracademy"))
    }

    private fun testMinAbsSumPair() {
        val input = listOf(1, 60, -10, 70, -80, 85)
        val result = minAbsoluteSumPair.minAbsSumPairOptimise(input)
        println(result)
    }
}