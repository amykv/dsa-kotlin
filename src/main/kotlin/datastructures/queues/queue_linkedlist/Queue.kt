package datastructures.queues.queue_linkedlist

fun main() {
    val myQueue = Queue()
    println(myQueue.isEmpty())
    println(myQueue.peek())
    myQueue.enqueue("The Lord of the Rings")
    myQueue.enqueue("Pillars of the Earth")
    myQueue.enqueue("I, Claudius")
    myQueue.enqueue("Elfstones of Shannara")
    myQueue.dequeue()
    println(myQueue.peek())
}

class Queue {
    var first: Node? = null
    var last: Node? = null
    var length = 0

    fun peek(): String? {
        return if (length > 0) {
            first?.value
        } else {
            null
        }
    }

    fun enqueue(value: String?) {
        val newNode = Node(value)
        if (length == 0) {
            first = newNode
        } else {
            last?.next = newNode
        }
        last = newNode
        length++
    }

    fun dequeue() {
        if (length > 0) {
            first = first?.next
            if (length == 1) {
                last = null
            }
            length--
        }
    }

    fun isEmpty() = length == 0
}

class Node(var value: String?) {
    var next: Node? = null
}
