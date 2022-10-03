package datastructures.stacks.stack_array

fun main() {
    val myStack = Stack()
    myStack.push("Time Bandits")
    myStack.push("Aliens")
    myStack.push("The Thing")
    println(myStack.peek())
    myStack.pop()
    println(myStack.peek())
    println(myStack.isEmpty())
}

class Stack {
    private var stackArray: ArrayList<String> = ArrayList()

    fun peek(): String? {
        return if (stackArray.size > 0) {
            stackArray[stackArray.size - 1]
        } else {
            null
        }
    }

    fun push(value: String) {
        stackArray.add(value)
    }

    fun pop() {
        stackArray.removeAt(stackArray.size - 1)
    }

    fun isEmpty() = stackArray.size == 0
}