package com.example.algorithm.array

/**
 * There is a list of character heights aligned by index to their letters.
 * For example, 'a' is at index 0 and 'z' is at index 26.
 * Using the letter heights given, determine the area of the rectangle highlight in mm2,
 * assuming all letters are 1mm wide.
 *
 * Example
 * h = 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 6 7
 * word = adc
 * result = 9
 * Explanation:
 * - 'a' = 1, 'd' = 3, 'c' = 1. Max Height = 3
 * - 'abc' has length = 3
 * - The selection area = 3 * 3 = 9
 */
class DesignerPDFViewer {

    fun execute() {
        val input = arrayOf(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7)
        println("DesignerPDFViewer: ${calculateHighlightedArea(input, "zaba")}")
        println("DesignerPDFViewer: ${calculateHighlightedArea(input, "dfasdfadsadsfasdfasdasgwqrtwerbsdfgsdfhstrhaertawresdfszdgzs")}")
    }

    private fun calculateHighlightedArea(height: Array<Int>, word: String): Int {
        // Build hashMap character height
        val ascii = "acbdefghijklmnopqrstuvwxyz"
        val hashMapHeight = hashMapOf<String, Int>()
        ascii.forEachIndexed { index, s ->
            hashMapHeight[s.toString()] = height[index]
        }

        // Find max height
        val maxHeight = word
            .map {
                hashMapHeight[it.toString()] ?: 0
            }
            .reduce { acc, next ->
                if (acc > next) acc else next
            }

        return word.length * maxHeight
    }
}