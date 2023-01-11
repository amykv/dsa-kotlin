package ctci.chaptertwo

// 2.5 - page 95
// You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in
// reverse order, such that the 1's digit is at the head of the list. In Kotlin, write a function that adds the two
// numbers and returns the sum as a linked list. Not allowed to just convert the linked list to an integer.

fun main() {

    val list1 = Node(9, null)
    var current1 = list1
    current1.next = Node(9, null)
    current1 = current1.next!!
    current1.next = Node(9, null)

    val list2 = Node(1, null)
    var current2 = list2
    current2.next = Node(8, null)
    current2 = current2.next!!
    current2.next = Node(3, null)

    val sumList = addLists(list1, list2)
    var current = sumList
    while (current != null) {
        print("${current.value} ")
        current = current.next
    }
    // should print "0 0 1 "

}

//This function takes two linked lists, each representing a number. It iterates through the two linked lists at the
// same time, adding the corresponding digits and the carry from the previous addition. If one of the lists is
// shorter than the other, it considers the missing digits as 0. If the final carry is greater than 0, it adds a new node with the carry value to the resulting list.
fun addLists(l1: Node?, l2: Node?): Node? {
    var dummyHead = Node(0, null)
    var current = dummyHead
    var carry = 0
    var p1 = l1
    var p2 = l2

    while (p1 != null || p2 != null) {
        var x = if (p1 != null) p1.value else 0
        var y = if (p2 != null) p2.value else 0

        val sum = carry + x + y
        carry = sum / 10
        current.next = Node(sum % 10, null)

        current = current.next!!
        if (p1 != null) p1 = p1.next
        if (p2 != null) p2 = p2.next
    }

    if (carry > 0) {
        current.next = Node(carry, null)
    }

    return dummyHead.next
}

//It has O(max(n,m)) time complexity, where n and m are the number of digits in the two input lists.
// Because it iterates through both lists once, and performs a constant amount of operations for each digit.
//
//This solution has O(max(n,m)) space complexity because it creates a new linked list with max(n,m) elements.