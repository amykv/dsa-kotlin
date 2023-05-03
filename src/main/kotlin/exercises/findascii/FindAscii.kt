package exercises.findascii

//Find ASCII value of a character
fun main() {

    //Set values
    val c = 'a'
    val ascii = c.code //.toInt() is deprecated

    println("The ASCII value of $c is: $ascii")
}