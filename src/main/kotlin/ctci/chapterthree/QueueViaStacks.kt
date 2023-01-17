package ctci.chapterthree

import java.util.*

// 3.4 - page 99
// In Kotlin, implement a MyQueue class which implements a queue using two stacks.

fun main() {
    val myQueue = MyQueue<Int>()

    myQueue.enqueue(1)
    myQueue.enqueue(2)
    myQueue.enqueue(3)
    println("Dequeue: ${myQueue.dequeue()}") // should print "Dequeue: 1"
    myQueue.enqueue(4)
    println("Dequeue: ${myQueue.dequeue()}") // should print "Dequeue: 2"
    println("Dequeue: ${myQueue.dequeue()}") // should print "Dequeue: 3"
    println("Dequeue: ${myQueue.dequeue()}") // should print "Dequeue: 4"
    println("Dequeue: ${myQueue.dequeue()}") // should print "Dequeue: null"

}

//The enqueue method simply pushes the item onto stack1, while the dequeue method first checks if stack2 is empty. If
// it is, it pops all elements from stack1 and pushes them onto stack2. This reverses the order of the elements, so
// that the element that was added first to stack1 is now at the top of stack2 and can be returned. If stack2 is not
// empty, it simply pops the top element. If both stack1 and stack2 are empty, it returns null.
class MyQueue<T> {
    private val stack1 = Stack<T>()
    private val stack2 = Stack<T>()

    fun enqueue(item: T) {
        stack1.push(item)
    }

    fun dequeue(): T? {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop())
            }
        }
        return if (stack2.isEmpty()) null else stack2.pop()
    }
}

//The space complexity of this implementation is O(n), where n is the number of elements in the queue. This is because
// both stack1 and stack2 are used to store the elements in the queue, and at any given time, the total number of
// elements stored in both stacks is equal to the number of elements in the queue.
//
//The time complexity of the enqueue operation is O(1), as it simply involves pushing an element onto the stack, which
// takes constant time.
//
//The time complexity of the dequeue operation is O(n) in the worst case scenario, when all the elements are in
// stack1 and need to be transferred to stack2. This is because each element must be popped from stack1 and pushed
// onto stack2, taking a total of n operations. However, in the best case scenario, when all the elements are already
// in stack2, it takes O(1) time, as it simply involves popping the top element from stack2.
//
//On average, the dequeue operation will take O(1) time, as long as the number of enqueue and dequeue operations
// are balanced.