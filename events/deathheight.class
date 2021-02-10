package us.sushipython.bsumo.events;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;
import java.util.concurrent.TimeUnit;



public class deathheight implements Listener {

    @EventHandler
    public void deathheight(PlayerMoveEvent e) {
        Location playerLoc = e.getTo();
        Player player = e.getPlayer();
        World world = player.getWorld();
        Location[] spawns = {
                new Location(world, 42.5, 113, -139.5, 0, 0),
                new Location(world, 51.5, 113, -139.5, 45, 0),
                new Location(world, 51.5, 113, -130.5, 90, 0),
                new Location(world, 51.5, 113, -121.5, 135, 0),
                new Location(world, 42.5, 113, -121.5, 180, 0),
                new Location(world, 33.5, 113, -121.5, -135, 0),
                new Location(world, 33.5, 113, -130.5, -90, 0),
                new Location(world, 33.5, 113, -139.5, -45, 0)};
        ItemStack wool = new ItemStack(Material.WHITE_WOOL, 64);
        ItemStack shears = new ItemStack(Material.SHEARS, 1);
        if (playerLoc.getY() < 100) {
            Bukkit.broadcastMessage(player.toString() + " has fallen into the void!");
            player.sendMessage("You died! You will respawn in 5 seconds.");
            player.setInvulnerable(true);
            Random generator = new Random();
            int randomIndex = generator.nextInt(spawns.length);
            player.getInventory().clear();
            player.getInventory().addItem(wool);
            player.getInventory().addItem(shears);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999, 255));
            player.setHealth(20);
            player.setGameMode(GameMode.SPECTATOR);
            player.teleport(new Location(world, playerLoc.getX(), 130, playerLoc.getZ()));
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
                for (Location i : spawns) {
                    new Location(world, Math.rint(i.getX()), Math.rint(i.getY())+1, Math.rint(i.getZ())).getBlock().setType(Material.AIR);
                    new Location(world, Math.rint(i.getX()), Math.rint(i.getY()), Math.rint(i.getZ())).getBlock().setType(Material.AIR);
                }
                player.teleport(spawns[randomIndex]);
                player.setGameMode(GameMode.SURVIVAL);
            }, 100L);
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
                player.setInvulnerable(false);
                player.sendMessage("Invincibility expired.");
            }, 200L);
        }
    }

}
