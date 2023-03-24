package exercises.formattrainroute

//Instructions
//
//Given list of strings representing train station names implement a function which will return passenger friendly
// String:
//
//String always starts with Train is calling at
//If list contains single train station name, then return Train is calling at stationName
//If list contains multiple train station names, then return comma separated station names, but the last two names are
// separated by and word.

//Examples
//
//formatTrainRoute(listOf("Luton")) // "Train is calling at Luton"
//
//formatTrainRoute(listOf("Luton", "Harpenden")) // "Train is calling at Luton and Harpenden"
//
//formatTrainRoute(listOf("Luton", "Harpenden", "London")) // "Train is calling at Luton, Harpenden and London"

fun main() {

}

private fun formatTrainRoute(stations: List<String>): String {
    val prefix = "Train is calling at "

    if (stations.size == 1) {
        return prefix + stations[0]
    }

    val lastStation = stations.takeLast(1)
        .joinToString { it }

    val followingStations = stations.dropLast(1)
        .joinToString { it }

    return "$prefix$followingStations and $lastStation"
}