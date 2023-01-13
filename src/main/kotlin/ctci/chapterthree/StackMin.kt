package ctci.chapterthree

// 3.2 - page 98
// In Kotlin, how would you design a stack which, in addition to push and pop, has a function called min which returns
// the minimum element? Push, pop, and min should all operate in O(1) time.

fun main() {

    val stack = MinStack()
    stack.push(5)
    stack.push(4)
    stack.push(3)
    stack.push(6)
    println("Minimum element: ${stack.min()}") // 3
    stack.pop()
    println("Minimum element: ${stack.min()}") // 4
    stack.pop()
    println("Minimum element: ${stack.min()}") // 4
    stack.pop()
    println("Minimum element: ${stack.min()}") // 5

}

//This implementation uses two stacks: stack which stores all elements, and minStack which stores the minimum elements.
// When an element is pushed onto the stack, it's also pushed onto the minStack if it's smaller or equal to the current
// minimum element. When an element is popped from the stack, it's also popped from the minStack if it's equal to the
// current minimum element.
class MinStack {

//    An ArrayDeque is a data structure that stands for "Array Double Ended Queue" in Kotlin, it is a resizable array
//    implementation of the Deque interface. It is similar to an array, but with the added capabilities of efficiently
//    adding and removing elements from both the front and the back of the deque. It has the capabilities of both stack
//    and a queue, where you can add and remove elements from both the end.
    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.addFirst(x)
        if (minStack.isEmpty() || x <= minStack.first()) {
            minStack.addFirst(x)
        }
    }

    fun pop() {
        if (stack.isEmpty()) {
            throw Exception("Stack is empty")
        }
        if (stack.first() == minStack.first()) {
            minStack.removeFirst()
        }
        stack.removeFirst()
    }

    fun min(): Int {
        if (minStack.isEmpty()) {
            throw Exception("Stack is empty")
        }
        return minStack.first()
    }
}

//This way, the top element of the minStack is always the minimum element of the stack.
//push, pop and min function all have O(1) time complexity, since the operations are performed directly on the top of the stack.
//Space complexity is O(n), where n is the number of elements in the stack.