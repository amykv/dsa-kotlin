package ctci.chapterfifteen
import java.util.concurrent.Semaphore

// 15.7 - page 180
// Do FizzBuzz in a multithreaded way in Kotlin. Implement FizzBuzz with four threads. One thread checks for
// divisibility of 3 and prints "Fizz". Another thread is responsible for the divisibility of 5 and prints "Buzz".
// A third thread is responsible for divisibility of 3 and 5 and prints "FizzBuzz". A fourth thread does the numbers.

fun main() {
    val fb = FizzBuzz(100)
    val t1 = Thread(Runnable { fb.fizz() })
    val t2 = Thread(Runnable { fb.buzz() })
    val t3 = Thread(Runnable { fb.fizzbuzz() })
    val t4 = Thread(Runnable { fb.number() })
    t1.start()
    t2.start()
    t3.start()
    t4.start()
}

//This solution uses semaphores to control the execution of the four threads. Each semaphore represents a certain task
// that needs to be executed, and when a task is complete, the semaphore for the next task is released, allowing
// it to be executed. The number semaphore is initially set to 1, allowing the first call to the number() function to
// proceed. The other three semaphores (fizz, buzz, and fizzbuzz) are initially set to 0, which means they will block
// until they are released by the number() function.
class FizzBuzz {
    private val n: Int
    private var current: Int = 1
    private val fizz = Semaphore(0)
    private val buzz = Semaphore(0)
    private val fizzbuzz = Semaphore(0)
    private val number = Semaphore(1)

    constructor(n: Int) {
        this.n = n
    }

    // Prints "fizz"
    fun fizz() {
        while (true) {
            fizz.acquire()
            if (current > n) {
                return
            }
            println("fizz")
            number.release()
        }
    }

    // Prints "buzz"
    fun buzz() {
        while (true) {
            buzz.acquire()
            if (current > n) {
                return
            }
            println("buzz")
            number.release()
        }
    }

    // Prints "fizzbuzz"
    fun fizzbuzz() {
        while (true) {
            fizzbuzz.acquire()
            if (current > n) {
                return
            }
            println("fizzbuzz")
            number.release()
        }
    }

    // Prints the current number
    fun number() {
        while (true) {
            number.acquire()
            if (current > n) {
                fizz.release()
                buzz.release()
                fizzbuzz.release()
                return
            }
            when {
                current % 3 == 0 && current % 5 == 0 -> {
                    fizzbuzz.release()
                }
                current % 3 == 0 -> {
                    fizz.release()
                }
                current % 5 == 0 -> {
                    buzz.release()
                }
                else -> {
                    println(current)
                    number.release()
                }
            }
            current++
        }
    }
}