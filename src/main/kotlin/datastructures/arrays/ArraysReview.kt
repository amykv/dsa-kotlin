package datastructures.arrays

import java.util.*

val names = arrayOf("Bob", "Bill", "Admir", "Luke", "Vader")

fun main(){

    //Alternate capitalizing names in array
    for (i in names.indices) {
        if (i % 2 == 0) {
            println(names[i])
        } else {
            println(names[i].uppercase(Locale.getDefault()))
        }
    }

}