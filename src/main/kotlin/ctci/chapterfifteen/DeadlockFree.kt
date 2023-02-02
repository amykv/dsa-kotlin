package ctci.chapterfifteen
import java.util.concurrent.locks.ReentrantLock

// 15.4 - page 180
// In Kotlin, design a class which provides a lock only if there are no possible deadlocks.

//A lock is a mechanism for synchronizing access to shared resources by multiple threads. In order to ensure that a
// lock does not lead to deadlocks, we can use a technique called lock ordering. With lock ordering, we assign a
// specific order to the locks and enforce this order to avoid the possibility of two or more threads trying to
// acquire the locks in a different order, causing a deadlock.

fun main(){

}

//In this implementation, LockManager has two properties: lockList and lockMap. lockList is a list of all the locks that
//have been created, and lockMap is a map that maps lock names to locks.
//
//The getLock method returns the lock with the specified name. If a lock with the specified name does not exist, it
//creates a new lock, adds it to lockList, and maps the lock name to the lock in lockMap.
//
//The lockAll method takes a variable number of lock names and locks all of the locks in the specified order. It does
//this by first getting the locks corresponding to the lock names, then unlocking all the locks that come before the
//current lock in lockList, and finally locking the current lock.
//
//The unlockAll method takes a variable number of lock names and unlocks all of the locks in reverse order. This
//ensures that the locks are unlocked in the reverse order in which they were locked, avoiding the possibility of
//deadlocks.
class LockManager {
    private val lockList = mutableListOf<ReentrantLock>()
    private val lockMap = mutableMapOf<String, ReentrantLock>()

    fun getLock(lockName: String): ReentrantLock {
        if (!lockMap.containsKey(lockName)) {
            val lock = ReentrantLock()
            lockList.add(lock)
            lockMap[lockName] = lock
        }
        return lockMap[lockName]!!
    }

    fun lockAll(vararg lockNames: String) {
        val locks = lockNames.map { getLock(it) }
        locks.forEachIndexed { index, lock ->
            for (i in 0 until index) {
                lockList[i].unlock()
            }
            lock.lock()
        }
    }

    fun unlockAll(vararg lockNames: String) {
        val locks = lockNames.map { getLock(it) }
        locks.reversed().forEach {
            it.unlock()
        }
    }
}
