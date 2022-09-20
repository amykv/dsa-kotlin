package scratch

//Kotlin file to run some test scratch code

//Array of strings
val frodo = arrayOf("Aragorn", "Boromir", "Frodo", "Sam", "Legolas", "Gimli", "Gandalf", "Merry", "Pippin")
//Set a larger array with size 10, all filled with one String of Haldir
val large = Array<String?>(10){"Haldir"}
val boxes = arrayOf(1, 2, 3, 4, 5)

//var num1 = 11 //O(1)
//var num2 = 15 //O(1)

//Main Kotlin function
fun main(){
    println("Scratch testing code.")
    findFrodo(frodo)
    printLargeArray(large) // Big O(n), takes linear time to find/print Haldir
    printBoxes(boxes) // Big O(2)
}

//Function to go through indices of array to find specific string item
fun findFrodo (myArray: Array<String>) {
    for (item in myArray.indices)
        if (myArray[item] == "Frodo") {
            println("Found Frodo, Sauron wins.")
            break // break out of code to make it a little faster when Frodo is found
        }
}

//Function to go through indices of array and print all elements in it
fun printLargeArray (myArray: Array<String?>) {
    for (item in myArray.indices) { //O(n)
        println(myArray[item])
    }
}

//Function to print specific elements in array
fun printBoxes (myArray: Array<Int>) {
    println(myArray[0]) //O(1)
    println(myArray[1]) //O(1)

}