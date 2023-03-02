package exercises.charssentence

// Program that counts how many characters in a sentence.

fun main() {
    print("Enter a sentence: ")
    val sentence = readlnOrNull() ?: ""
    val numChars = sentence.length
    println("The sentence \"$sentence\" contains $numChars characters.")
}
