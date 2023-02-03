package ctci.chaptersixteen

// 16.2 - page 181
// In Kotlin, design a method to find the frequency of occurrences of any give word in a book. What if we were running
// this algorithm multiple times?

fun main() {
    val book = "This is a book. This book has many words in it. This is an example book. Not too many words here."
    val word = "this"
    val frequency = frequencyOfWords(book, word)
    println("The frequency of '$word' in the book is $frequency")

}

//method to find the frequency of occurrences of a word in a book by using the split method to divide the book into
// words, and then using a Map to store the frequency of each word.
fun frequencyOfWords(book: String, word: String): Int {
    val words = book.split(" ")
    val frequencyMap = mutableMapOf<String, Int>()
    for (w in words) {
        val lowerCaseWord = w.toLowerCase()
        frequencyMap[lowerCaseWord] = frequencyMap.getOrDefault(lowerCaseWord, 0) + 1
    }
    return frequencyMap[word.toLowerCase()] ?: 0
}

//running this algorithm multiple times, it would be more efficient to preprocess the book into a data structure that
// allows for fast searching of words, such as a Trie or a HashMap. Then, for each subsequent query, you can simply
// look up the frequency of the word in the data structure, which would have a time complexity of O(1).