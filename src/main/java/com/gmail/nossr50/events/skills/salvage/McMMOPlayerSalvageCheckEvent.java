package com.gmail.nossr50.events.skills.salvage;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;

import com.gmail.nossr50.datatypes.skills.SkillType;
import com.gmail.nossr50.events.skills.McMMOPlayerSkillEvent;

/**
 * Called just before a player salvages an item with mcMMO.
 */
public class McMMOPlayerSalvageCheckEvent extends McMMOPlayerSkillEvent implements Cancellable {
    private ItemStack salvageItem;
    private ItemStack salvageResults;
    private ItemStack enchantedBook;
    private boolean cancelled;

    public McMMOPlayerSalvageCheckEvent(Player player, ItemStack salvageItem, ItemStack salvageResults, ItemStack enchantedBook) {
        super(player, SkillType.SALVAGE);
        this.salvageItem = salvageItem;
        this.salvageResults = salvageResults;
        this.enchantedBook = enchantedBook;
        this.cancelled = false;
    }

    /**
     * @return The item that should get salvaged.
     */
    public ItemStack getSalvageItem() {
        return salvageItem;
    }

    /**
     * @return The results that should be dropped after salvaging.
     */
    public ItemStack getSalvageResults() {
        return salvageResults;
    }

    /**
     * @return The enchanted book that should drop after salvaging or null if no book should be dropped.
     */
    public ItemStack getEnchantedBook() {
        return enchantedBook;
    }

    /** Following are required for Cancellable **/
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
