package rarula.symmetricraft.area

import org.bukkit.Particle
import org.bukkit.scheduler.BukkitRunnable

class SymmetricAreaRunnable(private val symmetricArea: SymmetricArea) : BukkitRunnable() {
    override fun run() {
        for (i in -10..10) {
            val location = symmetricArea.getLocation().clone()

            symmetricArea.getLocation().world.spawnParticle(
                Particle.END_ROD, location.add(0.5, 0.5, 0.5).add(0.0, i.toDouble() / 2, 0.0), 1, 0.0, 0.0, 0.0, 0.0
            )
        }
    }
}
