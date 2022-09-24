package datastructures.arrays.implement

//Vector is Dynamic array
fun main() {
    val myDynamicArray = DynamicArray()
    myDynamicArray.push("Frodo")
    myDynamicArray.push("Sam")
    myDynamicArray.push("Merry")
    myDynamicArray.push("Pippin")
    println("Array length: " + myDynamicArray.length)
    println("Array: " + myDynamicArray.array().contentToString())
    println("Item at index 2: " + myDynamicArray.get(2))
    myDynamicArray.replace(1, "Aragorn")
    println("Array: " + myDynamicArray.array().contentToString())
    myDynamicArray.pop()
    println("Array: " + myDynamicArray.array().contentToString())
    myDynamicArray.delete(1)
    println("Array: " + myDynamicArray.array().contentToString())
    println("Array length: " + myDynamicArray.length)
}

class DynamicArray(
private var array: Array<String?> = arrayOfNulls(1),
private var capacity: Int = 1,
var length: Int = 0
) {
    //Get elements at certain index
    fun get(index: Int): String? {
        return if (index > -1 && index < length) array[index] else "IndexOutOfBounds"
    }

    //Function to add element to end of array
    fun push(string: String) {
        if (length == capacity) {
            val tempArray = arrayOfNulls<String>(2 * capacity)
            for (i in array.indices) {
                tempArray[i] = array[i]
            }
            array = tempArray
            capacity *= 2
        }
        array[length] = string
        length++
    }

    //Function to replace element at certain index
    fun replace(index: Int, value: String) {
        if (index > -1 && index < length)
            array[index] = value
        else
            println("IndexOutOfBounds")
    }

    //Remove last element of array
    fun pop() {
        if (length > 0) {
            length--
        }
    }

    //Delete element at certain index
    fun delete(index: Int) {
        if (index > -1 && index < length) {
            if (index == length - 1) {
                pop()
            } else {
                for (i in index until length) {
                    array[i] = array[i + 1]
                }
                length--
            }
        } else {
            println("IndexOutOfBounds")
        }
    }

    //Get the array
    fun array(): Array<String?> {
        val tempArray = arrayOfNulls<String>(length)
        for (i in 0 until length) {
            tempArray[i] = array[i]
        }
        return tempArray
    }
}