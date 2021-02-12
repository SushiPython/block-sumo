package us.sushipython.bsumo.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.sushipython.bsumo.misc.clear;

public class clearworld implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Material[] colors = {Material.RED_WOOL, Material.ORANGE_WOOL, Material.YELLOW_WOOL, Material.LIME_WOOL, Material.BLUE_WOOL, Material.MAGENTA_WOOL};
        clear.setBlocks(new Location(p.getWorld(), 31, 106, -120), new Location(p.getWorld(), 53, 147, -142), colors);

        return false;
    }
}
