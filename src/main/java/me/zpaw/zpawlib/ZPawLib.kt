package me.zpaw.zpawlib

import me.zpaw.zpawlib.data.ConfigManager
import me.zpaw.zpawlib.eventlisteners.PlayerJoinEventListener
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class ZPawLib: JavaPlugin() {
    val playerCache: ConfigManager = ConfigManager(this, "playerCache.yml")

    override fun onEnable() {
        server.pluginManager.registerEvents(PlayerJoinEventListener(playerCache, this), this)
    }

    fun getPlayer(name: String): zPlayer? {
        val playerUUID: UUID = UUID.fromString((playerCache.config.get("players.$name.uuid", null) ?: return null) as String?)
        return zPlayer(playerUUID)
    }
}
