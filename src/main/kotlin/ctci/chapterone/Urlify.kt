package ctci.chapterone

// 1.3 - page 90
// In Kotlin, write a method to replace all spaces in a string with '%20'. You may assume that the string has
// sufficient space at the end to hold the additional characters, and that you are given the "true" length
// of the string.

fun main(){

    val testCases = listOf(
        Pair("Hello, world!", 13),
        Pair("This is a test.", 14),
        Pair("", 0),
        Pair("    ", 4)
    )

    for (testCase in testCases) {
        val str = testCase.first
        val trueLength = testCase.second
        println("replaceSpaces($str, $trueLength) = ${replaceSpaces(str, trueLength)}")
    }
}

//To replace all spaces in a string with '%20' in Kotlin, you can use a mutable list to store the characters of the
// modified string and iterate through the original string from the end to the beginning. For each character, if it is
// a space, you can append '0', '2', and '%' to the list in that order. If it is not a space, you can append the
// character to the list as is.

fun replaceSpaces(str: String, trueLength: Int): String {
    val modifiedChars = mutableListOf<Char>()

    for (i in trueLength - 1 downTo 0) {
        val c = str[i]
        if (c == ' ') {
            modifiedChars += '0'
            modifiedChars += '2'
            modifiedChars += '%'
        } else {
            modifiedChars += c
        }
    }

    return modifiedChars.reversed().joinToString("")
}

//The time complexity of this function is O(n), where n is the true length of the string, since the function iterates
// through each character in the string once. The space complexity is also O(n), since the list used to store the
// modified characters may contain up to n elements if the string has no spaces.