package ctci.chapterfour

// 4.1 - page 109
// Given a directed graph and two nodes (S and E), design an algorithm in Kotlin to find out whether there is a
// route from S to E.

fun main () {

    val node1 = Node(1, mutableListOf())
    val node2 = Node(2, mutableListOf())
    val node3 = Node(3, mutableListOf())
    val node4 = Node(4, mutableListOf())
    val node5 = Node(5, mutableListOf())
    val node6 = Node(6, mutableListOf())

    node1.edges += node2
    node1.edges += node3
    node2.edges += node4
    node3.edges += node5
    node4.edges += node6
    node5.edges += node6

    val start = node1
    val end = node6
    val result = hasRoute(start, end)

    println("There is a route from $start to $end: $result")

}

// Node class
class Node(val value: Int, val edges: MutableList<Node>) {
    override fun toString(): String {
        return "Node($value)"
    }
}


//This function takes two arguments, a start node and an end node, and returns a boolean value indicating whether
// there is a route from the start node to the end node.

//The algorithm starts by adding the start node to a queue and creating an empty set to keep track of the visited
// nodes. Then, it iterates over the queue while it's not empty. At each iteration, it removes the first node from
// the queue and marks it as visited. If the current node is the end node, the function returns true indicating
// that there is a route. If not, it iterates over the edges of the current node and adds any unvisited neighbor
// to the queue.
fun hasRoute(start: Node, end: Node): Boolean {
    val queue = mutableListOf(start)
    val visited = mutableSetOf<Node>()

    while (queue.isNotEmpty()) {
        val current = queue.removeAt(0)
        visited.add(current)

        if (current == end) {
            return true
        }

        for (neighbor in current.edges) {
            if (neighbor !in visited) {
                queue.add(neighbor)
            }
        }
    }

    return false
}

//The time complexity of this algorithm is O(V + E) where V is the number of vertices and E is the number of edges
// in the graph, as it visits each vertex and edge once. The space complexity is O(V) as it uses a queue and a set
// to keep track of the visited nodes.