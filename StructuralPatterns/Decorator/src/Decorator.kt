

class HappyMap<K, V> (
        private val map: MutableMap<K, V> = mutableMapOf()
) : MutableMap<K, V> by map {
    override fun put(key: K, value: V): V? {
        return map.put(key, value).apply {
            this?.let { println("Yay! $key") }
        }
    }
}



class SadMap<K,V> : HashMap<K,V>() {
    override fun remove(key: K): V? {
        println("Okay...let's remove $key ")
        return super.remove(key)
    }
}

data class JSON(val j: String)

operator fun JSON.plus(j2: JSON): JSON {
    val jsonFields = this.j.split(":") + j2.j.split(":")
    val s = (jsonFields).joinToString(":")
    return JSON("""{$s}""")
}


fun main() {

    val sadOrHappyMap = HappyMap(SadMap<String,String>())
    sadOrHappyMap["one"] = "one"
    sadOrHappyMap["two"] = "two"
    sadOrHappyMap["two"] = "three"
    sadOrHappyMap["a"] = "b"
    sadOrHappyMap.remove("a")

    val j1 = JSON("""{"a": "b"}""")
    val j2 = JSON("""{"c": "d"}""")

    println(j1 + j2)
}