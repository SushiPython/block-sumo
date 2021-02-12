package us.sushipython.bsumo.events;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class antifall implements Listener {
    public void antifall(EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
            e.setCancelled(true);
        }
    }
}
