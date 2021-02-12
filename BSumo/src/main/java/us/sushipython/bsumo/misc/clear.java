package us.sushipython.bsumo.misc;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class clear {

    public static void setBlocks(Location loc1, Location loc2, Material[] blocks) {

        int topBlockX = (Math.max(loc1.getBlockX(), loc2.getBlockX()));
        int bottomBlockX = (Math.min(loc1.getBlockX(), loc2.getBlockX()));

        int topBlockY = (Math.max(loc1.getBlockY(), loc2.getBlockY()));
        int bottomBlockY = (Math.min(loc1.getBlockY(), loc2.getBlockY()));

        int topBlockZ = (Math.max(loc1.getBlockZ(), loc2.getBlockZ()));
        int bottomBlockZ = (Math.min(loc1.getBlockZ(), loc2.getBlockZ()));

        for(int x = bottomBlockX; x <= topBlockX; x++)
        {
            for(int z = bottomBlockZ; z <= topBlockZ; z++)
            {
                for(int y = bottomBlockY; y <= topBlockY; y++)
                {
                    Block block = loc1.getWorld().getBlockAt(x, y, z);
                    for (Material element : blocks) {
                        if (element == block.getType()) {
                            block.setType(Material.AIR);
                        }
                    }
                }
            }
        }
    }
}
