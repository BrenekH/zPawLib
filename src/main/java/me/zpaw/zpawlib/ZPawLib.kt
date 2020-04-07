package me.zpaw.zpawlib

import me.zpaw.zpawlib.data.ConfigManager
import me.zpaw.zpawlib.eventlisteners.PlayerJoinEventListener
import org.bukkit.plugin.java.JavaPlugin

class ZPawLib: JavaPlugin() {
    override fun onEnable() {
        val playerCache: ConfigManager = ConfigManager(this, "playerCache.yml")

        server.pluginManager.registerEvents(PlayerJoinEventListener(playerCache, this), this)
    }
}
