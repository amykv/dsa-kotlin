package dynamicprogramming.memoization

fun main() {
    val memo = Memoization()
    println("addTo80: " + memo.addTo80(5))
    println("addTo80: " + memo.addTo80(5))
    println("memoizeAddTo80: " + memo.memoizeAddTo80(5))
    println("memoizeAddTo80: " + memo.memoizeAddTo80(5))
    println("memoizeAddTo80: " + memo.memoizeAddTo80(5))
}

class Memoization {
    fun addTo80(n: Int): Int {
        println("Long Time")
        return n + 80
    }

    fun memoizeAddTo80(n: Int): Int {
        if (!cache.containsKey(n)) {
            println("Long Time")
            cache[n] = n + 80
        }
        return cache[n]!!
    }

    companion object {
        var cache = HashMap<Int, Int>()
    }
}