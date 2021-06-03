

interface InfantryUnit : CanCountBullets
class Rifleman(initialMagazines: Int = 3) : InfantryUnit {
    private val magazines = List<Magazine>(initialMagazines){
        Magazine(5)
    }

    override fun bulletsLeft(): Int {
        return magazines.sumBy { it.bulletsLeft() }
    }
}
class Sniper(initialBullets: Int = 50) : InfantryUnit {
    private val bullets = List(initialBullets) { Bullet() }
    override fun bulletsLeft() = bullets.size
}

//Bullets and magazine
class Bullet
class Magazine(capacity: Int) : CanCountBullets {
    private val bullets = List(capacity) { Bullet() }
    override fun bulletsLeft() = bullets.size
}
interface CanCountBullets {
    fun bulletsLeft(): Int
}
class Squad(val infantryUnits: MutableList<InfantryUnit> = mutableListOf()) : CanCountBullets {
   constructor(vararg units: InfantryUnit) : this(mutableListOf()){
       for (u in units){
           this.infantryUnits.add(u)
       }
   }
    override fun bulletsLeft(): Int {
        return infantryUnits.sumBy { it.bulletsLeft() }
    }
}

fun main(){
    val miller = Rifleman()
    val caparzo = Rifleman()
    val jackson = Sniper()
    val squad = Squad(miller,jackson,caparzo)
    println(squad.infantryUnits.size)
}

