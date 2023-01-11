package ctci.chaptertwo

// 2.3 - page 94
// In Kotlin, implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not
// necessarily the exact middle) of a singly linked list, given only access to that node.

fun main() {

    // Initialize the linked list
    val head = Node(1, null)
    var current = head
    for (i in 2..5) {
        current.next = Node(i, null)
        current = current.next!!
    }

    // Delete the 3rd node
    val nodeToDelete = head.next!!.next // this is the node with value 3
    if (nodeToDelete != null) {
        deleteNode(nodeToDelete)
    }

    /// Print the linked list to check if the 3rd node has been deleted
    var currentNode: Node? = head
    while (currentNode != null) {
        print("${currentNode.value} ")
        currentNode = currentNode.next
    }
}

//The idea behind this algorithm is to copy the data from the next node to the current node, and then delete the next
// node. This way, the current node effectively takes the place of the next node, and the next node is deleted.
fun deleteNode(node: Node) {
    node.value= node.next!!.value
    node.next = node.next!!.next
}

//The space complexity of the deleteNode function is O(1), as we are not allocating any additional memory.
// We are just modifying the current node and its next pointer.

//The time complexity is also O(1), as we are only performing a constant amount of operations, regardless of the
// size of the list. We are only modifying the current node and its next pointer, which takes constant time.