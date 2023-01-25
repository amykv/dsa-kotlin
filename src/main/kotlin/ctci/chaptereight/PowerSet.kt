package ctci.chaptereight

// 8.4 - page 135
// Write a method in Kotlin to return all subsets of a set.

fun main() {
    val set = setOf(1, 2, 3)
    val subsets = getSubsets(set)
    println("All subsets of $set:")
    for (subset in subsets) {
        println(subset)
    }
}

// A recursive approach known as the "power set" algorithm. The basic idea is to start with the empty set and
// then, for each element in the original set, add it to all existing subsets and create new subsets that include only
// that element.

//The method starts by creating an empty list subsets and adding the empty set to it. Then, it iterates over each
// element in the input set and for each element, it creates new subsets by adding that element to each existing
// subset. These new subsets are added to the subsets list. Finally, it returns the list of subsets.
fun getSubsets(set: Set<Int>): List<Set<Int>> {
    val subsets = mutableListOf<Set<Int>>()
    subsets.add(emptySet())

    for (element in set) {
        val newSubsets = mutableListOf<Set<Int>>()
        for (subset in subsets) {
            newSubsets.add(subset + element)
        }
        subsets.addAll(newSubsets)
    }

    return subsets
}

//It's important to notice that the time complexity for this algorithm is O(2^n), as for each element in the set, it
// generates all subsets that contains it or not. Also the space complexity is O(2^n) because it's storing all
// subsets in the list.