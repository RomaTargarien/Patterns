import Constants.GRENADE_DAMAGE
import Constants.REGULAR_SPEED
import Constants.RIFLE_DAMAGE

interface Infantry {
    fun move(x: Long, y: Long)
    fun attack(x: Long, y: Long)
}

//our Units
open class Rifleman : Infantry {
    override fun attack(x: Long, y: Long) {
        // Shoot
    }
    override fun move(x: Long, y: Long) {
        // Move at its own pace
    }
}
open class Grenadier : Infantry {
    override fun attack(x: Long, y: Long) {
        // Throw grenades
    }
    override fun move(x: Long, y: Long) {
        // Moves slowly, grenades are heavy
    }
}

// Upgraded units should have twice the damage, but move at the same pace:
class UpgradedRifleMan() : Rifleman() {
    override fun attack(x: Long, y: Long) {
        // Shoot twice as much
    }
}
class UpgradedGrenadier : Grenadier() {
    override fun attack(x: Long, y: Long) {
        // Throw pack of grenades
    }
}

//Now, our game designer has decided that we also need a light version of those
//units. That is, they attack in the same way as regular units, but move at twice the
//speed:
class LightRifleman : Rifleman() {
    override fun move(x: Long, y: Long) {
        // Running with rifle
    }
}
class LightGrenadier : Grenadier() {
    override fun move(x: Long, y: Long) {
        // I've been to gym, pack of grenades is no problem
    }
}

//Much simpler to extend and also to comprehend
class Soldier(private val weapon: Weapon,
              private val legs: Legs) : Infantry {
    override fun attack(x: Long, y: Long) {
        // Find target
        // Shoot
        weapon.causeDamage()
    }
    override fun move(x: Long, y: Long) {
        // Compute direction
        // Move at its own pace
        legs.move()
    }
}

interface Weapon {
    fun causeDamage(): PointsOfDamage
}
interface Legs {
    fun move(): Meters
}
typealias PointsOfDamage = Long
typealias Meters = Int

//weapons and move parts
class Grenade : Weapon {
    override fun causeDamage() = GRENADE_DAMAGE
}
class GrenadePack : Weapon {
    override fun causeDamage() = GRENADE_DAMAGE * 3
}
class Rifle : Weapon {
    override fun causeDamage() = RIFLE_DAMAGE
}
class MachineGun : Weapon {
    override fun causeDamage() = RIFLE_DAMAGE * 2
}
class RegularLegs : Legs {
    override fun move() = REGULAR_SPEED
}
class AthleticLegs : Legs {
    override fun move() = REGULAR_SPEED * 2
}

