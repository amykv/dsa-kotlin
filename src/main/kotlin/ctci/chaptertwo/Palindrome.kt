package ctci.chaptertwo

import java.util.*

// 2.6 - page 95
// In Kotlin, implement a function to check if a linked list is a palindrome.

fun main() {

    val list = Node(1, null)
    var current = list
    current.next = Node(2, null)
    current = current.next!!
    current.next = Node(3, null)
    current = current.next!!
    current.next = Node(4, null)
    current = current.next!!
    current.next = Node(3, null)
    current = current.next!!
    current.next = Node(2, null)
    current = current.next!!
    current.next = Node(1, null)

    if (isPalindrome(list)) {
        println("The linked list is a palindrome.")
    } else {
        println("The linked list is not a palindrome.")
    }

}

//This function uses a stack data structure to store the first half of the linked list, and then compares the
// elements of the second half of the linked list with the elements on the stack.
fun isPalindrome(head: Node?): Boolean {
    var fast = head
    var slow = head
    var stack = Stack<Int>()

    // push elements from first half of linked list onto stack. When fast runner
    // (which is moving at 2x speed) reaches the end of the linked list, then we
    // know we're at the middle
    while (fast != null && fast.next != null) {
        stack.push(slow!!.value)
        slow = slow.next
        fast = fast.next!!.next
    }

    // has odd number of elements, so skip the middle element
    if (fast != null) {
        slow = slow!!.next
    }

    while (slow != null) {
        if (stack.pop() != slow.value) {
            return false
        }
        slow = slow.next
    }

    return true
}

//It has O(n) time and space complexity, where n is the number of elements in the linked list, as it iterates
// through the list once and performs a constant amount of operations for each element.