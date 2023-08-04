package rarula.symmetricraft.player

import org.bukkit.Particle
import org.bukkit.scheduler.BukkitRunnable
import rarula.symmetricraft.util.Direction
import rarula.symmetricraft.util.DirectionType.*

class SymmetricPlayerRunnable(private val symmetricPlayer: SymmetricPlayer) : BukkitRunnable() {
    override fun run() {
        val player = symmetricPlayer.getBukkitPlayer()
        val block = player.getTargetBlock(10)
        val directionType = Direction.getDirectionTypeFromYaw(player.location.yaw)

        if (block !== null) {
            if (symmetricPlayer.getDisplayMode() === DisplayMode.CENTER) {
                for (i in -10..10) {
                    player.world.spawnParticle(
                        Particle.FLAME, block.location.add(0.5, 0.5, 0.5).add(0.0, i.toDouble() / 2, 0.0), 1, 0.0, 0.0, 0.0, 0.0
                    )
                }

                when (directionType) {
                    SOUTH -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(i.toDouble() / 2, 0.0, 0.0), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    SOUTH_EAST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(-i.toDouble() / 2, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    EAST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(0.0, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    NORTH_EAST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(i.toDouble() / 2, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    NORTH -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(i.toDouble() / 2, 0.0, 0.0), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    NORTH_WEST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(-i.toDouble() / 2, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    WEST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(0.0, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    SOUTH_WEST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(i.toDouble() / 2, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                }
            }

            if (symmetricPlayer.getDisplayMode() === DisplayMode.CORNER) {
                when (directionType) {
                    SOUTH -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.FLAME, block.location.add(0.5, 0.5, 0.5).add(0.0, i.toDouble() / 2, 0.5), 1, 0.0, 0.0, 0.0, 0.0
                            )
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(i.toDouble() / 2, 0.0, 0.5), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    SOUTH_EAST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.FLAME, block.location.add(1.0, 0.5, 1.0).add(0.0, i.toDouble() / 2, 0.0), 1, 0.0, 0.0, 0.0, 0.0
                            )
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(1.0, 0.5, 1.0).add(-i.toDouble() / 2, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    EAST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.FLAME, block.location.add(0.5, 0.5, 0.5).add(0.5, i.toDouble() / 2, 0.0), 1, 0.0, 0.0, 0.0, 0.0
                            )
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(0.5, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    NORTH_EAST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.FLAME, block.location.add(1.0, 0.5, 0.0).add(0.0, i.toDouble() / 2, 0.0), 1, 0.0, 0.0, 0.0, 0.0
                            )
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(1.0, 0.5, 0.0).add(i.toDouble() / 2, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    NORTH -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.FLAME, block.location.add(0.5, 0.5, 0.5).add(0.0, i.toDouble() / 2, -0.5), 1, 0.0, 0.0, 0.0, 0.0
                            )
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(i.toDouble() / 2, 0.0, -0.5), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    NORTH_WEST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.FLAME, block.location.add(0.0, 0.5, 0.0).add(0.0, i.toDouble() / 2, 0.0), 1, 0.0, 0.0, 0.0, 0.0
                            )
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.0, 0.5, 0.0).add(-i.toDouble() / 2, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    WEST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.FLAME, block.location.add(0.5, 0.5, 0.5).add(-0.5, i.toDouble() / 2, 0.0), 1, 0.0, 0.0, 0.0, 0.0
                            )
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.5, 0.5, 0.5).add(-0.5, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                    SOUTH_WEST -> {
                        for (i in -10..10) {
                            player.world.spawnParticle(
                                Particle.FLAME, block.location.add(0.0, 0.5, 1.0).add(0.0, i.toDouble() / 2, 0.0), 1, 0.0, 0.0, 0.0, 0.0
                            )
                            player.world.spawnParticle(
                                Particle.COMPOSTER, block.location.add(0.0, 0.5, 1.0).add(i.toDouble() / 2, 0.0, i.toDouble() / 2), 1, 0.0, 0.0, 0.0, 0.0
                            )
                        }
                    }
                }
            }
        }
    }
}
