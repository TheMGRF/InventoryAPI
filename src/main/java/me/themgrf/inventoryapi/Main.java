package me.themgrf.inventoryapi;

import me.themgrf.inventoryapi.api.listeners.InventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
    }
}
