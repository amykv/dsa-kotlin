package ctci.chapterone
//1.1 - page 90
//In Kotlin, implement an algorithm to determine if a string has all unique characters.

fun main() {

    val testCases = listOf("abcdef", "abcdea", "aaa", "", "a")

    for (testCase in testCases) {
        println("hasUniqueCharacters($testCase) = ${hasUniqueCharacters(testCase)}")
    }


}

// This function iterates through each character in the string and checks if it is already in the set of seen characters.
// If it is, the function returns false, indicating that the string does not have all unique characters.
// If the character is not in the set, it is added to the set. If the function reaches the end of the string without
// finding any duplicate characters, it returns true, indicating that the string has all unique characters.

fun hasUniqueCharacters(str: String): Boolean {
    val seenCharacters = mutableSetOf<Char>()

    for (c in str) {
        if (c in seenCharacters) {
            return false
        }
        seenCharacters.add(c)
    }

    return true
}