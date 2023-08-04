package rarula.symmetricraft.player

import org.bukkit.entity.Player
import rarula.symmetricraft.SymmetriCraft
import java.util.UUID
import kotlin.collections.HashMap

class SymmetricPlayer(player: Player) {
    companion object {
        private val playerMap = HashMap<UUID, SymmetricPlayer>()

        fun createSymmetricPlayer(player: Player) {
            playerMap[player.uniqueId] = SymmetricPlayer(player)
        }

        fun deleteSymmetricPlayer(player: Player) {
            val symmetricPlayer = playerMap[player.uniqueId]
            symmetricPlayer?.setDisplaying(false, DisplayMode.NONE)
            symmetricPlayer?.stopRunnable()

            playerMap.remove(player.uniqueId)
        }

        fun getSymmetricPlayer(player: Player): SymmetricPlayer? {
            return playerMap[player.uniqueId]
        }
    }

    private val player: Player
    private var runnable: SymmetricPlayerRunnable? = null

    private var isDisplaying = false
    private var displayMode = DisplayMode.NONE

    init {
        this.player = player
    }

    fun getBukkitPlayer(): Player {
        return player
    }

    fun isDisplaying(): Boolean {
        return isDisplaying
    }

    fun setDisplaying(isDisplaying: Boolean, displayMode: DisplayMode) {
        if (isDisplaying) {
            if (displayMode !== this.displayMode) {
                this.runnable = SymmetricPlayerRunnable(this)
                this.runnable?.runTaskTimer(SymmetriCraft.getPlugin(), 0L, 5L)
            }
        }
        this.isDisplaying = isDisplaying
        this.displayMode = displayMode
    }

    fun getDisplayMode(): DisplayMode {
        return displayMode
    }

    fun stopRunnable() {
        runnable?.cancel()
    }
}
