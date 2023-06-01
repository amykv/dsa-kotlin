package exercises.product

//Instructions
//
//Given a list of integers implement a function which returns the product of all numbers in the list.
//
//Challenge | Solution
//Examples
//
//product(listOf(1, 2)) // 2
//
//product(listOf(1, 2, 4)) // 8
//
//product(listOf(2, 4, 10)) // 80

fun main() {
    println(product(listOf(1, 2))) // 2
    println(product(listOf(1, 2, 4))) // 8
    println(product(listOf(2, 4, 10))) // 80
}

//Function for finding product
fun product(numbers: List<Int>): Int {
    if (numbers.isEmpty()) {
        return 0
    }

    var result = 1
    for (number in numbers) {
        result *= number
    }
    return result
}

//The time complexity of this code is O(n), where n is the length of the input list. This is because the function
//performs a single loop over the elements of the input list, and performs a constant amount of work for each element.
//Therefore, the amount of work performed by the function is proportional to the length of the input list.

//The space complexity of this code is O(1), because the function only uses a constant amount of additional memory
//regardless of the size of the input list.