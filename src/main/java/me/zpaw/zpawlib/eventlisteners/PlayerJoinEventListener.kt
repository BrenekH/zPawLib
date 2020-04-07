package me.zpaw.zpawlib.eventlisteners

import me.zpaw.zpawlib.ZPawLib
import me.zpaw.zpawlib.data.ConfigManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinEventListener(private val playerCache: ConfigManager, private val plugin: ZPawLib) : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player

        playerCache.setAndSaveValue("players.${player.displayName}.uuid", player.uniqueId.toString())
    }
}
