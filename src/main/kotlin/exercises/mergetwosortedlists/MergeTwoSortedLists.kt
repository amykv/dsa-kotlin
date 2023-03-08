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

    // Test case 1: Input: 1->2->4, 1->3->4; Output: 1->1->2->3->4->4
    val l1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(4)
        }
    }
    val l2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4)
        }
    }
    // Merge the two lists and print the result
    val mergedList = mergeTwoLists(l1, l2)
    var current = mergedList
    while (current != null) {
        print("${current.value} ")
        current = current.next
    }
    // Output: 1 1 2 3 4 4
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

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    // Create a dummy node as the head of the merged list
    val dummy = ListNode(0)
    var tail = dummy

    // Traverse the two input lists and add the smaller node to the merged list
    var p1 = l1
    var p2 = l2
    while (p1 != null && p2 != null) {
        if (p1.value < p2.value) {
            tail.next = p1
            p1 = p1.next
        } else {
            tail.next = p2
            p2 = p2.next
        }
        tail = tail.next!!
    }

    // Add the remaining nodes to the merged list
    if (p1 != null) {
        tail.next = p1
    } else if (p2 != null) {
        tail.next = p2
    }

    // Return the head of the merged list (excluding the dummy node)
    return dummy.next
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}

/*The ListNode class is a simple class to represent a node in a linked list. Each node contains an integer value and
a reference to the next node.
The mergeTwoLists function takes two linked lists (l1 and l2) as input and returns a merged linked list. It first
creates a dummy node to hold the result, and initializes a current pointer to it.
The function then iterates through both input lists as long as both lists are not empty. It compares the values of
the heads of the two lists, and appends the smaller one to the result list. It then moves the current pointer to the
next node in the result list.
After the while loop, the function checks if there are any remaining nodes in either input list, and appends them to
the result list.
Finally, the function returns the merged list (skipping the dummy head).
The main function creates two sorted linked lists (list1 and list2), merges them using the mergeTwoLists function,
and prints the values of the merged list.
The time complexity of this program is O(n), where n is the total number of nodes in the input lists. The space
complexity is O(1), as we only use a constant amount of extra space to hold the dummy node and the current pointer.*/