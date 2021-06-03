import java.lang.RuntimeException

interface Animal {
    val id: Int
    val name: String
}

open class Dog(override val id: Int): Animal {
    override val name = "Dog"
}

open class Cat(override val id: Int): Animal {
    override val name = "Cat"
}


fun main() {

    val factory = AnimalFactory()

    val animalTypes = listOf("dog" to "bulldog",
        "dog" to "beagle",
        "cat" to "persian")

    for (t in animalTypes) {
        val animal = factory.createAnimal(animalType = t.first,animalBreed = t.second)
        println("${animal.name}-${animal.id}")
    }
}

class AnimalFactory {
    var counter = 0
    val catFactory = CatFactory()
    val dogFactory = DogFactory()
    fun createAnimal(animalType: String,animalBreed: String): Animal {
        return when(animalType.trim().toLowerCase()) {
            "cat" -> catFactory.createCat(animalBreed,++counter)
            "dog" -> dogFactory.createDog(animalBreed,++counter)
            else -> throw RuntimeException()
        }
    }
}

class DogFactory{
    fun createDog(breed: String, id: Int) = when(breed.trim().toLowerCase()) {
        "beagle" -> Beagle(id)
        "bulldog" -> Bulldog(id)
        else -> throw RuntimeException("Unknown dog breed $breed")
    }
}
class CatFactory{
    fun createCat(breed: String, id: Int) = when(breed.trim().toLowerCase()) {
        "persian" -> Persian(id)
        else -> throw RuntimeException("Unknown dog breed $breed")
    }
}
class Beagle(override val id: Int): Dog(id) {
    override val name = "Beagle"
}
class Bulldog(override val id: Int): Dog(id) {
    override val name = "Bulldog"
}
class Persian(override val id: Int): Cat(id) {
    override val name = "Persian"
}