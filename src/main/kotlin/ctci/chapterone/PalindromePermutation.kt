package ctci.chapterone

// 1.4 - page 91
// In Kotlin, given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a
// word of phrase that is the same backwards and forwards. A permutation is a rearrangement of letters.

    fun main(){

        val testCases = listOf("abcba", "abccba", "abcdea", "aaa", "", "a")

        for (testCase in testCases) {
            println("isPermutationOfPalindrome($testCase) = ${isPermutationOfPalindrome(testCase)}")
        }

    }

//    Created a mutable map to store the number of occurrences of each character in the string, and then iterate
//    through the map and check if the number of occurrences of each character is even or if there is at most one
//    character with an odd number of occurrences. This function creates a map to store the number of occurrences of
//    each character in the string, and then iterates through the map checking if there is at most one character
//    with an odd number of occurrences. If there are more than one such characters, the function returns false,
//    indicating that the string is not a permutation of a palindrome. If the function reaches the end of the map
//    without finding more than one character with an odd number of occurrences, it returns true, indicating that
//    the string is a permutation of a palindrome.

    fun isPermutationOfPalindrome(str: String): Boolean {
        val charCounts = mutableMapOf<Char, Int>()
        for (c in str) {
            charCounts[c] = charCounts.getOrDefault(c, 0) + 1
        }

        var hasOddCount = false
        for (count in charCounts.values) {
            if (count % 2 == 1) {
                if (hasOddCount) {
                    return false
                }
                hasOddCount = true
            }
        }

        return true
    }

//The time complexity of this function is O(n), where n is the length of the string, since the function iterates
//through each character in the string once and performs a constant time operation (getting or incrementing the count
//for a character in the map) on each character. The space complexity is also O(n), since the map used to store the
//character counts may contain up to n elements if the string has all unique characters.