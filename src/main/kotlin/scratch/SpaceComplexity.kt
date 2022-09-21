package scratch

fun main(){
    saySomething(4) // Prints the string Something! 5 times, O(1)

}

fun saySomething(count : Int) {
    for (i in 0..count)
        println("Something!")
}