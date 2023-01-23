package ctci.chapterfour

// 4.4 - page 109
// In Kotlin, implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced
// tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    val result = isBalanced(root)
    println(result)
}

fun isBalanced(root: TreeNode?): Boolean {
    return checkHeight(root) != -1
}

//The isBalanced function calls the checkHeight function, passing the root node of the tree as the parameter. The
// checkHeight function recursively traverses the tree, starting from the root node, and returns -1 if the tree is not
// balanced, otherwise it returns the height of the tree.

//This function uses a bottom-up approach, where it starts from the leaves of the tree and works its way up. It
// recursively checks the height of the left and right subtrees of each node, and if the difference in height between
// the left and right subtrees is greater than one, it returns -1. If the difference is less than or equal to one,
// it returns the height of the tree.

//In the isBalanced function, if the checkHeight function returns -1, the tree is not balanced, and isBalanced
// function returns false. Otherwise, the tree is balanced, and isBalanced function returns true.

fun checkHeight(root: TreeNode?): Int {
    if (root == null) return 0

    val leftHeight = checkHeight(root.left)
    if (leftHeight == -1) return -1

    val rightHeight = checkHeight(root.right)
    if (rightHeight == -1) return -1

    val heightDiff = Math.abs(leftHeight - rightHeight)
    if (heightDiff > 1) return -1

    return Math.max(leftHeight, rightHeight) + 1
}

// This algorithm has a time complexity of O(n) because it visits every node once.