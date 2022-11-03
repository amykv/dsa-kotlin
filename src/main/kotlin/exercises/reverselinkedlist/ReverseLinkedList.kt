package exercises.reverselinkedlist

import datastructures.linkedlists.singlylinkedlist.Node
import java.util.*

/*Given the head of a singly linked list, reverse the list, and return the reversed list.



Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []*/

fun main() {
    val solution1 = Solution()


}

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
    fun reverseList(head: ListNode?): ListNode? {
        var node = head
        var reversed: ListNode? = null
        var temp: ListNode? = null

        while(node != null){
            temp = node?.next
            node?.next = reversed
            reversed = node
            node = temp
        }
        return reversed

    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}