package surivival.helpful.project.playercompass

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import surivival.helpful.bases.ItemBase
import surivival.helpful.color.TextColors
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Compass : ItemBase() {
    override fun createItem(player: Player) {
        item = ItemStack(Material.COMPASS).apply {
            itemMeta = itemMeta.apply {
                displayName(Component.text("${player.name}을(를) 가르키는 나침반").color(TextColors.AQUA.color))
                lore(itemLore())
            }
        }
    }

    private fun itemLore():List<Component> {
        val lore = ArrayList<Component>()

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")
        val formatted = current.format(formatter)

        lore.add(Component.text("${formatted}에 제작되었습니다"))
        return lore
    }
}