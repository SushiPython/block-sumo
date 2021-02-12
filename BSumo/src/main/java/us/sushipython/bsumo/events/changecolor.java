package us.sushipython.bsumo.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class changecolor implements Listener {
    @EventHandler
    public void changecolor(BlockPlaceEvent e) {
        if (e.getItemInHand().getType().equals(Material.WHITE_WOOL)) {
            Player p = e.getPlayer();
            p.getInventory().setItemInOffHand(null);
            double x = e.getBlock().getLocation().getX();
            double y = e.getBlock().getLocation().getY();
            double z = e.getBlock().getLocation().getZ();
            World w = e.getPlayer().getWorld();
            if ((new Location(w, x+1, y, z).getBlock().getType().equals(Material.BARRIER)) || (new Location(w, x, y, z+1).getBlock().getType().equals(Material.BARRIER)) || (new Location(w, x-1, y, z).getBlock().getType().equals(Material.BARRIER)) || (new Location(w, x, y, z-1).getBlock().getType().equals(Material.BARRIER))) {
                e.setCancelled(true);
                Location playerLoc = p.getLocation();
                //p.teleport(new Location(p.getWorld(), playerLoc.getX(), playerLoc.getY()-3, playerLoc.getZ()));
            } else {
                p.setItemInHand(new ItemStack(Material.WHITE_WOOL, 64));
                Material[] colors = {Material.RED_WOOL, Material.ORANGE_WOOL, Material.YELLOW_WOOL, Material.LIME_WOOL, Material.BLUE_WOOL, Material.MAGENTA_WOOL};
                Random generator = new Random();
                int randomIndex = generator.nextInt(colors.length);
                e.getBlock().setType(colors[randomIndex]);
            }

        }
    }
}
