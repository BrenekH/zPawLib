package me.zpaw.zpawlib

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.util.UUID

class ZPlayer(uuid: UUID, name: String, nameColor: ChatColor) {
    val player: OfflinePlayer = Bukkit.getOfflinePlayer(uuid)
    var onlinePlayer: Player? = null

    val coloredName: String = "$nameColor$name${ChatColor.RESET}"

    init {
        if (Bukkit.getPlayer(uuid) != null)
            onlinePlayer = Bukkit.getPlayer(uuid)
    }
}
