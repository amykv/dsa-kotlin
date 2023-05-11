package exercises.printinteger

import java.util.*

// How to print an integer entered by user in Kotlin using Scanner

fun main(args: Array<String>) {

    // Should add a try-catch for wrong inputs

    // Creates a reader instance which takes
    // input from standard input - keyboard
    val reader = Scanner(System.`in`)
    print("Enter a number: ")

    // nextInt() reads the next integer from the keyboard
    val integer:Int = reader.nextInt()

    // println() prints the following line to the output screen
    println("You entered: $integer")
}