package datastructures.arrays

import java.util.*

val names = arrayOf("Bob", "Bill", "Admir", "Luke", "Vader", "Leo")

//Dynamic array
val companies = arrayListOf<String>("VVR", "DeuxEx", "Ringrealm",
    "Pear", "PaganLogic", "Sonda")

val days = listOf("Sunday", "Monday", "Tuesday", "Wednesday") //Immutable list
val months = arrayListOf("January", "February", "March", "April") //Mutable list, can add and remove elements

fun main(){

    //Alternate capitalizing names in array
    for (i in names.indices) {
        if (i % 2 == 0) {
            println(names[i])
        } else {
            println(names[i].uppercase(Locale.getDefault()))
        }
    }
    println("-----------")

    companies.add("Roscoes")
    companies.add("Svitla")
    companies[2] = "Nitter"
    companies.remove("Svitla")
    companies.removeAt(2)

    println(companies)


}