package me.themgrf.inventoryapi.api;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

public abstract class ItemListener {

    public abstract void onItemClick(Player player, ClickType clickType);

}
