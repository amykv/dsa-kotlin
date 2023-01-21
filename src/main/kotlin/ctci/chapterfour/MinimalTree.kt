package ctci.chapterfour

// 4.2 - page 109
// Given a sorted (increasing order) array with unique integer elements, write an algorithm in Kotlin to create a binary
// search tree with minimal height.

fun main() {

}


//One way to create a binary search tree with minimal height from a sorted array is to use a technique called
// "divide and conquer". The idea is to divide the array in half, take the middle element as the root of the tree,
// and recursively build the left and right subtrees using the elements to the left and right of the middle
// element respectively.

//This function takes an array of integers, and the start and end indices of the subarray to be used as input. It
// calculates the middle index of the subarray, creates a new TreeNode with the value at that index, and recursively
// calls itself to build the left and right subtrees of the node, passing the appropriate subarrays as input.

class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

fun createMinimalBST(arr: IntArray, start: Int, end: Int): TreeNode? {
    if (start > end) return null

    val mid = (start + end) / 2
    val node = TreeNode(arr[mid])
    node.left = createMinimalBST(arr, start, mid - 1)
    node.right = createMinimalBST(arr, mid + 1, end)
    return node
}