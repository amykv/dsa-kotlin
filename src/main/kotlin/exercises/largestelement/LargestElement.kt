package exercises.largestelement

// Program to find largest element in array

fun main() {
    val numArray = doubleArrayOf(23.4, -34.5, 50.0, 33.5, 55.5, 43.7, 5.7, -66.5)
    var largest = numArray[0]

    for (num in numArray) {
        if (largest < num)
            largest = num
    }

    println("Largest element = %.2f".format(largest))
}