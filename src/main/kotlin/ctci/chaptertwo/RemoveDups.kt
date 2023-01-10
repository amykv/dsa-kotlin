package ctci.chaptertwo

// 2.1 - page 94
// In Kotlin, write code to remove duplicates from an unsorted linked list.

fun main() {

    val head = Node(1, null)
    head.next = Node(2, null)
    head.next!!.next = Node(3, null)
    head.next!!.next!!.next = Node(2, null)
    head.next!!.next!!.next!!.next = Node(4, null)
    //head.next!!.next!!.next!!.next!!.next = null

    removeDuplicates(head)

    var current = head
    while (current != null) {
        print("${current.value} ")
        current = current.next!!
    }

}

//Create a set to store the values that have been seen so far.
//Iterate through the linked list, and for each element:
//If the element is not in the set, add it to the set and move on to the next element.
//If the element is already in the set, remove it from the linked list.

//This current function likely needs a rework. Handle cases when the value might be null.

fun removeDuplicates(head: Node) {
    val set = mutableSetOf<Int>()
    var current = head
    while (current.next != null) {
        if (set.contains(current.next!!.value)) {
            current.next = current.next!!.next
        } else {
            set.add(current.next!!.value)
            current = current.next!!
        }
    }
}

//The time complexity of this function is O(n), where n is the number of elements in the linked list, since the
//function iterates through each element in the linked list once. The space complexity is O(d), where d is the number
//of distinct elements in the linked list, since the set stores up to d elements.