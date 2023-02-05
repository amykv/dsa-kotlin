package ctci.chaptersixteen

// 16.5 - page 181
// Write an algorithm in Kotlin which computes the number of trailing zeros in n factorial

fun main(){
    val n = 20
    println("Number of trailing zeros in $n!: ${countTrailingZeros(n)}")
}

fun countTrailingZeros(n: Int): Int {
    // Initialize a variable to store the count of trailing zeros
    var count = 0

    // Loop through all the numbers from 1 to n
    for (i in 1..n) {
        // Calculate the factorial of i
        var factorial = i
        for (j in i-1 downTo 1) {
            factorial *= j
        }

        // Count the number of trailing zeros in the factorial
        var temp = factorial
        while (temp % 10 == 0) {
            count++
            temp /= 10
        }
    }

    // Return the count of trailing zeros
    return count
}

//The time complexity of this algorithm is O(n) and the space complexity is O(1), since we only use a few variables
// and don't allocate any extra memory.