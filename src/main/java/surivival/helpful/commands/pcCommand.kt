package surivival.helpful.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import surivival.helpful.project.playercompass.Compass

class pcCommand : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender is Player && args?.size==1) {
            val player = Bukkit.getPlayer(args[0])
            if (player!=null) { //TODO(에러)
                Compass.createItem(player)
                sender.inventory.addItem(Compass.item!!)
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
        TODO("Not yet implemented")
    }
}