package me.zpaw.zpawlib.utils

import org.bukkit.Bukkit.getWorld
import org.bukkit.Location

class World {
    companion object {
        fun clone(lowerBound: Location, upperBound: Location, destinationLowerBound: Location) {
            if (lowerBound.x > upperBound.x || lowerBound.y > upperBound.y || lowerBound.z > upperBound.z)
                throw IllegalArgumentException("All lowerBound values must be lower than upperBound value")

            for (x in lowerBound.x.toInt()..upperBound.x.toInt()) {
                for (y in lowerBound.y.toInt()..upperBound.y.toInt()) {
                    for (z in lowerBound.z.toInt()..upperBound.z.toInt()) {
                        val cloneTo = Location(getWorld("world"), destinationLowerBound.x + (x.toDouble() - lowerBound.x), destinationLowerBound.y + (y.toDouble() - lowerBound.y), destinationLowerBound.z + (z.toDouble() - lowerBound.z))
                        val cloneFrom = Location(getWorld("world"), x.toDouble(), y.toDouble(), z.toDouble())

                        cloneTo.block.type = cloneFrom.block.type
                    }
                }
            }
        }
    }
}
