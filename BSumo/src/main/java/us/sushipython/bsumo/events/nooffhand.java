package us.sushipython.bsumo.events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class nooffhand implements Listener {
    public void nooffhand(PlayerSwapHandItemsEvent e) {
        e.setCancelled(true);
        e.getPlayer().getInventory().setItemInOffHand(null);
    }
}
