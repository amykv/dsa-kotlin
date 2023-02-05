package ctci.chaptersixteen

// 16.5 - page 181
// Write an algorithm in Kotlin which computes the number of trailing zeros in n factorial

fun main(){
    val n = 20
    println("Number of trailing zeros in $n!: ${countTrailingZeros(n)}")
}

fun countTrailingZeros(n: Int): Int {
    var count = 0
    for (i in 5..n step 5) {
        var num = i
        while (num % 5 == 0) {
            count++
            num /= 5
        }
    }
    return count
}

//The time complexity of this algorithm is O(n) and the space complexity is O(1), since we only use a few variables
// and don't allocate any extra memory.