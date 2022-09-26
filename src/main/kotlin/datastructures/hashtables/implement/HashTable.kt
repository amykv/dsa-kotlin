package datastructures.hashtables.implement

import java.util.*

fun main() {
    //50 is item spaces in table.
    val hashTable = HashTable(50)
    hashTable["Indiana"] = 1400
    hashTable["Nevada"] = 1700
    println("Value for key Indiana: " + hashTable["Indiana"])
    println("Value for key Nevada: " + hashTable["Nevada"])
    println("List of keys: " + hashTable.keys().contentToString())
}

//KeyValue, contains String for key/name and Int for value/id
//Needed for HashTable
data class KeyValue(val key: String, val value: Int)

class HashTable(size: Int) {
    private var data: Array<ArrayList<KeyValue>?> = arrayOfNulls<ArrayList<KeyValue>?>(size)
    private var currentLength: Int = 0

    private fun _hash(key: String): Int {
        var hash = 0
        for (i in key.indices) {
            hash = (hash + key.codePointAt(i) * i) % data.size
        }
        return hash
    }

    operator fun set(key: String, value: Int) {
        val address = _hash(key)
        if (data[address] == null) {
            val arrayAtAddress = ArrayList<KeyValue>()
            data[address] = arrayAtAddress
            currentLength++
        }
        val pair = KeyValue(key, value)
        data[address]?.add(pair)
    }

    operator fun get(key: String): Int? {
        val address = _hash(key)
        val bucket = data[address]
        if (bucket != null) {
            for (keyValue in bucket) {
                if (keyValue.key == key) {
                    return keyValue.value
                }
            }
        }
        return null
    }

    fun keys(): Array<String?> {
        val bucket = data
        val keysArray = arrayOfNulls<String>(currentLength)
        var count = 0
        for (keyValues in bucket) {
            if (keyValues != null) {
                keysArray[count] = keyValues[0].key
                count++
            }
        }
        return keysArray
    }
}