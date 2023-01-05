package ctci.chapterone

// 1.6 - page 91
//In Kotlin, implement a method to perform basic string compression using the counts of repeated characters.
// For example, the string "aabcccccaaa" would become a2b1c5a3. If the compressed string would not become smaller
// than the original string, the method should return the original string. Assume only uppercase and lowercase
// letters will be used.

// To perform basic string compression using the counts of repeated characters in Kotlin, you can iterate through the
// string and keep track of the current character and its count. If the current character is different from the
// previous character, you can append the character and its count to the result string.

fun main() {

    val testCases = listOf(
        "aabcccccaaa",
        "abcdefg",
        "aabbcc",
        "aaaaaabbbbbccccc",
        "abcd",
        "abbbbbbbbbbbbbbbbbbc"
    )

    for (testcase in testCases) {
        println("Compression($testcase) = ${compressString(testcase)}")
    }

}

fun compressString(str: String): String {
    val result = StringBuilder()
    var currentChar = str[0]
    var currentCount = 1
    for (i in 1 until str.length) {
        val c = str[i]
        if (c == currentChar) {
            currentCount++
        } else {
            result.append(currentChar).append(currentCount)
            currentChar = c
            currentCount = 1
        }
    }
    result.append(currentChar).append(currentCount)

    return if (result.length < str.length) result.toString() else str
}

//The time complexity of this function is O(n), where n is the length of the string, since the function iterates
// through each character in the string once. The space complexity is also O(n), since the result string may
// contain up to n characters.