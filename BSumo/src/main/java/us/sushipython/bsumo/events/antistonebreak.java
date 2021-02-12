package us.sushipython.bsumo.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class antistonebreak implements Listener {

    @EventHandler

    public void antistonebreak(BlockBreakEvent e) {
        Material block = e.getBlock().getType();

    if (block.equals(Material.STONE_BRICKS) || block.equals(Material.STONE_BRICK_STAIRS) || block.equals(Material.GOLD_BLOCK) || block.equals(Material.BARRIER)) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("You can't break this block here!");
        }

        if (block.equals(Material.RED_WOOL) || block.equals(Material.ORANGE_WOOL) || block.equals(Material.YELLOW_WOOL) || block.equals(Material.LIME_WOOL) || block.equals(Material.BLUE_WOOL) || block.equals(Material.MAGENTA_WOOL)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
        }

    }
}