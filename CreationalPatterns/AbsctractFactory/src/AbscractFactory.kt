
import InfantryUnits.*
import VehicleUnits.*

fun main() {
    val hq = HQ()
    val barracks = hq.buildBarracks()
    val barracks2 = hq.buildBarracks()
    val vehicleFactory1 = hq.buildVehicleFactory()

    val units = listOf(
            barracks.build(RIFLEMEN),
            barracks.build(ROCKET_SOLDIER),
            barracks2.build(RIFLEMEN),
            vehicleFactory1.build(APC)
    )

}

//FACTORIES
class Barracks : Building<InfantryUnits, Infantry> {
    override fun build(type: InfantryUnits): Infantry {
        return when (type) {
            RIFLEMEN -> Rifleman()
            ROCKET_SOLDIER -> RocketSoldier()
        }
    }
}

class VehicleFactory : Building<VehicleUnits, Vehicle> {
    override fun build(type: VehicleUnits) = when (type) {
        APC -> APC()
        TANK -> Tank()
    }
}

interface Building<in UnitType, out ProduceUnit>
        where UnitType : Enum<*>, ProduceUnit: Unit {
    fun build(type: UnitType) : ProduceUnit
}

class HQ {
    val buildings = mutableListOf<Building<*,Unit>>()

    fun buildBarracks(): Barracks {
        val barrack = Barracks()
        buildings.add(barrack)
        return barrack
    }
    fun buildVehicleFactory(): VehicleFactory {
        val vf = VehicleFactory()
        buildings.add(vf)
        return vf
    }
}

//UNITS
interface Unit
interface Vehicle : Unit
interface Infantry : Unit

class Rifleman : Infantry
class RocketSoldier : Infantry

enum class InfantryUnits {
    RIFLEMEN,
    ROCKET_SOLDIER
}

class APC : Vehicle
class Tank : Vehicle

enum class VehicleUnits {
    APC,
    TANK
}
