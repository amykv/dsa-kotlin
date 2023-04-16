package scratch

//Scratch code for running examples in fun main().

fun main(){
    //saySomething(4) // Prints the string Something! 5 times, O(1)
    val arr1 = arrayOf(1, 2, 3, 4, 5)
    val arr2 = arrayOf(7, 8, 9, 10, 5)

    //findSimilar(arr1, arr2)

}

fun saySomething(count : Int) {
    for (i in 0..count)
        println("Something!")
}

//Given 2 arrays, create a function that lets user know (true/false) whether two arrays contain any similar elements
//Example
// val firstArr = arrayOf(1, 2, 3, 4, 5)
// val secondArr = arrayOf(7, 8, 9, 10, 5)
// Should return true

//Comparing two arrays, likely two for loops, Big O(n^2) most likely. Probably not most efficient.
fun  findSimilar(firstArr: Array<Int>, secondArr: Array<Int> ) {
    for (cursor1 in firstArr.indices){
        for (cursor2 in secondArr.indices){
            if (firstArr[cursor1] == secondArr[cursor2]){
                println("True")
            }
            }
        }
    println("False")
    }
