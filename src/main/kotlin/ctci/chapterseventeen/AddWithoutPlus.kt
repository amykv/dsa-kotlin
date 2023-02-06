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
    var x = a
    var y = b
    while (y != 0) {
        val carry = x and y
        x = x xor y
        y = carry shl 1
    }
    return x
}
//The space complexity of this function is O(1), as it uses only a few variables. The time complexity is O(n), where
// n is the number of bits required to represent the larger of the two input numbers. This is because the while loop
// will iterate at most n times, and each iteration performs a small constant amount of work.
