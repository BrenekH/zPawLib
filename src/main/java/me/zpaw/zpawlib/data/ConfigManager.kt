package me.zpaw.zpawlib.data

import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.logging.Level

open class ConfigManager(private val plugin: JavaPlugin, private val configFileName: String) {
    private val configFile: File = File(plugin.dataFolder, configFileName)
    val config = YamlConfiguration.loadConfiguration(configFile)

    init {
        setConfigDefault()
        saveDefaultConfig()
    }

    private fun setConfigDefault() {
        val defaultStream: InputStream? = plugin.getResource(configFileName)
        if (defaultStream != null) {
            val defaultConfig: YamlConfiguration = YamlConfiguration.loadConfiguration(InputStreamReader(defaultStream))
            config.setDefaults(defaultConfig)
        }
    }

    private fun saveDefaultConfig() {
        if (!configFile.exists())
            plugin.saveResource(configFileName, false)
    }

    fun saveConfig() {
        try {
            config.save(configFile)
        } catch (e: IOException) {
            plugin.logger.log(Level.SEVERE, "Could not save config to $configFile", e)
        }
    }

    fun setAndSaveValue(path: String, value: Any?) {
        config.set(path, value)
        saveConfig()
    }

    fun getConfigurationSection(path: String): ConfigurationSection {
        if (config.getConfigurationSection(path) == null)
            config.createSection(path)

        return config.getConfigurationSection(path)!!
    }

}
