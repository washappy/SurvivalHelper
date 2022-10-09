package surivival.helpful

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.ChatColor
import surivival.helpful.commands.HmCommand
import surivival.helpful.commands.MlCommand
import surivival.helpful.commands.PcCommand

class Helpful : JavaPlugin() {

    override fun onEnable() {
        registerCommands()

        logger.info("survival helper activated" + ChatColor.AQUA)
    }

    override fun onDisable() {
        logger.info("survival helper deactivated" + ChatColor.AQUA)
    }

    private fun registerCommands() {
        getCommand("mylocation")!!.setExecutor(MlCommand())
        getCommand("playercompass")!!.setExecutor(PcCommand())
        getCommand("helpme")!!.setExecutor(HmCommand())
    }
}