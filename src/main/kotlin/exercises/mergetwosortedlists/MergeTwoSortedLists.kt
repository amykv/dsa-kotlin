package exercises.mergetwosortedlists


/*You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]*/

fun main() {

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
//class Solution {
//    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
//        var head = ListNode(0)
//        val result = head
//
//        var l1 = list1
//        var l2 = list2
//
//        while (l1 != null && l2 != null) {
//            if (l1.`val` < l2.`val`) {
//                head.next = l1
//                l1 = l1?.next
//            } else {
//                head.next = l2
//                l2 = l2?.next
//            }
//            head = head.next
//        }
//
//        if (l1 != null) {
//            head.next = l1
//        } else if (l2 != null) {
//            head.next = l2
//        }
//
//        return result.next
//
//    }
//}

class ListNode(var value: Int) {
    var next: ListNode? = null
}