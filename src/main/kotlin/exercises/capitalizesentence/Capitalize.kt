package exercises.capitalizesentence
//Program to capitalize the first letter in each word

fun main() {
    val words = "Here are some words for testing"
    println(capitalizeSentence(words))
}
// Iterative solution
    private fun capitalizeSentence(str: String): String {
        val words = mutableListOf<String>()

    // Split each word by space
        str.split(" ").forEach {
            words.add(it[0].uppercase() + it.substring(1))
        }
        return words.joinToString(" ")
    }