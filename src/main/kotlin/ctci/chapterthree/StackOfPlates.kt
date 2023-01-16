package ctci.chapterthree

// 3.3 - page 99
//Imagine a literal stack of plates. If the stack gets too high, it might topple. Therefore, in real life we would likely
//start a new stack when the previous stack exceeds some threshold. In Kotlin, implement a data structure SetOfStacks
//that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one
//exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack.

fun main() {

}

//This implementation uses a MutableList to store each individual stack. When the push() method is called, it checks if the current stack has reached its capacity. If it has, a new stack is created and added to the list of stacks. If the current stack has not reached its capacity, the value is simply added to the current stack.
//The pop() method removes the top element from the current stack and, if the current stack is empty after the pop, it is removed from the list of stacks.
//The popAt(stackIndex: Int) method, removes the top element from the specific stack and return it, it also shifts all the elements of the stacks above the specific stack, one stack down to fill the gap left by the removed stack.
class SetOfStacks(val capacity: Int) {
    private val stacks = mutableListOf<MutableList<Int>>()
    private var currentStack = 0

    fun push(value: Int) {
        if (stacks.isEmpty() || stacks[currentStack].size == capacity) {
            stacks.add(mutableListOf(value))
            currentStack++
        } else {
            stacks[currentStack].add(value)
        }
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
        for (i in stackIndex until currentStack) {
            stacks[i] = stacks[i + 1]
        }
        if (stacks[currentStack].isEmpty()) {
            stacks.removeAt(currentStack)
            currentStack--
        }
        return value
    }
}
