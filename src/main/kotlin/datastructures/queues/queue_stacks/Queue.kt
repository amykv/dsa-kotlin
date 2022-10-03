package datastructures.queues.queue_stacks

import java.util.*

fun main() {
    val myQueue = Queue()
    myQueue.push(6)
    myQueue.push(7)
    myQueue.push(15)
    myQueue.push(17)
    myQueue.push(33)
    myQueue.push(34)
    myQueue.push(54)
    myQueue.push(86)
    println("queue: " + myQueue.queueStack)
    println("peek: " + myQueue.peek())
    println("pop: " + myQueue.pop())
    println("queue: " + myQueue.queueStack)
    println("peek: " + myQueue.peek())
    println("is queue empty: " + myQueue.empty())
}

class Queue {
    var queueStack = Stack<Int>()

    private var revStack = Stack<Int>()
    fun push(x: Int) {
        if (queueStack.size == 0) {
            queueStack.push(x)
        } else {
            while (queueStack.size != 0) {
                revStack.push(queueStack.pop())
            }
            revStack.push(x)
            while (revStack.size != 0) {
                queueStack.push(revStack.pop())
            }
        }
    }

    fun pop(): Int? {
        return if (queueStack.size > 0) {
            queueStack.pop()
        } else {
            null
        }
    }

    fun peek(): Int? {
        return if (queueStack.size > 0) {
            queueStack[queueStack.size - 1]
        } else {
            null
        }
    }

    fun empty() = queueStack.size == 0
}