package me.themgrf.inventoryapi.api;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Utility class to manage the creation of inventories and items
 */
public class InventoryAPI {

    private static final List<Inventory> INVENTORIES = new ArrayList<>();

    /**
     * Create an inventory with a specified inventory type
     *
     * @param name The name to give the inventory
     * @param type The type of inventory to use
     * @return A named inventory of a specific type
     */
    public static Inventory createInventory(String name, InventoryType type) {
        Inventory inv = new Inventory(name, type);
        INVENTORIES.add(inv);
        return inv;
    }

    /**
     * Create a chest inventory with a specified amount of slots
     *
     * @param name  The name to give the inventory
     * @param slots The amount of slots to give the inventory
     * @return A named chest inventory with a specified amount of slots
     */
    public static Inventory createInventory(String name, int slots) {
        Inventory inv = new Inventory(name, slots);
        INVENTORIES.add(inv);
        return inv;
    }

    /**
     * Create an item
     *
     * @param displayName  The name of the item
     * @param description  The lore of the item
     * @param material     The material of the item
     * @param enchantments The enchantments of the item
     * @param amount       The amount of the item
     * @return A formatted item stack
     */
    public static ItemStack createItem(String displayName, List<String> description, Material material, Map<Enchantment, Integer> enchantments, int amount) {
        return createItem(displayName, description, new ItemStack(material), enchantments, amount);
    }

    /**
     * Create an item
     *
     * @param displayName  The name of the item
     * @param description  The lore of the item
     * @param itemstack    The item stack to use as a base for the item
     * @param enchantments The enchantments of the item
     * @param amount       The amount of the item
     * @return A formatted item stack
     */
    public static ItemStack createItem(String displayName, List<String> description, ItemStack itemstack, Map<Enchantment, Integer> enchantments, int amount) {
        ItemMeta itemMeta = itemstack.getItemMeta();
        int i = 0;

        if (amount <= itemstack.getMaxStackSize()) itemstack.setAmount(amount);
        if (displayName != null) itemMeta.setDisplayName(Text.colour(displayName));

        try {
            if (description != null && description.size() != 0) {
                for (i = 0; i < description.size(); i++) {
                    description.set(i, Text.colour(description.get(i)));
                }
                itemMeta.setLore(description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (enchantments != null && enchantments.size() != 0)
                itemstack.addUnsafeEnchantments(enchantments);
        } catch (Exception e) {
            e.printStackTrace();
        }

        itemstack.setItemMeta(itemMeta);

        return itemstack;
    }

    /**
     * Get all of the inventories stored in the API
     *
     * @return All of the inventories stored in the API
     */
    public static List<Inventory> getInventories() {
        return INVENTORIES;
    }
}
