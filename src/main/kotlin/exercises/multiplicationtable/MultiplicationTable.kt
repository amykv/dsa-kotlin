package exercises.multiplicationtable

// Program to generate multiplication table
fun main() {
    val num = 5

    for (i in 1..10) {
        val product = num * i
        println("$num * $i = $product")
    }
}