package datastructures.stacks

fun main() {

    val myStack = Stack()
    myStack.push("Subaru")
    myStack.push("Honda")
    myStack.push("Toyota")
    myStack.push("Mazda")
    println(myStack.peek())
    myStack.pop()
    println(myStack.isEmpty())
    println(myStack.lastElement)
}

//Implementation of what is in a Stack
class Stack {
    private var top: Node? = null
    private var bottom: Node? = null
    private var length = 0

    fun peek(): String? {
        return if (length > 0) {
            top!!.value
        } else {
            null
        }
    }

    fun push(value: String?) {
        val newNode = Node(value!!)
        if (length == 0) {
            top = newNode
            bottom = newNode
        } else {
            newNode.next = top
            top = newNode
        }
        length++
    }

    fun pop() {
        if (length > 0) {
            top = top!!.next
            if (length == 1) {
                bottom = null
            }
            length--
        }
    }

    fun isEmpty() = length == 0

    val lastElement: String?
        get() = if (length > 0) {
            bottom!!.value
        } else null
}

class Node(var value: String) {
    var next: Node? = null
}