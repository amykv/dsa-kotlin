package ctci.chaptereight

// 8.11 - page 136
// Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent), write
// Kotlin code to calculate the number of ways representing n cents.

fun main() {
    val cents = 50
    println("Number of ways to represent $cents cents: ${coinChange(cents)}")
}

//The function takes in a single parameter cents, which represents the total amount of cents we want to calculate the
// number of ways to represent.
//
//The function starts by defining an array coinDenominations that holds the coin denominations, in this case, quarters,
// dimes, nickels, and pennies. We then create an array ways of size cents + 1 with all elements initialized to 0. Set
// the first element of the array to 1, which is the base case representing the number of ways to represent 0 cents,
// which is 1.
//
//Then iterate over each denomination in coinDenominations and for each denomination it starts a nested loop that
// iterates from the current denomination to the total number of cents. For each iteration, update the value in the
// ways array by adding the number of ways to represent the current amount minus the current denomination.
//
//The function then returns the last element of the ways array, which represents the number of ways to represent the
// total number of cents.
fun coinChange(cents: Int): Int {
    val coinDenominations = intArrayOf(25, 10, 5, 1)
    val ways = Array(cents + 1) { 0 }
    ways[0] = 1 // base case: there's 1 way to represent 0 cents

    for (denomination in coinDenominations) {
        for (i in denomination..cents) {
            ways[i] += ways[i - denomination]
        }
    }

    return ways[cents]
}

//The time and space complexity of this solution is O(n*c) where n is the number of coin denominations and c is the
// number of cents. This is because it iterates over all the coin denominations and for each denomination, iterate over
// all the cents.