package ctci.chaptersixteen

// 16.21 - page 184
// Given two arrays of integers, find a pair of values (one value from each array) that you can swap to give the
// two arrays the same sum.

fun main() {
    val array1 = intArrayOf(4, 1, 2, 1, 1, 2)
    val array2 = intArrayOf(3, 6, 3, 3)
    val targetSum = getTargetSum(array1, array2)
    if (targetSum != null) {
        println("The arrays can be made the same sum by swapping elements with a difference of $targetSum.")
    } else {
        println("No such pair of elements exists.")
    }
}

fun getTargetSum(array1: IntArray, array2: IntArray): Int? {
    val sum1 = array1.sum()
    val sum2 = array2.sum()
    val diff = sum2 - sum1
    if (diff % 2 != 0) {
        return null
    }
    val targetDiff = diff / 2
    val set2 = HashSet<Int>()
    for (num in array2) {
        set2.add(num)
    }
    for (num in array1) {
        if (set2.contains(num + targetDiff)) {
            return targetDiff
        }
    }
    return null
}
//The space complexity of this algorithm is O(n), where n is the size of the larger array. The time complexity is also
// O(n), as we need to loop through both arrays once to find the target sum.