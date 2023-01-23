package ctci.chapterfour

// 4.5 - page 110
// In Kotlin, implement a function to check if a binary tree is a binary search tree.

fun main() {
    val root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)
    val result = isBST(root)
    println(result)
}

//This function uses a recursive approach where it starts from the root node, and for each node, it checks if the value
// of the node is greater than or equal to the values of all the nodes in its left subtree, and less than or equal to
// the values of all the nodes in its right subtree. It does this by passing the minimum and maximum values for the
// subtree as parameters to the recursive function calls.

//The first function, isBST(root: TreeNode?), calls the second function isBST(root: TreeNode?, min: Int, max: Int) and
// passes the root of the tree and the minimum and maximum values (Int.MIN_VALUE and Int.MAX_VALUE) as parameters.

fun isBST(root: TreeNode?): Boolean {
    return isBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun isBST(root: TreeNode?, min: Int, max: Int): Boolean {
    if (root == null) return true
    if (root.value < min || root.value > max) return false
    return isBST(root.left, min, root.value) && isBST(root.right, root.value, max)
}

//This algorithm has a time complexity of O(n) because it visits every node once.