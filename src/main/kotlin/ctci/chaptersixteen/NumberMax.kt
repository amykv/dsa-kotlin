package ctci.chaptersixteen

// 16.7 - page 181
// In Kotlin, write a method that finds the maximum of two numbers. You should not use if-else or any other
// comparison operator.

fun main() {
    val a = 5
    val b = 10
    println("Max of $a and $b is ${max(a, b)}")
}

//This code uses the bitwise right shift operator shr and the bitwise and operator and to perform the comparison.
// The expression c shr 31 will either return 0 or 1, depending on the sign of c. If c is negative, meaning a is less
// than b, then k will be 1. In that case, the expression a - k * c will be equal to b. If c is non-negative,
// meaning a is greater than or equal to b, then k will be 0, and the expression a - k * c will be equal to a.
fun max(a: Int, b: Int): Int {
    val c = a - b
    val k = c shr 31 and 1
    return a - k * c
}

//The time complexity of this method is O(1) since it only performs simple arithmetic operations and bitwise
// operations. The space complexity is also O(1), as it only uses a few variables.