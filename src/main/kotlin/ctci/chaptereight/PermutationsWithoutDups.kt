package ctci.chaptereight

// 8.7 - page 135
// Write a method in Kotlin to compute all the permutations of a string of unique characters.

fun main() {
    val permutations = permutations("abc")
    for (permutation in permutations) {
        println(permutation)
    }
}

//This implementation uses a recursive approach to compute all the permutations of the input string. The base case is
// when the input string has only one character, in which case there is only one possible permutation. For longer
// strings, the method iterates through each character in the string, and for each character, it computes all the
// permutations of the remaining characters by recursively calling the method. Then, it concatenates the current
// character with each of the permutations of the remaining characters, and adds the result to the list of
// permutations. Finally, the method returns the list of permutations.
fun permutations(str: String): List<String> {
    val permutations = mutableListOf<String>()
    if (str.length == 1) {
        permutations.add(str)
        return permutations
    }
    for (i in 0 until str.length) {
        val c = str[i]
        val remaining = str.substring(0, i) + str.substring(i + 1)
        val subPermutations = permutations(remaining)
        for (subPerm in subPermutations) {
            permutations.add(c + subPerm)
        }
    }
    return permutations
}

//The space complexity of the permutations method is O(n!) since it generates all possible permutations of a string,
// which is a total of n! permutations for a string of length n. The time complexity of the method is also O(n!) as
// it uses a backtracking algorithm to generate all permutations, which takes O(n!) time.

// Time complexity of generating all permutations of a string is always O(n!) for any algorithm, as the number of
// permutations is n! and generating each one takes O(n) time.