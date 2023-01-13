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

//The Big O complexity of the hasUniqueCharacters function is O(n), where n is the length of the string. This is because
// the function iterates through each character in the string once and performs a constant time operation
// (checking if the character is in the set and adding it to the set if it is not) on each character.

//In general, the time complexity of a loop that iterates through a collection of size n is O(n). Therefore, the time
// complexity of the hasUniqueCharacters function is linear in the size of the input string.

//Note that the space complexity of the hasUniqueCharacters function is also O(n), since the set used to store the seen
// characters may contain up to n elements if the string has all unique characters.


// The function below is similar to the one above, using hash tables. A Map is a Hash Table.
fun hasUniqueCharactersHash(str: String): Boolean {
    val seenCharacters = mutableMapOf<Char, Unit>()

    for (c in str) {
        if (c in seenCharacters) {
            return false
        }
        seenCharacters[c] = Unit
    }
    return true
}