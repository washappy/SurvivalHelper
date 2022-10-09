package surivival.helpful.bases

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

abstract class ItemBase {
    var item: ItemStack? = null
        protected set

    abstract fun createItem(player: Player)
}