package exercises.checkevenodd

import java.util.*

//Check if a number is even or odd

fun main() {

    val reader = Scanner(System.`in`)

    print("Enter a number: ")
    val num = reader.nextInt()

    if (num % 2 == 0)
        println("$num is even.")
    else
        println("$num is odd.")
}