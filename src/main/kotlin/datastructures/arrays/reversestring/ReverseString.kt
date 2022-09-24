package datastructures.arrays.reversestring


//Creating a function to reverse a string
//"Welcome to Middle-Earth"
//"htraE-elddiM ot emocleW

fun main() {
    var myStr = "Welcome to Middle-Earth"
    val myStrTwo = "For Frodo!"
    myStr = reverseStr(myStr)
    println(myStr)
    //Built-in reverse function for strings
    println(myStrTwo.reversed())

}

///Function to reverse the string.
fun reverseStr(str: String) : String {
    var result = ""
    try {
        //Need the -1 since string length starts at 0.
        for (i in str.length - 1 downTo 0) {
            result += str[i]
        }
    } catch (e: StringIndexOutOfBoundsException) {
        println("Error - StringIndexOutOfBounds")
    }
    return result
}