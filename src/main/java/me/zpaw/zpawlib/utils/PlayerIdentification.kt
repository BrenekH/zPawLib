package me.zpaw.zpawlib.utils

import org.bukkit.Bukkit
import org.bukkit.entity.Player

class PlayerIdentification {
    companion object {
        fun playersInArea(x1: Int, y1: Int, z1: Int, x2: Int, y2: Int, z2: Int): List<Player> {
            val onlinePlayers = Bukkit.getOnlinePlayers()
            val inAreaList: MutableList<Player> = mutableListOf()
            for (player in onlinePlayers) {
                val playerLocation = player.location
                if (playerLocation.x >= x1 && playerLocation.x <= x2 &&
                        playerLocation.y >= y1 && playerLocation.y <= y2 &&
                        playerLocation.z >= z1 && playerLocation.z <= z2) {
                    inAreaList.add(player)
                }
            }
            return inAreaList.toList()
        }
    }
}