package us.sushipython.bsumo.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class railgun implements Listener {
    @EventHandler
    public void railgun(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.BLAZE_ROD) {
            Block playerTargetBlock = p.getTargetBlock((Set)null, 256);
            p.getWorld().spawnEntity(playerTargetBlock.getLocation(), EntityType.FIREBALL);
            ItemStack hand = p.getInventory().getItemInHand();
            hand.setAmount(hand.getAmount() - 1);
            p.getInventory().setItemInHand(hand);
        }
    }
}
