package surivival.helpful.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import surivival.helpful.project.playercompass.Compass

class PcCommand : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender is Player && args?.size==1) {
            val player = Bukkit.getPlayer(args[0])
            if (player!=null) {
                Compass.createItem(player)
                sender.inventory.addItem(Compass.item!!)
                sender.compassTarget = player.location
                return true
            }
        }
        return false
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?,
    ): MutableList<String>? {
        val recommendation = ArrayList<String>()

        if (sender is Player && args!=null) {
            for (p in Bukkit.getOnlinePlayers()) {
                recommendation.add(p.name)
            }
        }
        return recommendation
    }
}