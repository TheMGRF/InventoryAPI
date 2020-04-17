package me.themgrf.inventoryapi.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * Class for storing information on API inventories
 */
public class Inventory {

    private InventoryType inventoryType;

    private final String inventoryName;

    private int inventorySlots = 0;

    private final HashMap<Integer, InventoryItem> slots = new HashMap<>();

    private org.bukkit.inventory.Inventory inventory;

    /**
     * Constructor for creating an inventory of a specific type
     * @param name The name to give the inventory
     * @param type The specified type of the inventory
     */
    public Inventory(String name, InventoryType type) {
        this.inventoryName = name;
        this.inventoryType = type;
    }

    /**
     * Constructor for creating a chest inventory with a specified amount of slots
     * @param name The name to give the inventory
     * @param slots The amount of slots to give the inventory
     */
    public Inventory(String name, int slots) {
        this.inventoryName = name;
        this.inventorySlots = slots;
    }

    /**
     * Open the inventory to a player
     * @param player The player to open the inventory to
     */
    public void open(Player player) {
        player.openInventory(getInventory());
    }

    /**
     * Get the Bukkit inventory of the API inventory
     * @return The Bukkit form on the API inventory
     */
    public org.bukkit.inventory.Inventory getInventory() {
        if (inventory == null) {
            if (this.inventorySlots != 0) {
                inventory = Bukkit.createInventory(null, inventorySlots, Text.colour(inventoryName));
            } else {
                inventory = Bukkit.createInventory(null, inventoryType, Text.colour(inventoryName));
            }
            for (int i = 0; i < 55; i++) {
                if (slots.containsKey(i)) {
                    InventoryItem item = slots.get(i);
                    inventory.setItem(i, item.getItem());
                }
            }
        }
        return inventory;
    }

    /**
     * Get the type of inventory
     * @return The type of inventory
     */
    public InventoryType getType() {
        return inventoryType;
    }

    /**
     * Get the name of the inventory
     * @return The name of the inventory
     */
    public String getName() {
        return inventoryName;
    }

    /**
     * Set the item in a specific slot
     * @param slot The slot to set the item in
     * @param item The item to use in the slot
     * @param itemListener The item listener to associate with the item
     */
    public void setSlot(int slot, ItemStack item, ItemListener itemListener) {
        slots.put(slot, new InventoryItem(item, itemListener));
    }

    /**
     * Get the inventory item in a specific slot
     * @param Slot The slot to get the inventory item from
     * @return An inventory item in a specific slot
     */
    public InventoryItem getSlot(int Slot) {
        return slots.get(Slot);
    }

}
