package exercises.arraymultiplytwo

// Given an array of elements such as [1,2,3,4] Write a function in Kotlin that returns a new array where each
// element is multiplied by 2 - [2,4,6,8]

fun main() {
    val testArray = intArrayOf(1,2,3,4)
    println("Original Array: ${testArray.contentToString()}")
    val newArray = doubleArray(testArray)
    println("Doubled Array: ${newArray.contentToString()}")
    // should print "Original Array: [1, 2, 3, 4]" and "Doubled Array: [2, 4, 6, 8]"

}

//This implementation uses a for loop to iterate through each element of the input array, it multiplies each element
// by 2 and stores it back in the same array. Finally, it returns the same array with all elements multiplied by 2.
fun doubleArray(arr: IntArray): IntArray {
    for (i in arr.indices) {
        arr[i] = arr[i] * 2
    }
    return arr
}

//The time complexity of this function is O(n), where n is the number of elements in the input array. This is because
// it needs to iterate through all the elements of the input array once and perform a constant time multiplication
// operation on each element. The space complexity is O(1), as it modifies the input array in place and does not use
// any additional memory.