package com.example.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithm.array.CarParking
import com.example.algorithm.array.CountAllPalindromeSubString
import com.example.algorithm.array.CountSubArray
import com.example.algorithm.kadane.MaximumSubArray
import com.example.algorithm.array.MinAbsoluteSumPair
import com.example.algorithm.array.MinimumAbsoluteDifference
import com.example.algorithm.array.MinimumParkingSpace
import com.example.algorithm.array.SingleNumber
import com.example.algorithm.array.SlidingWindowMaximum
import com.example.algorithm.array.ValidPalindrome
import com.example.algorithm.hastable.DetectLoopInALinkedList
import com.example.algorithm.hastable.LongestConsecutiveSequence
import com.example.algorithm.hastable.PairWithGivenSum
import com.example.algorithm.hastable.FirstUniqueCharacterInString
import com.example.algorithm.linkedlist.*
import com.example.algorithm.matrix.RotateImage
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
import com.example.algorithm.tree.TreeTraversalInIterative
import java.util.*

class MainActivity : AppCompatActivity() {

    /**
     * Array algorithm
     * https://www.hackerrank.com/domains/algorithms?utm_source=hrwCandidateFeedback
     */
    private val minAbsoluteSumPair by lazy { MinAbsoluteSumPair() }
    private val uniqueCharacterInString by lazy { FirstUniqueCharacterInString() }
    private val countSubArray by lazy { CountSubArray() }
    private val minimumAbsoluteDifference by lazy { MinimumAbsoluteDifference() }
    private val reverseStack by lazy { ReverseStackUsingRecursion() }
    private val sortStackUsingAnotherStack by lazy { SortAStackUsingAnotherStack() }
    private val checkBalanceOfParenthesis by lazy { CheckBalanceOfParenthesis() }
    private val pairWithGivenSum by lazy { PairWithGivenSum() }
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
    private val findBinaryTreeWidth by lazy { FindBinaryTreeWidth() }
    private val countAllPalindromeSubString by lazy { CountAllPalindromeSubString() }
    private val findParentOfNode by lazy { FindParentOfNode() }
    private val findParentOfTwoNode by lazy { FindParentOfTwoNode() }
    private val treeTraversalInIterative by lazy { TreeTraversalInIterative() }
    private val minimumParkingSpace by lazy { MinimumParkingSpace() }
    private val slidingWindowMaximum by lazy { SlidingWindowMaximum() }
    private val validateIpAddress by lazy { ValidateIpAddress() }
    private val validPalindrome by lazy { ValidPalindrome() }
    private val maximumSubArray by lazy { MaximumSubArray() }
    private val detectLoopInALinkedList by lazy { DetectLoopInALinkedList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // https://www.techinterviewhandbook.org/coding-interview-study-plan/
        // Character `a` = 01100001 = 0*2^7 + 1*2^6 + 1*2^5 + ... 1*2^0 = 97

        //MainActivityViewModel().test() /* Test multiple subscriber into the same ShareFlow */

        RotateImage().execute()
        //SingleNumber().execute()
        //LongPressedName().execute()
        //SubProductLessThanK().execute()
        //MaximumProductSubArray().execute()
        //Merge2SortedArray().execute()
        //GroupOfSpecialEquivalentString().execute()
        //ProductOfArrayExceptSelf().execute()
        //GroupAnagrams().execute()
        //binarySearch.execute()
        //breadthFirstSearch.displayGraph()
        //detectCircleInDirectedGraph.execute()
        //CoroutineCloseableWithDeferred().execute()
        //testDetectLoopInALinedList()
        //testMaximumSubArray()
        //testValidPalindrome()
        //testLongestRepeatedSubString()
        //testValidateIpAddress()
        //testSlidingWindowMaximum()
        //testMinimumParkingSpace()
        //testTreeTraversalInIterative()
        //testFindParentOfTwoNode()
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

    private fun testDetectLoopInALinedList() {
        val node = Node(0)
        println("detect loop in linked-List ${detectLoopInALinkedList.solution(node)}")
        val node1 = Node(1)
        val head1 = Node(2, next = node1)
        head1.next?.next = head1
        println("detect loop in linked-List ${detectLoopInALinkedList.solution(head1)}")
        val node2 = Node(2, Node(3, Node(4)))
        node2.next?.next?.next = node2
        val head2 = Node(1, node2)
        println("detect loop in linked-List ${detectLoopInALinkedList.solution(head2)}")
    }

    private fun testMaximumSubArray() {
        println("Maximum Sub-Array ${maximumSubArray.solution(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))}")
        println("Maximum Sub-Array ${maximumSubArray.solution(listOf(5, 4, -1, 7, 8))}")
        println("Maximum Sub-Array ${maximumSubArray.solution(listOf(1))}")
    }

    private fun testValidPalindrome() {
        println("Valid Palindrome ${validPalindrome.isValidPalindrome("A man, a plan, a canal: Panama")}")
        println("Valid Palindrome ${validPalindrome.isValidPalindrome("race a car")}")
        println("Valid Palindrome ${validPalindrome.isValidPalindrome("")}")
    }

    private fun testValidateIpAddress() {
        println(validateIpAddress.solution("192.168.1.1"))
        println(validateIpAddress.solution("192.168.1.0"))
        println(validateIpAddress.solution("192.168.01.1"))
        println(validateIpAddress.solution("192.168.1.00"))
        println(validateIpAddress.solution("192.168@1.1"))
        println(validateIpAddress.solution("2001:0db8:85a3:0000:0000:8a2e:0370:7334"))
        println(validateIpAddress.solution("2001:db8:85a3:0:0:8A2E:0370:7334"))
        println(validateIpAddress.solution("2001:0db8:85a3::8A2E:037j:7334"))
        println(validateIpAddress.solution("02001:0db8:85a3:0000:0000:8a2e:0370:7334"))
    }

    private fun testSlidingWindowMaximum() {
        println(slidingWindowMaximum.maxHeapSolution(listOf(1, 2, 3, 1, 4, 5, 2, 3, 6), 3))
        println(slidingWindowMaximum.maxHeapSolution(listOf(8, 5, 10, 7, 9, 4, 15, 12, 90, 13), 4))
    }

    private fun testMinimumParkingSpace() {
        println(
            minimumParkingSpace.sortSolution(
                listOf(
                    CarParking(1012, 1136),
                    CarParking(1317, 1417),
                    CarParking(1015, 1020)
                )
            )
        )
        println(
            minimumParkingSpace.sortSolution(
                listOf(
                    CarParking(1120, 1159),
                    CarParking(1508, 1529),
                    CarParking(1508, 1527),
                    CarParking(1503, 1600),
                    CarParking(1458, 1629),
                    CarParking(1224, 1313)
                )
            )
        )
        println(
            minimumParkingSpace.sortSolution(
                listOf(
                    CarParking(1000, 1200),
                    CarParking(1005, 1010),
                    CarParking(1005, 1200),
                    CarParking(1010, 1200),
                    CarParking(1015, 1200)
                )
            )
        )
    }

    private fun testTreeTraversalInIterative() {
        val node = BinaryTreeNode(
            1,
            BinaryTreeNode(
                2,
                BinaryTreeNode(4, left = BinaryTreeNode(6)),
                BinaryTreeNode(5, right = BinaryTreeNode(7))
            ),
            BinaryTreeNode(3, right = BinaryTreeNode(8))
        )
        treeTraversalInIterative.solution(node)
    }

    private fun testFindParentOfTwoNode() {
        val head = BinaryTreeNode(
            1,
            BinaryTreeNode(
                2,
                BinaryTreeNode(4, left = BinaryTreeNode(6)),
                BinaryTreeNode(5, right = BinaryTreeNode(7))
            ),
            BinaryTreeNode(3, right = BinaryTreeNode(8))
        )
        println(findParentOfTwoNode.solution2(head, BinaryTreeNode(4), BinaryTreeNode(5)))
        println(findParentOfTwoNode.solution2(head, BinaryTreeNode(1), BinaryTreeNode(1)))
        println(findParentOfTwoNode.solution2(head, BinaryTreeNode(4), BinaryTreeNode(3)))
        println(findParentOfTwoNode.solution2(head, BinaryTreeNode(5), BinaryTreeNode(7)))
        println(findParentOfTwoNode.solution2(head, BinaryTreeNode(4), BinaryTreeNode(5)))
        println(findParentOfTwoNode.solution2(head, BinaryTreeNode(5), BinaryTreeNode(8)))
        println(findParentOfTwoNode.solution2(head, BinaryTreeNode(6), BinaryTreeNode(6)))
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
        println(countAllPalindromeSubString.solution("ab"))
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