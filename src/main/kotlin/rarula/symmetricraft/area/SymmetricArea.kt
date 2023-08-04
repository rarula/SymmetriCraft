package rarula.symmetricraft.area

import org.bukkit.Location
import rarula.symmetricraft.SymmetriCraft
import rarula.symmetricraft.util.DirectionType

class SymmetricArea(
    private val name: String,
    private val location: Location,
    private val direction: DirectionType,
    private val radius: Int,
    private val areaAlignType: AreaAlignType,
    private val areaSymmetryType: AreaSymmetryType
) {
    private val runnable = SymmetricAreaRunnable(this)

    init {
        runnable.runTaskTimer(SymmetriCraft.getPlugin(), 0L, 5L)
    }

    fun getName(): String {
        return name
    }

    fun getLocation(): Location {
        return location
    }

    fun getDirection(): DirectionType {
        return direction
    }

    fun getRadius(): Int {
        return radius
    }

    fun getAreaAlignType(): AreaAlignType {
        return areaAlignType
    }

    fun getAreaSymmetryType(): AreaSymmetryType {
        return areaSymmetryType
    }

    fun stopRunnable() {
        runnable.cancel()
    }
}
