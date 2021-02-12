package us.sushipython.bsumo;

import org.bukkit.plugin.java.JavaPlugin;
import us.sushipython.bsumo.commands.*;
import us.sushipython.bsumo.events.*;

public final class BSumo extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new deathheight(), this);
        getServer().getPluginManager().registerEvents(new changecolor(), this);
        getServer().getPluginManager().registerEvents(new antifall(), this);
        getServer().getPluginManager().registerEvents(new antistonebreak(), this);
        getServer().getPluginManager().registerEvents(new antibrickbreaktnt(), this);
        getServer().getPluginManager().registerEvents(new railgun(), this);
        getServer().getPluginManager().registerEvents(new nooffhand(), this);
        getCommand("gblock").setExecutor(new gblock());
        getCommand("queue").setExecutor(new queue());
        getCommand("clearworld").setExecutor(new clearworld());
    }


}
