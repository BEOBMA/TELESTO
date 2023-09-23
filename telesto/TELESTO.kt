package org.beobma.telesto

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class TELESTO : JavaPlugin(), Listener {


    override fun onEnable() {
        logger.info("TELESTO 플러그인 활성화")

        server.pluginManager.registerEvents(SCOREBOARD(), this)
        server.pluginManager.registerEvents(CHAT(), this)
    }

    override fun onDisable() {
        logger.info("TELESTO 플러그인 비활성화")
    }
}