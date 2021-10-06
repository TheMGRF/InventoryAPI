package me.themgrf.inventoryapi.api;

import org.bukkit.inventory.ItemStack;

/**
 * Basic class to store an item and its listener to be used in API inventories
 */
public class InventoryItem {

    private final ItemStack item;

    private final ItemListener itemListener;

    /**
     * Constructor for creating an inventory item
     *
     * @param item         The item to be used in the inventory
     * @param itemListener The listener to be associated with the item
     */
    public InventoryItem(ItemStack item, ItemListener itemListener) {
        this.item = item;
        this.itemListener = itemListener;
    }

    /**
     * Get the item to be used in the inventory
     *
     * @return The item to be used in the inventory
     */
    public ItemStack getItem() {
        return item;
    }

    /**
     * Get the item listener to be associated with the item
     *
     * @return The item listener to be associated with the item
     */
    public ItemListener getItemListener() {
        return itemListener;
    }

}
