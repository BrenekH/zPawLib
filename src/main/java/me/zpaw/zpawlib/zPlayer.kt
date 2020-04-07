package me.zpaw.zpawlib

import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.util.UUID

class zPlayer(uuid: UUID) {
    val player: OfflinePlayer = Bukkit.getOfflinePlayer(uuid)
    var onlinePlayer: Player? = null

    init {
        if (Bukkit.getPlayer(uuid) != null)
            onlinePlayer = Bukkit.getPlayer(uuid)
    }
}