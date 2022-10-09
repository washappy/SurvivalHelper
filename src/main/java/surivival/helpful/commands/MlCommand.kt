package surivival.helpful.commands

import net.kyori.adventure.text.Component.text
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import surivival.helpful.Liner
import kotlin.math.floor

class MlCommand : CommandExecutor, TabCompleter {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender is Player) {
            when (args?.size) {
                0, null -> {
                    Bukkit.broadcast(text(getLine(sender)))
                }
                else -> {
                    sender.sendMessage(getLine(sender))
                    for (i in args) {
                        Bukkit.getPlayer(i)?.sendMessage(getLine(sender))
                    }
                }
            }
            return true
        }
        return false
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?,
    ): MutableList<String> {
        val recommendation = ArrayList<String>()

        if (sender is Player && args!=null) {
            for (p in Bukkit.getOnlinePlayers()) {
                recommendation.add(p.name)
            }
        }
        return recommendation
    }

    private fun getLine(player : Player) : String {
        val location = player.location
        return Liner.addLine(player.name + "님은 " + location.world.name + " x : ${floor(location.x).toInt()}, y : ${floor(location.y).toInt()}, z : ${floor(location.z).toInt()} 에 있습니다")
    }

}