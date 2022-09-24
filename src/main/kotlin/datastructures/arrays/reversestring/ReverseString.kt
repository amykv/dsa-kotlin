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

fun reverseStr(str: String) : String {
    var result = ""
    //Need the -1
    for (i in str.length - 1 downTo 0) {
        result += str[i]
    }
    return result
}