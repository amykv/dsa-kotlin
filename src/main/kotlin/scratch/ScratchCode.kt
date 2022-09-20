package scratch

//Kotlin file to run some test scratch code

//Array of strings
val frodo = arrayOf<String>("Aragorn", "Boromir", "Frodo", "Sam", "Legolas", "Gimli", "Gandalf", "Merry", "Pippin")

//Main Kotlin function
fun main(){
    println("Scratch testing code.")
    findFrodo(frodo)
}

//Function to go through indices of array to find specific string item
fun findFrodo (myArray: Array<String>) {
    for (item in myArray.indices)
        if (myArray[item] == "Frodo")
            println("Found Frodo, Sauron wins.")
}