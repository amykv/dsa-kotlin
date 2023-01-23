package ctci.chapterfive

// 5.2 - page 116
// Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
// If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR WILL ROBINSON!".

fun main() {
    val testCases = listOf(
        0.5,
        0.25,
        0.125,
        0.75,
        0.1,
        1.5,
        -0.1
    )

    for (tc in testCases) {
        println("Input: $tc, Output: ${printBinaryRepresentation(tc)}")
    }
}

fun printBinaryRepresentation(num: Double): String {
    if (num >= 1 || num <= 0) return "ERROR WILL ROBINSON!"

    val binary = StringBuilder(".")
    var n = num
    while (n > 0) {
        if (binary.length > 32) return "ERROR WILL ROBINSON!"
        val r = n * 2
        if (r >= 1) {
            binary.append("1")
            n = r - 1
        } else {
            binary.append("0")
            n = r
        }
    }
    return binary.toString()
}

//The space complexity of the function printBinaryRepresentation is O(1), because it only uses a constant amount of
// memory to store the StringBuilder, the input number and a few variables.

//The time complexity of the function is O(n), where n is the number of bits needed to represent the input number in
// binary. The while loop in the function iterates until the number becomes 0, and in the worst case scenario, if the
// number can't be represented in 32 characters, the while loop will iterate 32 times.