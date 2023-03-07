package exercises.issubsequence

/*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the
characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence
of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false*/

fun main() {
    val solution = Solution()
    val myString1 = "abc"
    val myString2 = "ahbgdc"
    println(solution.isSubsequence(myString1, myString2))

}

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var k = 0

        while (i < s.length && k < t.length) {
            if (s[i] == t[k]) i++
            k++
        }

        return i == s.length
    }
}
