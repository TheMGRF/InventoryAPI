package me.themgrf.inventoryapi.api.listeners;

import me.themgrf.inventoryapi.api.Inventory;
import me.themgrf.inventoryapi.api.InventoryAPI;
import me.themgrf.inventoryapi.api.InventoryItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * A listener class to manage inventory clicks
 */
public class InventoryListener implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        for (Inventory inv : InventoryAPI.getInventories()) {
            if (inv.getInventory().equals(e.getInventory())) {
                e.setCancelled(true);

                int slot = e.getSlot();
                InventoryItem item = inv.getSlot(slot);
                if (item != null && item.getItemListener() != null) {
                    item.getItemListener().onItemClick(player, e.getClick());
                }
                return;
            }
        }
    }
}
