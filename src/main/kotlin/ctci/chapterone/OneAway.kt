package ctci.chapterone

// 1.5 - page 91
// There are three types of edits that can be performed on strings: insert a character, remove a character, or replace
// a character. Given two strings, write a function in Kotlin to check if they are one edit or zero edits away.

// Can compare the lengths of the strings and perform different actions depending on whether the strings have the
// same length or not.

//If the strings have the same length, you can iterate through the strings and count the number of characters that are
// different. If the number of differences is greater than 1, the strings are more than one edit away. If the number
// of differences is 1, the strings are one edit away. If the number of differences is 0, the strings are zero
// edits away.

//If the strings have different lengths, you can iterate through the shorter string and count the number of characters
// that are different from the corresponding characters in the longer string. If the number of differences is greater
// than 1, the strings are more than one edit away. If the number of differences is 1, the strings are one edit away.
// If the number of differences is 0, the strings are zero edits away.

fun main() {

    val testCases = listOf(
        Pair("abcdef", "abcdef"),
        Pair("abcdef", "abcdeg"),
        Pair("abcdef", "abcdfe"),
        Pair("abcdef", "abcef"),
        Pair("abcdef", "abcf"),
        Pair("abcdef", "abcd"),
        Pair("abcdef", "bcdfe"),
        Pair("abcdef", "abcdefg"),
        Pair("abcdef", "abcdefgh")
    )

    for (testCase in testCases) {
        val str1 = testCase.first
        val str2 = testCase.second
        println("isOneEditAway($str1, $str2) = ${isOneEditAway(str1, str2)}")
    }
}

//This function first checks if the difference in length between the strings is more than 1, in which case the strings
// are more than one edit away. Then it determines the shorter and longer strings, and iterates through them comparing
// the characters. If a difference is found, found, the difference count is incremented. If the difference count is
// more than 1, the function returns false, indicating that the strings are more than one edit away. If the shorter
// string has the same length as the longer string, both indices are incremented. Otherwise, only the index for the
// longer string is incremented. Finally, the function returns true if the difference count is less than or equal to 1,
// indicating that the strings are one edit or zero edits away.

fun isOneEditAway(str1: String, str2: String): Boolean {
    val lengthDifference = str1.length - str2.length
    if (lengthDifference < -1 || lengthDifference > 1) {
        return false
    }

    val shorter = if (str1.length < str2.length) str1 else str2
    val longer = if (str1.length < str2.length) str2 else str1
    var differenceCount = 0
    var i = 0
    var j = 0
    while (i < shorter.length && j < longer.length) {
        if (shorter[i] != longer[j]) {
            differenceCount++
            if (differenceCount > 1) {
                return false
            }
            if (shorter.length == longer.length) {
                i++
            }
        } else {
            i++
        }
        j++
    }

    return differenceCount <= 1
}