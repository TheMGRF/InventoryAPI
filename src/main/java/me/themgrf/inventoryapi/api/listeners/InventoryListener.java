package me.themgrf.inventoryapi.api.listeners;

import me.themgrf.inventoryapi.api.Inventory;
import me.themgrf.inventoryapi.api.InventoryAPI;
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
        Player p = (Player) e.getWhoClicked();
        for (Inventory invs : InventoryAPI.getInventories()) {
            if (invs.getInventory().equals(e.getClickedInventory())) {
                // TODO: Temporarily disable to check if needed
//                if (e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY || e.getAction() == InventoryAction.COLLECT_TO_CURSOR) {
//                    e.setCancelled(true);
//                }
                e.setCancelled(true);
                try {
                    int slot = e.getSlot();
                    invs.getSlot(slot).getItemListener().onItemClick(p, e.getClick());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return;
            }
        }
    }
}
