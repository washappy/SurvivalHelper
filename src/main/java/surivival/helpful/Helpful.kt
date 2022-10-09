package surivival.helpful

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import surivival.helpful.commands.mlCommand
import surivival.helpful.commands.pcCommand

class Helpful : JavaPlugin() {

    override fun onEnable() {
        registerCommands()
//TODO(Chatcolor)
        Bukkit.getLogger().info(ChatColor.AQUA.toString() + "survival helper activated")
    }

    override fun onDisable() {
        Bukkit.getLogger().info(ChatColor.AQUA.toString() + "survival helper deactivated")
    }

    private fun registerCommands() {
        getCommand("mylocation")!!.setExecutor(mlCommand())
        getCommand("playercompass")!!.setExecutor(pcCommand())
    }
}