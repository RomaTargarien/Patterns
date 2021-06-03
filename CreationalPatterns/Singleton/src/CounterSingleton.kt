import java.util.concurrent.atomic.AtomicInteger

//Objects can't have constructors. If you want some kind of initialization logic for
//your Singleton, such as loading data from the database or over the network for
//the first time, you can use the init block instead
object CounterSingleton {
    private val counter = AtomicInteger(0)
    fun increment() = counter.incrementAndGet()

    init {
        println("I was acessed for the first time")
    }
}

fun main() {
    for (i in 0..10){
        println(CounterSingleton.increment())
    }
}