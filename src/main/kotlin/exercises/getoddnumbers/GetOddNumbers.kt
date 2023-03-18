package exercises.getoddnumbers

//Kotlin program to filter and print odd numbers from a list

fun main(){
    println(filterOdd(listOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 12, 16, 17, 18, 20)))
}

private fun filterOdd(list: List<Int>): List<Int> {
    return list.filter { it % 2 == 1 }
}