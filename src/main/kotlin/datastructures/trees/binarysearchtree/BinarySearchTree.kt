package datastructures.trees.binarysearchtree

fun main() {
    val bst = BinarySearchTree()
    bst.insert(19)
    bst.insert(32)
    bst.insert(50)
    bst.insert(25)
    bst.insert(188)
    bst.insert(11)
    bst.insert(2)
    println("BFS: " + bst.breadthFirstSearch())
    println("Look for 25: " + bst.lookup(25))
    val queue = ArrayList<Node?>()
    queue.add(bst.root)
    println("BFS Recursive: " + bst.breadthFirstSearchRecursive(queue, ArrayList()))
    println("DFS inOrder: " + bst.DFSInOrder())
    println("DFS preOrder: " + bst.DFSPreOrder())
    println("DFS postOrder: " + bst.DFSPostOrder())
    bst.remove(20)
    println("Look for 25 after removing 25: " + bst.lookup(25))
}

class BinarySearchTree {
    var root: Node? = null

    // insert
    fun insert(value: Int) {
        val newNode = Node(value)
        if (this.root == null) {
            this.root = newNode
        } else {
            var current = this.root
            while (true) {
                // right
                if (current!!.value < value) {
                    if (current.right != null) {
                        current = current.right
                    } else {
                        current.right = newNode
                        break
                    }
                    // left
                } else {
                    if (current.left != null) {
                        current = current.left
                    } else {
                        current.left = newNode
                        break
                    }
                }
            }
        }
    }

    // lookup
    fun lookup(value: Int): Boolean {
        var current = this.root
        while (current != null) {
            current = when {
                current.value > value -> {
                    current.left
                }
                current.value < value -> {
                    current.right
                }
                else -> {
                    return true
                }
            }
        }
        return false
    }

    //remove
    fun remove(value: Int) {
        if (this.root == null) {
            return
        }
        var current = this.root
        var parentNode: Node? = null
        // while current is not null
        while (current != null) {
            when {
                value < current.value -> {
                    // go left
                    parentNode = current
                    current = current.left
                }
                value > current.value -> {
                    // go right
                    parentNode = current
                    current = current.right
                }
                else -> {
                    // Option 1: NO RIGHT CHILD            // Child means the child of current Node
                    if (current.right == null) {
                        // if parentNode is null means delete the root node
                        if (parentNode == null) {
                            this.root = current.left
                        } else {
                            // if current < parent, make current left child a left child of parent
                            if (current.value < parentNode.value) {
                                parentNode.left = current.left
                            } else if (current.value > parentNode.value) {
                                parentNode.right = current.left
                            }
                        }
                    } else if (current.right!!.left == null) {
                        if (parentNode == null) {
                            this.root = current.right
                        } else {
                            // if current < parent, make current's right child a left child of parent
                            if (current.value < parentNode.value) {
                                parentNode.left = current.right
                            } else if (current.value > parentNode.value) {
                                parentNode.right = current.right
                            }
                        }
                    } else {
                        if (parentNode == null) {
                            // save reference of left and right nodes of the root
                            val leftNode = this.root!!.left
                            val rightNode = this.root!!.right
                            // root.right.left node becomes new root
                            this.root = current.right!!.left
                            rightNode!!.left = rightNode.left!!.right
                            // set back the saved reference of left and right nodes of root.
                            this.root!!.left = leftNode
                            this.root!!.right = rightNode
                        } else {
                            if (current.value < parentNode.value) {
                                parentNode.left = current.right!!.left
                            } else if (current.value > parentNode.value) {
                                parentNode.right = current.right!!.left
                            }
                        }
                    }
                    return
                }
            }
        }
    }

    // Breadth first search algorithm
    fun breadthFirstSearch(): ArrayList<Int> {
        var currentNode = this.root
        val resultArray = ArrayList<Int>()
        val queue = ArrayList<Node?>()
        queue.add(currentNode)
        while (queue.size > 0) {
            currentNode = queue.removeAt(0)
            resultArray.add(currentNode!!.value)
            if (currentNode.left != null) {
                queue.add(currentNode.left)
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right)
            }
        }
        return resultArray
    }

    // Breadth first search recursive algorithm
    fun breadthFirstSearchRecursive(
        queue: ArrayList<Node?>,
        resultArray: ArrayList<Int>
    ): ArrayList<Int> {
        if (queue.size == 0) {
            return resultArray
        }
        val currentNode = queue.removeAt(0)
        resultArray.add(currentNode!!.value)
        if (currentNode.left != null) {
            queue.add(currentNode.left)
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right)
        }
        return breadthFirstSearchRecursive(queue, resultArray)
    }

    // Depth First Search algorithm
    fun DFSInOrder(): ArrayList<Int?> {
        val answer = ArrayList<Int?>()
        return traverseInOrder(this.root, answer)
    }

    fun DFSPreOrder(): ArrayList<Int?> {
        val answer = ArrayList<Int?>()
        return traversePreOrder(this.root, answer)
    }

    fun DFSPostOrder(): ArrayList<Int?> {
        val answer = ArrayList<Int?>()
        return traversePostOrder(this.root, answer)
    }

    private fun traverseInOrder(node: Node?, array: ArrayList<Int?>): ArrayList<Int?> {
        if (node?.left != null) {
            traverseInOrder(node.left, array)
        }
        array.add(node?.value)
        if (node?.right != null) {
            traverseInOrder(node.right, array)
        }
        return array
    }

    private fun traversePreOrder(node: Node?, array: ArrayList<Int?>): ArrayList<Int?> {
        array.add(node?.value)
        if (node?.left != null) {
            traversePreOrder(node.left, array)
        }
        if (node?.right != null) {
            traversePreOrder(node.right, array)
        }
        return array
    }

    private fun traversePostOrder(node: Node?, array: ArrayList<Int?>): ArrayList<Int?> {
        if (node?.left != null) {
            traversePostOrder(node.left, array)
        }
        if (node?.right != null) {
            traversePostOrder(node.right, array)
        }
        array.add(node?.value)
        return array
    }
}

//Node class
class Node(var value: Int) {
    var right: Node? = null
    var left: Node? = null
}