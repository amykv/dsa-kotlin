package ctci.chapterthree

// 3.1 - page 98
// Describe how you could use a single array to implement three stacks.

fun main() {

    val stack = TripleStack(5)
    stack.push(0, 10)
    stack.push(0, 11)
    stack.push(1, 20)
    stack.push(1, 21)
    stack.push(1, 22)
    stack.push(2, 30)
    stack.push(2, 31)
    println(stack.pop(0))
    println(stack.pop(1))
    println(stack.pop(2))
    println(stack.pop(2))

}

//This class uses an array to store the data for three stacks, and an array of size 3 to keep track of the current
// size of each stack.
//It has functions to push, pop and peek elements from the stack. It has also two additional functions isEmpty()
// and isFull() that check if the stack is empty or full.
//It uses private function indexOfTop which takes the stack number as input, and returns the index of the top
// element of that stack in the underlying array.
//The class has a constructor which takes an integer parameter that sets the capacity of each stack.
//This implementation has a time complexity of O(1) for push, pop and peek operations because it only accesses the
// array at a specific index.
//And it has O(n) space complexity, where n is the total capacity of all three stacks combined.
class TripleStack {
    private val array: IntArray
    private val stackCapacity: Int
    private val sizes = IntArray(3)
    private val numOfStacks = 3

    constructor(stackSize: Int) {
        stackCapacity = stackSize
        array = IntArray(stackSize * numOfStacks)
    }

    fun push(stackNum: Int, value: Int) {
        if (isFull(stackNum)) {
            throw Exception("Stack $stackNum is full")
        }
        sizes[stackNum]++
        array[indexOfTop(stackNum)] = value
    }

    fun pop(stackNum: Int): Int {
        if (isEmpty(stackNum)) {
            throw Exception("Stack $stackNum is empty")
        }
        val topIndex = indexOfTop(stackNum)
        val value = array[topIndex]
        array[topIndex] = 0
        sizes[stackNum]--
        return value
    }

    fun peek(stackNum: Int): Int {
        if (isEmpty(stackNum)) {
            throw Exception("Stack $stackNum is empty")
        }
        return array[indexOfTop(stackNum)]
    }

    fun isEmpty(stackNum: Int): Boolean {
        return sizes[stackNum] == 0
    }

    fun isFull(stackNum: Int): Boolean {
        return sizes[stackNum] == stackCapacity
    }

    private fun indexOfTop(stackNum: Int): Int {
        val offset = stackNum * stackCapacity
        val size = sizes[stackNum]
        return offset + size - 1
    }
}