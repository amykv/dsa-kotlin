package ctci.chapterfive

// 5.1 - page 115
//  You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method in Kotlin to insert M
//  into N such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough space
//  to fit all of M. That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
//  You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.

fun main() {
    val N = 0b1000000_00000000_00000000_00000000 // N in binary
    val M = 0b00000110_00000000_00000000_00000000 // M in binary
    val i = 2
    val j = 31
    val result = insertMIntoN(N, M, i, j)
    println(Integer.toBinaryString(result))
}

// Insertion function
fun insertMIntoN(N: Int, M: Int, i: Int, j: Int): Int {
    val left = (1 shl (j + 1)) - 1
    val right = (1 shl i) - 1
    val mask = left xor right
    val clearedN = N and mask
    val shiftedM = M shl i
    return clearedN or shiftedM
}