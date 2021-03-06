package us.sushipython.bsumo.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class gblock implements CommandExecutor {
    private void spawnItem(World w) {
        ItemStack bat = new ItemStack(Material.WOODEN_SWORD);
        Material[] items = {Material.STICK, Material.BLAZE_ROD, Material.END_CRYSTAL};
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
            Random generator = new Random();
            Integer randNumb = generator.nextInt(items.length);
            w.dropItem(new Location(w, 42, 113, -131), new ItemStack(items[randNumb]));
            Bukkit.broadcastMessage(new ItemStack(items[randNumb]).getType().name() + " spawned on the gold block.");
            spawnItem(w);
        }, 1200L);
    }
    private void giveItem() {
        Material[] items = {Material.WOODEN_SWORD, Material.STONE_SWORD, Material.IRON_SWORD};
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
            Random generator = new Random();
            Integer n = generator.nextInt(items.length);
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.getInventory().addItem(new ItemStack(items[n]));
            }
            Bukkit.broadcastMessage(new ItemStack(items[n]).getType().name().replace('_', ' ') + " has been given to every player.");
            giveItem();
        }, 1000L);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        spawnItem(player.getWorld());
        giveItem();
        return false;
    }
}