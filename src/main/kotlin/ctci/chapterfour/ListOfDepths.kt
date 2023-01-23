package ctci.chapterfour

// 4.3 - page 109
// Given a binary tree, design an algorithm in Kotlin which creates a linked list of all the nods at each depth
// (e.g., if you have a tree with depth D, you'll have D linked lists).

fun main() {
    val root = MyTreeNode(1)
    root.left = MyTreeNode(2)
    root.right = MyTreeNode(3)
    root.left?.left = MyTreeNode(4)
    root.left?.right = MyTreeNode(5)
    val linkedLists = createLinkedListsByDepth(root)
    for (list in linkedLists) {
        println(list.joinToString(",") { it.value.toString() })
    }
}

// Necessary to create so when running the test, joinToString method works properly printing results
class MyTreeNode(val value: Int) {
    var left: MyTreeNode? = null
    var right: MyTreeNode? = null
    override fun toString(): String {
        return value.toString()
    }
}

//The function takes the root of the binary tree as input, creates an empty list to store the linked lists, and uses a
// queue to keep track of the nodes to be visited. It starts by adding the root node to the queue, and then in a
// while loop, it continues to poll nodes from the queue and adding the left and right children of each node to the
// queue. It also uses a variable levelSize to keep track of the number of nodes in the current level, and for each
// level it creates an empty list and adds the nodes to it. At the end of the loop, it will return the list containing
// all the lists of nodes at each level.
fun createLinkedListsByDepth(root: MyTreeNode?): List<List<MyTreeNode>> {
    val result = mutableListOf<List<MyTreeNode>>()
    val queue = ArrayDeque<MyTreeNode>()
    if (root != null) queue.add(root)
    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val levelList = mutableListOf<MyTreeNode>()
        for (i in 1..levelSize) {
            val current = queue.removeFirst()
            levelList.add(current)
            current.left?.let { queue.add(it as MyTreeNode) }
            current.right?.let { queue.add(it as MyTreeNode) }
        }
        result.add(levelList)
    }
    return result
}

//The time complexity of this algorithm is O(n), where n is the number of nodes in the tree, as it visits each node
// once. The space complexity is O(n) as well, as it uses a queue to keep track of the nodes to be visited and a
// separate list for each level.