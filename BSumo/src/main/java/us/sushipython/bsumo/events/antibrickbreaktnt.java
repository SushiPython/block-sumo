package us.sushipython.bsumo.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.Iterator;

public class antibrickbreaktnt implements Listener {
    public void onEntityExplode(EntityExplodeEvent e){
            Iterator<Block> iter = e.blockList().iterator();
            while (iter.hasNext()) {
                Block b = iter.next();
                if (b.getType() == Material.STONE_BRICKS || b.getType() == Material.STONE_BRICK_STAIRS || b.getType() == Material.GOLD_BLOCK) {
                    iter.remove();
                }
            }
    }
}
