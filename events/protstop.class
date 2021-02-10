package us.sushipython.bsumo.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class protstop implements Listener {
    @EventHandler
    public void protstop(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            e.getDamager().setInvulnerable(false);
        }
    }
}
