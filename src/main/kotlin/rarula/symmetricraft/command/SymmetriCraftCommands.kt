package rarula.symmetricraft.command

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player
import rarula.symmetricraft.area.AreaAlignType
import rarula.symmetricraft.area.AreaSymmetryType
import rarula.symmetricraft.area.SymmetricArea
import rarula.symmetricraft.player.DisplayMode
import rarula.symmetricraft.player.SymmetricPlayer
import rarula.symmetricraft.util.Direction
import rarula.symmetricraft.world.SymmetricWorld

class SymmetriCraftCommands : CommandExecutor, TabExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (args === null) return false

        if (command.name == "symmetricraft") {
            if (sender is Player) {
                if (args.isEmpty()) {
                    return false
                }

                when (args[0]) {
                    "show" -> {
                        if (args.size < 2) {
                            return false
                        }

                        when (args[1]) {
                            "center" -> {
                                SymmetricPlayer.getSymmetricPlayer(sender)?.setDisplaying(true, DisplayMode.CENTER)
                                return true
                            }
                            "corner" -> {
                                SymmetricPlayer.getSymmetricPlayer(sender)?.setDisplaying(true, DisplayMode.CORNER)
                                return true
                            }
                        }
                    }
                    "hide" -> {
                        SymmetricPlayer.getSymmetricPlayer(sender)?.setDisplaying(false, DisplayMode.NONE)
                        return true
                    }
                    "add" -> {
                        if (args.size < 5) {
                            return false
                        }

                        val symmetricPlayer = SymmetricPlayer.getSymmetricPlayer(sender)
                        if (symmetricPlayer !== null) {
                            val name = args[4]
                            val radius = args[3].toInt()

                            val player = symmetricPlayer.getBukkitPlayer()
                            val world = player.world
                            val location = player.getTargetBlock(10)?.location
                            val direction = Direction.getDirectionTypeFromYaw(player.location.yaw)

                            if (location !== null) {
                                when (args[1]) {
                                    "center" -> {
                                        when (args[2]) {
                                            "point" -> {
                                                symmetricPlayer.setDisplaying(false, DisplayMode.NONE)
                                                SymmetricWorld.getFromWorld(world).addArea(
                                                    SymmetricArea(name, location, direction, radius, AreaAlignType.CENTER, AreaSymmetryType.POINT)
                                                )

                                                player.sendMessage("" + ChatColor.GREEN + "Added area '${name}'.")

                                                return true
                                            }
                                            "line" -> {
                                                symmetricPlayer.setDisplaying(false, DisplayMode.NONE)
                                                SymmetricWorld.getFromWorld(world).addArea(
                                                    SymmetricArea(name, location, direction, radius, AreaAlignType.CENTER, AreaSymmetryType.LINE)
                                                )

                                                player.sendMessage("" + ChatColor.GREEN + "Added area '${name}'.")

                                                return true
                                            }
                                        }
                                    }
                                    "corner" -> {
                                        when (args[2]) {
                                            "point" -> {
                                                symmetricPlayer.setDisplaying(false, DisplayMode.NONE)
                                                SymmetricWorld.getFromWorld(world).addArea(
                                                    SymmetricArea(name, location, direction, radius, AreaAlignType.CORNER, AreaSymmetryType.POINT)
                                                )

                                                player.sendMessage("" + ChatColor.GREEN + "Added area '${name}'.")

                                                return true
                                            }
                                            "line" -> {
                                                symmetricPlayer.setDisplaying(false, DisplayMode.NONE)
                                                SymmetricWorld.getFromWorld(world).addArea(
                                                    SymmetricArea(name, location, direction, radius, AreaAlignType.CORNER, AreaSymmetryType.LINE)
                                                )

                                                player.sendMessage("" + ChatColor.GREEN + "Added area '${name}'.")

                                                return true
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    "remove" -> {
                        if (args.size < 2) {
                            return false
                        }

                        val name = args[1]

                        val symmetricWorld = SymmetricWorld.getFromWorld(sender.world)
                        val areaList = symmetricWorld.getAllArea()

                        var found = false
                        for (area in areaList) {
                            if (name == area.getName()) {
                                symmetricWorld.removeArea(name)
                                found = true
                                break
                            }
                        }

                        if (found) {
                            sender.sendMessage("" + ChatColor.GREEN + "Area '${name}' has been removed.")
                        } else {
                            sender.sendMessage("" + ChatColor.RED + "The specified area could not be found.")
                        }

                        return true
                    }
                    "list" -> {
                        val symmetricPlayer = SymmetricPlayer.getSymmetricPlayer(sender)
                        if (symmetricPlayer !== null) {
                            val player = symmetricPlayer.getBukkitPlayer()
                            val areaList = SymmetricWorld.getFromWorld(player.world).getAllArea()

                            sender.sendMessage("" + ChatColor.GREEN + "-------------------- List --------------------")

                            for (area in areaList) {
                                sender.sendMessage(area.getName())
                            }

                            sender.sendMessage("" + ChatColor.GREEN + "----------------------------------------------")
                        }

                        return true
                    }
                    "help" -> {
                        sender.sendMessage("" + ChatColor.YELLOW + "-------------------- Help --------------------")
                        sender.sendMessage("" +                    "/sc show (center|corner)")
                        sender.sendMessage("" +                    "/sc hide")
                        sender.sendMessage("" +                    "/sc add (center|corner) (point|line) <radius> <name>")
                        sender.sendMessage("" +                    "/sc remove <name>")
                        sender.sendMessage("" +                    "/sc list")
                        sender.sendMessage("" + ChatColor.YELLOW + "----------------------------------------------")
                        return true
                    }
                }
            }
        }
        return false
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>?): MutableList<String>? {
        val list = ArrayList<String>()

        if (args?.size == 1) {
            list.add("show")
            list.add("hide")
            list.add("add")
            list.add("remove")
            list.add("list")
            list.add("help")

            return list
        }

        if (args?.size == 2) {
            when (args[0]) {
                "show" -> {
                    list.add("center")
                    list.add("corner")

                    return list
                }
                "add" -> {
                    list.add("center")
                    list.add("corner")

                    return list
                }
                "remove" -> {
                    if (sender is Player) {
                        val areaList = SymmetricWorld.getFromWorld(sender.world).getAllArea()
                        list.addAll(areaList.map {
                            it.getName()
                        })

                        return list
                    }
                }
            }
        }

        if (args?.size == 3) {
            when (args[0]) {
                "add" -> {
                    list.add("point")
                    list.add("line")

                    return list
                }
            }
        }

        return null
    }
}
