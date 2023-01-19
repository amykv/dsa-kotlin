package exercises.reversestring

import java.util.*

//Write a function to reverse a string.

fun main() {
    val testString = "Hello World!"
    println("Original string: $testString")
    println("Reversed string: ${reverseString(testString)}")
    // should print "Original string: Hello World!" and "Reversed string: !dlroW olleH"

}

//This implementation uses a stack to store the characters of the input string. It iterates through the characters of
// the input string and pushes them onto the stack. Then, it pops the characters from the stack one by one and appends
// them to a StringBuilder. Finally, it converts the StringBuilder to a string and returns it.
fun reverseString(s: String): String {
    val stack = Stack<Char>()
    for (c in s) {
        stack.push(c)
    }
    val reversed = StringBuilder()
    while (!stack.isEmpty()) {
        reversed.append(stack.pop())
    }
    return reversed.toString()
}

//The time complexity of this function is O(n), where n is the number of characters in the input string.
// This is because it needs to iterate through all the characters of the input string once and then pop them off the
// stack once. The space complexity is also O(n), as it uses a stack to store all the characters of the input string.