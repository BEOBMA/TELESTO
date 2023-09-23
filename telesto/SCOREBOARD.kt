@file:Suppress("DEPRECATION")

package org.beobma.telesto

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.scoreboard.DisplaySlot

class SCOREBOARD : Listener {



    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val scoreboard = Bukkit.getScoreboardManager().newScoreboard

        // Create a sidebar objective
        val objective = scoreboard.registerNewObjective("server_information", "dummy", "§bT§rE§bL§rE§bS§rT§bO")
        objective.displaySlot = DisplaySlot.SIDEBAR

        // Define scoreboard lines
        val scorelines = listOf(
            "§7================",
            "§7> §b닉네임 §f: ${player.name}",
            "§7> §b레벨 §f: ${player.scoreboard.getObjective("player_level")?.getScore(player.name)?.score}",
            "§7> §b재화 §f: ${player.scoreboard.getObjective("player_money")?.getScore(player.name)?.score}",
            "",
            "§7> §d서버 §f: 개발 예정",
            "§7> §d채팅 §f: 개발 예정"
        )

        // Set scores for lines
        for ((index, line) in scorelines.reversed().withIndex()) {
            val score = objective.getScore(line)
            score.score = index
        }

        player.scoreboard = scoreboard
    }

    private fun ScoreBoardChange(player: Player) {
        val scoreboard = player.scoreboard
        val objective = scoreboard.getObjective("sever_information")

        if (objective != null) {
            val playerLevel = player.scoreboard.getObjective("player_level")?.getScore(player.name)?.score
            val playerMoney = player.scoreboard.getObjective("player_money")?.getScore(player.name)?.score

            val score3 = objective.getScore("§7> §b레벨 §f: $playerLevel")
            val score4 = objective.getScore("§7> §b재화 §f: $playerMoney")
            score3.score = 4
            score4.score = 3
        }
    }
}