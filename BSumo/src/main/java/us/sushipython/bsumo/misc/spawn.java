package us.sushipython.bsumo.misc;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class spawn {
    public static void spawn(Player player, Location playerLoc) {
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
        Location[] s = {
                new Location(world, 42, 113, -140, 0, 0),
                new Location(world, 51, 113, -140, 45, 0),
                new Location(world, 51, 113, -131, 90, 0),
                new Location(world, 51, 113, -122, 135, 0),
                new Location(world, 42, 113, -122, 180, 0),
                new Location(world, 33, 113, -122, -135, 0),
                new Location(world, 33, 113, -131, -90, 0),
                new Location(world, 33, 113, -140, -45, 0)};
        ItemStack wool = new ItemStack(Material.WHITE_WOOL, 64);
        ItemStack shears = new ItemStack(Material.SHEARS, 1);
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
        player.teleport(new Location(world, playerLoc.getX(), 120, playerLoc.getZ()));
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
            Location i = spawns[randomIndex];
            Location c = s[randomIndex];
            new Location(world, c.getX(), 113, c.getZ()).getBlock().setType(Material.AIR);
            new Location(world, c.getX(), 114, c.getZ()).getBlock().setType(Material.AIR);
            player.teleport(spawns[randomIndex]);
            player.setGameMode(GameMode.SURVIVAL);
        }, 100L);
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
            player.setInvulnerable(false);
            player.sendMessage("Invincibility expired.");
        }, 200L);
    }
}
