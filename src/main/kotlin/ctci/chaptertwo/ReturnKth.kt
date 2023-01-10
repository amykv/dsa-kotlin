package ctci.chaptertwo

// 2.2 - page 94
// In Kotlin, implement an algorithm to find the kth to last element of a singly linked list.

fun main() {

    // Create a singly linked list
    val head = Node(1, null)
    head.next = Node(2, null)
    head.next!!.next = Node(3, null)
    head.next!!.next!!.next = Node(4, null)
    head.next!!.next!!.next!!.next = null // Required to avoid NullPointerException error

// Find the 2nd to last element
    val k = 2
    val result = kthToLast(head, k)
    if (result != null) {
        println("The $k-th to last element is ${result.value}")
    } else {
        println("k is out of bounds")
    }
}

//Create two pointers, current and runner, both pointing to the head of the list.
//Move the runner pointer k steps ahead in the list.
//While the runner pointer is not null, move both current and runner pointers one step ahead.
//When the runner pointer reaches the end of the list, the current pointer will be at the kth to last element.

fun kthToLast(head: Node?, k: Int): Node? {
    if (head == null) return null
    var current: Node? = head
    var runner: Node? = head

    // Move the runner k steps ahead
    for (i in 1..k) {
        if (runner == null) return null // Check for out-of-bounds k
        runner = runner.next
    }

    // Move both pointers one step ahead until runner reaches the end of the list
    while (runner != null) {
        current = current?.next
        runner = runner.next
    }

    return current
}

//The time complexity of this function is O(n) where n is the number of elements in the list, as it needs to iterate
// once over the list, and the space complexity is O(1) since it uses only two pointers and no additional
// data structure.