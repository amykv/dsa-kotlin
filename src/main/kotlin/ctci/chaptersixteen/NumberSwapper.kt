package ctci.chaptersixteen

// 16.1 - page 181
// In Kotlin, write a function tos wap swap two numbers in place (that is, without temporary variables).
// Hints: #491, #715, #736

fun main() {
    val (a, b) = Pair(10, 20)
    val (c, d) = swap(a, b)
    println("a = $a, b = $b, c = $c, d = $d")
}

//This function uses the XOR bitwise operator to perform the swap. The XOR operator returns 1 if exactly one of its
// operands is 1, and 0 otherwise. By XORing a value with itself, it becomes 0. By XORing a value with 0, it remains
// unchanged. So in this function, the first XOR operation stores the sum of a and b in a, and the second XOR
// operation restores b to its original value. Finally, the third XOR operation restores a to its original value.
fun swap(a: Int, b: Int): Pair<Int, Int> {
    var a = a
    var b = b
    a = a xor b
    b = a xor b
    a = a xor b
    return Pair(a, b)
}