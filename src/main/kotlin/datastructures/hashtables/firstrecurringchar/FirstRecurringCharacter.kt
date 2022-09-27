package datastructures.hashtables.firstrecurringchar

//Print the first recurring element in an array
// Example: Given an array = [1, 2, 4, 1, 2, 4, 5, 5]
// Should return 1
fun main() {
    val first = firstRecurringChar(intArrayOf(1, 2, 5, 1, 2, 5, 3, 3, 7, 8, 3, 7))
    val wrong = firstRecurringChar(intArrayOf(3, 5, 7, 8))
    println(first)
    println(wrong) // returns null

}

fun firstRecurringChar(array: IntArray) : Int? {
    val hashSet = HashSet<Int>()
    for (element in array) {
        if (hashSet.contains(element)) {
            return element
        } else {
            hashSet.add(element)
        }
    }
    return null
}