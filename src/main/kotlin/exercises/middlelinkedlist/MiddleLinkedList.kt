package exercises.middlelinkedlist

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

*/

fun main() {

}


//876
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var nodeCount = 1
        var nodePointer = head

        var midNodePointer = head
        var nodeCountHalf: Int
        var midIndex = 1

        // Traverse the whole linked list
        while (nodePointer?.next != null) {
            nodePointer = nodePointer.next!!
            nodeCount++
            nodeCountHalf = nodeCount / 2

            // Move the middle pointer to the halfway point
            while (midIndex <= nodeCountHalf) {
                // cast because leetcode seems to be using an older version of kotlin
                midNodePointer as ListNode
                midNodePointer = midNodePointer.next!!
                midIndex++
            }

        }

        return midNodePointer

    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}