package rarula.symmetricraft.world

import org.bukkit.World
import rarula.symmetricraft.area.SymmetricArea
import java.util.UUID

class SymmetricWorld(world: World) {
    companion object {
        private val worldMap = HashMap<UUID, SymmetricWorld>()

        fun getFromWorld(world: World): SymmetricWorld {
            val symmetricWorld = worldMap[world.uid]

            return if (symmetricWorld === null) {
                val newSymmetricWorld = SymmetricWorld(world)
                worldMap[world.uid] = newSymmetricWorld

                newSymmetricWorld
            } else {
                symmetricWorld
            }
        }
    }

    private val world: World
    private val areaMap = HashMap<String, SymmetricArea>()

    init {
        this.world = world
    }

    fun getAllArea(): MutableCollection<SymmetricArea> {
        return areaMap.values
    }

    fun addArea(area: SymmetricArea) {
        areaMap[area.getName()] = area
    }

    fun removeArea(name: String) {
        val area = areaMap[name]
        area?.stopRunnable()

        areaMap.remove(name)
    }
}
