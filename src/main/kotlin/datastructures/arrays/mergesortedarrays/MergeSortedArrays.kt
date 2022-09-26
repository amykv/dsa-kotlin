package datastructures.arrays.mergesortedarrays

fun main() {

    val mergedArray = mergeSortArr(intArrayOf(0, 4, 5, 22), intArrayOf(1, 7, 12))
    println(mergedArray.contentToString())

}

//Function for merging sorted array.
//Passes two IntArray parameters. Returns IntArray
fun mergeSortArr(array1: IntArray, array2: IntArray) : IntArray {
    var i = 0
    var j = 0
    var k = 0

    val mergedArray = IntArray(array1.size + array2.size)

    while (i < array1.size && j < array2.size) {
        if (array1[i] < array2[j]) {
            mergedArray[k] = array1[i]
            i++
        } else {
            mergedArray[k] = array2[j]
            j++
        }
        k++
    }

    while (i < array1.size) {
        mergedArray[k] = array1[i]
        i++
        k++
    }

    while (j < array2.size) {
        mergedArray[k] = array2[j]
        j++
        k++
    }

    return mergedArray
}