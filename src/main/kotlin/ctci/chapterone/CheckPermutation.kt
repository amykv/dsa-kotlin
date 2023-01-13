package ctci.chapterone
// 1.2 - page 90
// In Kotlin given two strings, write a method to decide if one is a permutation of the other.

//To decide if one string is a permutation of another using a hash table in Kotlin, you can create a mutable map to
// store the number of occurrences of each character in the first string, and then iterate through the second string
// and decrement the count for each character in the map. If a character is not in the map or its count is already 0,
// it means that the character is not present in the first string or it appears more times in the second string than
// in the first, so the strings are not permutations of each other.

fun main(){

    val testCases = listOf(
        Pair("abcdef", "fedcba"),
        Pair("abcdea", "aedcba"),
        Pair("aaa", "aaa"),
        Pair("", ""),
        Pair("a", "b")
    )

    for (testCase in testCases) {
        println("isPermutation(${testCase.first}, ${testCase.second}) = ${isPermutation(testCase.first, testCase.second)}")
    }
}

fun isPermutation(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {
        return false
    }

    val charCounts = mutableMapOf<Char, Int>()
    for (c in str1) {
        charCounts[c] = charCounts.getOrDefault(c, 0) + 1
    }

    for (c in str2) {
        val count = charCounts.getOrDefault(c, 0)
        if (count == 0) {
            return false
        }
        charCounts[c] = count - 1
    }

    return true
}

//The time complexity of this function is O(n), where n is the total number of characters in the two strings, since the
// function iterates through each character in the two strings once and performs a constant time operation
// (getting or incrementing the count for a character in the map) on each character. The space complexity is also O(n),
// since the map used to store the character counts may contain up to n elements if both strings have all
// unique characters.