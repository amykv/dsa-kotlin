package ctci.chapterten

// 10.2 - page 150
// Write a method in Kotlin to sort an array of strings so that all the anagrams are next to each other.

fun main() {
    val words = arrayOf("tab", "bat", "cat", "act", "tac")
    val words2 = arrayOf("tea", "eat", "car", "arc", "dog")
    sortAnagrams(words)
    sortAnagrams(words2)
    val result = words.joinToString(" ")
    val result2 = words2.joinToString(" ")
    println(result)
    println(result2)
}

fun sortAnagrams(strs: Array<String>): Int {
    strs.sortWith(Comparator { a, b ->
        val aSorted = a.toList().sorted().joinToString("")
        val bSorted = b.toList().sorted().joinToString("")
        return@Comparator aSorted.compareTo(bSorted)
    })
    return 0
}
