package ctci.chaptertwo

// 2.4 - page 94
//In Kotlin, write code to partition a linked list around a value x, such that all nodes less than x come before all
// nodes greater than or equal to x. (NOTE: The partition element x can appear anywhere in the "right partition";
// it does not need to appear between the left and right partitions.)

fun main() {

    // Initialize the linked list
    val head = Node(3, null)
    var current = head
    current.next = Node(5, null)
    current = current.next!!
    current.next = Node(8, null)
    current = current.next!!
    current.next = Node(5, null)
    current = current.next!!
    current.next = Node(10, null)
    current = current.next!!
    current.next = Node(2, null)
    current = current.next!!
    current.next = Node(1, null)

    val partitionValue = 5
    val partitionedList = partitionList(head, partitionValue)
    var currentNode = partitionedList
    var isPartitionFound = false

    while (currentNode != null) {
        // Use curly braces to print out actual value, not object value which is random chars
        print("${currentNode.value} ")
        if (!isPartitionFound && currentNode.value >= partitionValue) {
            isPartitionFound = true
        }
        if (isPartitionFound) {
            assert(currentNode.value >= partitionValue)
        } else {
            assert(currentNode.value < partitionValue)
        }
        currentNode = currentNode.next
    }

}

//This function takes two arguments, head of the list and the partition element. It creates two separate lists, left
// and right. The left list contains all elements that are smaller than the partition element, while the right list
// contains elements that are greater than or equal to the partition element. It then merges the two lists
// together in the end.

fun partitionList(head: Node?, partition: Int): Node? {
    // Initialize pointers for the left and right partitions
    var leftStart: Node? = null
    var leftEnd: Node? = null
    var rightStart: Node? = null
    var rightEnd: Node? = null

    var current = head
    // Iterate through the linked list
    while (current != null) {
        // Store the next node to be processed
        val next = current.next
        // Break the link between the current node and its next node
        current.next = null

        if (current.value < partition) {
            // Add the current node to the left partition
            if (leftStart == null) {
                // If the left partition is empty, set the leftStart and leftEnd pointers to the current node
                leftStart = current
                leftEnd = current
            } else {
                // If the left partition is not empty, add the current node to the end of the left partition
                leftEnd!!.next = current
                leftEnd = current
            }
        } else {
            // Add the current node to the right partition
            if (rightStart == null) {
                // If the right partition is empty, set the rightStart and rightEnd pointers to the current node
                rightStart = current
                rightEnd = current
            } else {
                // If the right partition is not empty, add the current node to the end of the right partition
                rightEnd!!.next = current
                rightEnd = current
            }
        }
        // Move to the next node
        current = next
    }

    if (leftStart == null) return rightStart
    // merge both left and right partition
    leftEnd!!.next = rightStart
    return leftStart
}
//The function has O(n) time complexity where n is the number of elements in the list, because it iterates through the
// list once and performs a constant amount of operations for each element.
//
//This solution has O(1) space complexity because it only uses a constant amount of extra memory to store the
// leftStart, leftEnd, rightStart, rightEnd pointers.
//
//It's worth noting that this implementation will also work for linked list with negative values or floating
// point values.
