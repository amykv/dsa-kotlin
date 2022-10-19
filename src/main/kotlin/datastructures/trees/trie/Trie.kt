package datastructures.trees.trie

fun main() {
    val trie = Trie()
    trie.insert("cooling")
    trie.insert("cool")
    println(trie.root.children['c']!!.children['e']?.children)
    println(trie.delete("cool"))
    println(trie.findWord("cool"))
    println(trie.root.children['c']!!.children['o']?.children)
}

class Trie {
    val root = Node()

    // insert
    fun insert(string: String) {
        var current: Node? = root
        for (ch in string.toCharArray()) {
            current!!.children.putIfAbsent(ch, Node())
            current = current.children[ch]
        }
        current!!.isWord = true
    }

    // findWord
    fun findWord(string: String): Boolean {
        var current: Node? = root
        for (ch in string.toCharArray()) {
            current = if (current!!.children.containsKey(ch)) {
                current.children[ch]
            } else {
                return false
            }
        }
        return current!!.isWord
    }

    // delete
    fun delete(word: String): Boolean {
        var current: Node? = root
        var deleteAfter: Node? = root
        var ch1 = word[0]
        for (i in word.indices) {
            val ch = word[i]
            if (current!!.children.containsKey(ch)) {
                current = current.children[ch]
                if (current!!.children.size > 1) {
                    deleteAfter = current
                    ch1 = word[i + 1]
                }
            } else {
                return false
            }
        }
        if (current!!.children.isEmpty()) {
            deleteAfter!!.children.remove(ch1)
            return true
        }
        return false
    }
}

//Node data class
data class Node(var children: HashMap<Char, Node> = HashMap(), var isWord: Boolean = false)
