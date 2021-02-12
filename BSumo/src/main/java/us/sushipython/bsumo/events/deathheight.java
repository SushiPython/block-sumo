package us.sushipython.bsumo.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import us.sushipython.bsumo.misc.spawn;

public class deathheight implements Listener {

    @EventHandler
    public void deathheight(PlayerMoveEvent e) {
        Location playerLoc = e.getTo();
        if (playerLoc.getY() < 100 & e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
            Player player = e.getPlayer();
            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE+player.getDisplayName() + ChatColor.WHITE + " has fallen into the void.");
            player.sendMessage("You died! You will respawn in 5 seconds.");
            player.setInvulnerable(true);
            spawn.spawn(player, playerLoc);

        }
    }

}
