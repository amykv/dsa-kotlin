package ctci.chapterthree

import java.util.*

// 3.3 - page 99
//Imagine a literal stack of plates. If the stack gets too high, it might topple. Therefore, in real life we would likely
//start a new stack when the previous stack exceeds some threshold. In Kotlin, implement a data structure SetOfStacks
//that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one
//exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack.

fun main() {
    val capacity = 2
    val setOfStacks = SetOfStacks(capacity)
    setOfStacks.push(1)
    setOfStacks.push(2)
    setOfStacks.push(3)
    setOfStacks.push(4)
    println("Popped element: ${setOfStacks.pop()}") // 4
    println("Popped element from stack 1: ${setOfStacks.popAt(1)}") // 1
    println("Popped element: ${setOfStacks.pop()}") // 3
    println("Popped element: ${setOfStacks.pop()}") // 2

}

//This implementation uses a MutableList to store each individual stack. When the push() method is called, it checks
// if the current stack has reached its capacity. If it has, a new stack is created and added to the list of stacks.
// If the current stack has not reached its capacity, the value is simply added to the current stack.
//The pop() method removes the top element from the current stack and, if the current stack is empty after the pop,
// it is removed from the list of stacks.
//The popAt(stackIndex: Int) method, removes the top element from the specific stack and return it, it also
// shifts all the elements of the stacks above the specific stack, one stack down to fill the gap left by the removed stack.
class SetOfStacks(private val capacity: Int) {
    private var stacks = ArrayList<ArrayList<Int>>()
    private var currentStack = 0

    init {
        stacks.add(ArrayList())
    }

    fun push(value: Int) {
        if (stacks[currentStack].size == capacity) {
            stacks.add(ArrayList())
            currentStack++
        }
        stacks[currentStack].add(value)
    }

    fun pop(): Int {
        if (stacks.isEmpty()) {
            throw Exception("Set of stacks is empty")
        }
        val value = stacks[currentStack].removeAt(stacks[currentStack].size - 1)
        if (stacks[currentStack].isEmpty()) {
            stacks.removeAt(currentStack)
            currentStack--
        }
        return value
    }

    fun popAt(stackIndex: Int): Int {
        if (stacks.isEmpty() || stackIndex > currentStack) {
            throw Exception("Set of stacks is empty or Invalid stack index")
        }
        val value = stacks[stackIndex].removeAt(stacks[stackIndex].size - 1)
        if (stacks[stackIndex].isEmpty() && stackIndex < currentStack ) {
            stacks.removeAt(stackIndex)
            currentStack--
        }
        return value
    }
}


//push(value: Int): this method has a time complexity of O(1) in the average case and O(n) in the worst case. In the
//average case, where the current stack has not reached its capacity, the value is simply added to the current stack
//in O(1) time. In the worst case, where the current stack has reached its capacity and a new stack needs to be created,
//the method will iterate through the list of stacks once to add the new stack, which takes O(n) time.
//
//pop(): this method has a time complexity of O(1) in the average case and O(n) in the worst case. In the average case,
//where the current stack is not empty, the top element is simply removed from the current stack in O(1) time. In the
//worst case, where the current stack is empty and needs to be removed from the list of stacks, the method will iterate
//through the list of stacks once to remove the current stack, which takes O(n) time.
//
//popAt(stackIndex: Int): this method has a time complexity of O(1) in the average case and O(n) in the worst case.
//In the average case, where the specific stack is not empty and not the last stack, the top element is simply removed
//from the specific stack and shifted all the elements of the stacks above it one stack down to fill the gap left by
//the removed stack, in O(1) time. In the worst case, where the specific stack is empty and the last stack and needs
//to be removed from the list of stacks, the method will iterate through the list of stacks once to remove the current
//stack and shift all the elements of the stacks above it one stack down, which takes O(n) time.
//
//Space: The space complexity of this implementation is O(n) where n is the number of elements. This is because each
//element is stored in the stack and the number of stacks is directly proportional to the number of elements.