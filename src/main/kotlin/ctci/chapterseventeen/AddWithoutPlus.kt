package ctci.chapterseventeen

// 17.1 - page 186
// Write a function in Kotlin that adds two numbers. You should not use + or any arithmetic operators.

fun main() {
    val a = 5
    val b = 7
    val sum = add(a, b)
    println("The sum of $a and $b is $sum")
}

fun add(a: Int, b: Int): Int {
    // We use bitwise operations to add two numbers without using the + operator.
    // We repeatedly add the carry bit to the sum of the two numbers until there's no carry bit left.
    var sum = a
    var carry = b
    while (carry != 0) {
        // Calculate the sum of the two numbers without considering the carry bit.
        val temp = sum xor carry
        // Calculate the carry bit, which is the result of the binary AND operation between the sum and carry.
        carry = sum and carry shl 1
        // Update the sum to include the carry bit.
        sum = temp
    }
    // Return the final sum.
    return sum
}

//The space complexity of this function is O(1), as it uses only a few variables. The time complexity is O(n), where
// n is the number of bits required to represent the larger of the two input numbers. This is because the while loop
// will iterate at most n times, and each iteration performs a small constant amount of work.
