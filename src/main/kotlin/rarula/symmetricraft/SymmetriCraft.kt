package rarula.symmetricraft

import org.bukkit.plugin.java.JavaPlugin
import rarula.symmetricraft.command.SymmetriCraftCommands
import rarula.symmetricraft.listener.PlayerJoinQuitEvent

class SymmetriCraft : JavaPlugin() {
    companion object {
        private lateinit var plugin: SymmetriCraft

        fun getPlugin(): SymmetriCraft {
            return plugin
        }
    }

    override fun onEnable() {
        // Plugin startup logic
        plugin = this

        // Register events
        server.pluginManager.registerEvents(PlayerJoinQuitEvent(), this)

        // Register commands
        getCommand("symmetricraft")?.setExecutor(SymmetriCraftCommands())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
