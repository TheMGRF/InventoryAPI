package me.themgrf.inventoryapi.api;

import org.bukkit.ChatColor;

/**
 * Basic utility class for internal colour translation
 */
class Text {

    /**
     * Convert colour codes in a string
     * @param msg The string to convert
     * @return The converted string containing colour codes
     */
    protected static String colour(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
