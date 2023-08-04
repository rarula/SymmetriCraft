package rarula.symmetricraft.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import rarula.symmetricraft.player.SymmetricPlayer

class PlayerJoinQuitEvent : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        SymmetricPlayer.createSymmetricPlayer(event.player)
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        SymmetricPlayer.deleteSymmetricPlayer(event.player)
    }
}
