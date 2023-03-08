package exercises.isomorphicstrings

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters.
// No two characters may map to the same character, but a character may map to itself.
//
//
//
//Example 1:
//
//Input: s = "egg", t = "add"
//Output: true
//
//Example 2:
//
//Input: s = "foo", t = "bar"
//Output: false

fun main() {
    val solution = Solution()
    val char1 = "egg"
    val char2 = "add"
    println(solution.isIsomorphic(char1, char2))

}

//205
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val charMap = mutableMapOf<Char, Char>()

        s.indices.forEach { i ->
            val a = s[i]
            val b = t[i]

            if (a !in charMap) {
                if (b in charMap.values) return false

                charMap[a] = b

            } else if (charMap[a] != b) return false
        }

        return true

    }
}