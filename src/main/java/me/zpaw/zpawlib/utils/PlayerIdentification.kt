package me.zpaw.zpawlib.utils

import org.bukkit.Bukkit
import org.bukkit.entity.Player

class PlayerIdentification {
    companion object {
        fun playersInArea(lowerX: Int, lowerY: Int, lowerZ: Int, higherX: Int, higherY: Int, higherZ: Int): List<Player> {
            val onlinePlayers = Bukkit.getOnlinePlayers()
            val inAreaList: MutableList<Player> = mutableListOf()
            for (player in onlinePlayers) {
                val playerLocation = player.location
                if (playerLocation.x >= lowerX && playerLocation.x <= higherX &&
                        playerLocation.y >= lowerY && playerLocation.y <= higherY &&
                        playerLocation.z >= lowerZ && playerLocation.z <= higherZ) {
                    inAreaList.add(player)
                }
            }
            return inAreaList.toList()
        }
    }
}