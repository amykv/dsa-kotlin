package ctci.chapterthree

import java.util.*

// 3.5 - page 99
// In Kotlin, write a program to sort a stack such that the smallest items are on the top. Can use an additional
// temporary stack, but you may not copy the elements into any other data structure(such as an array). The stack
// supports the following operation: push, pop, peek, and isEmpty.

fun main() {

}


//This implementation uses two stacks, one called stack to store the items and another called tempStack, which is used
// as a temporary storage during the sorting process. The push method first pops all the elements from the stack that
// are greater than the item to be inserted and pushes them onto the tempStack. Then, the item is inserted into the
// stack. Finally, the elements are popped from the tempStack and pushed back onto the stack, in the order they were
// popped, thus preserving the order of the elements that are less than the item. The pop, peek and isEmpty methods
// are simple implementations that delegate the call to the internal stack.
class SortedStack<T : Comparable<T>> {
    private val stack = Stack<T>()
    private val tempStack = Stack<T>()

    fun push(item: T) {
        while (!stack.isEmpty() && item > stack.peek()) {
            tempStack.push(stack.pop())
        }
        stack.push(item)
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop())
        }
    }

    fun pop(): T? {
        return if (stack.isEmpty()) null else stack.pop()
    }

    fun peek(): T? {
        return if (stack.isEmpty()) null else stack.peek()
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }
}

//The time complexity of the push operation is O(n) as worst case scenario, when the item to be inserted is the largest
// one, it needs to iterate over all the elements on the stack and move them to the tempStack. The space complexity
// is O(n) as well, as it uses two stacks to store the elements.