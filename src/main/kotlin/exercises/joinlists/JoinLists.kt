package exercises.joinlists

import java.util.ArrayList
//Kotlin program to join two lists together
fun main() {

    val list1 = ArrayList<String>()
    list1.add("a, t, f")

    val list2 = ArrayList<String>()
    list2.add("b, x, z")

    val joined = ArrayList<String>()

    joined.addAll(list1)
    joined.addAll(list2)

    println("list1: $list1")
    println("list2: $list2")
    println("Joined: $joined")
}