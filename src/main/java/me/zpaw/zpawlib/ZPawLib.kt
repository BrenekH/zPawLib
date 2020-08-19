package me.zpaw.zpawlib

import me.zpaw.zpawlib.data.ConfigManager
import me.zpaw.zpawlib.dependencies.Metrics
import me.zpaw.zpawlib.eventlisteners.PlayerJoinEventListener
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class ZPawLib: JavaPlugin() {
    private val playerCache: ConfigManager = ConfigManager(this, "playerCache.yml")

    override fun onEnable() {
        server.pluginManager.registerEvents(PlayerJoinEventListener(playerCache, this), this)

        val metrics = Metrics(this, 7066)
    }

    override fun onDisable() {
        playerCache.saveConfig()
    }

    fun getPlayer(name: String, color: ChatColor): ZPlayer? {
        val playerUUID: UUID = UUID.fromString((playerCache.config.get("players.$name.uuid", null) ?: return null) as String?)
        return ZPlayer(playerUUID, name, color)
    }
}
