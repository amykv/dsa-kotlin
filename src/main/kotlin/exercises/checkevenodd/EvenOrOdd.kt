package exercises.checkevenodd

import java.util.*
//Check if a number is even or odd

fun main() {

    val reader = Scanner(System.`in`)

    try {
    print("Enter a number: ")
    val num = reader.nextInt()

        if (num % 2 == 0)
            println("$num is even.")
        else
            println("$num is odd.")
    } catch (e: InputMismatchException) {
        println("Enter a valid number. Program will close now.")
    }
}