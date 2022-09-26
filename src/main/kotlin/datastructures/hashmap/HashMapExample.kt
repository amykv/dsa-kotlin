package datastructures.hashmap


//Simple HashMap example
fun main() {
    val movies = HashMap<String, Int>()
    movies["Event Horizon"] = 20
    movies["Aliens"] = 10
    movies["Kingdom of Heaven"] = 40

    for ((k, v) in movies) {
        println("$k = $v")
    }
}