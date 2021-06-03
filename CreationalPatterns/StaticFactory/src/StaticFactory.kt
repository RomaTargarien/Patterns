


//The Static Factory Method may provide caching, as Long actually does. Instead of
//always returning a new instance for any value, valueOf() checks in-cache whether
//this value was already parsed. If it is, it returns a cached instance. Repeatedly
//calling the Static Factory Method with the same values may produce less
//garbage for collection than using constructors all the time.

class NumberMaster {
    companion object {
        fun valueOf(hopefullyNumber: String): Long {
            return hopefullyNumber.toLong()
        }
    }
}

//Calling a companion object doesn't require instantiating a class:
fun main() {
    println(NumberMaster.valueOf("123"))
}