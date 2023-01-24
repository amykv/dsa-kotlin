package ctci.chapterseven

// 7.4 - page 127
// In Kotlin, design a parking lot using object-oriented principles.

fun main() {
        val parkingLot = ParkingLot(10)
        val car1 = Car()
        val car2 = Car()
        val bus1 = Bus()
        parkingLot.park(car1)
        parkingLot.park(car2)
        parkingLot.park(bus1)
        parkingLot.leave(car1)
        println(parkingLot.spotsList.toList())
}

//Here, the Vehicle class is an abstract class that represents a vehicle, and the Car and Bus classes are subclasses
// of Vehicle that represent specific types of vehicles. The ParkingLot class represents the parking lot and has a
// list of spots, each of which can hold a single vehicle. The park method is used to park a vehicle in an available
// spot, and the leave method is used to remove a vehicle from a spot.
abstract class Vehicle {
    abstract val size: Int
}

class Car : Vehicle() {
    override val size = 1
}

class Bus : Vehicle() {
    override val size = 5
}

class ParkingLot(val spots: Int) {
    val spotsList = Array<Spot?>(spots) { null }

    fun park(vehicle: Vehicle) {
        for (i in 0 until spots) {
            if (spotsList[i] == null) {
                spotsList[i] = Spot(vehicle)
                break
            }
        }
    }

    fun leave(vehicle: Vehicle) {
        for (i in 0 until spots) {
            if (spotsList[i]?.vehicle == vehicle) {
                spotsList[i] = null
                break
            }
        }
    }

    data class Spot(val vehicle: Vehicle)
}