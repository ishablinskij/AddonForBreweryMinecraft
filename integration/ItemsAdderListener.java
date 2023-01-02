package com.dre.brewery.integration;

import com.dre.brewery.P;
import com.dre.brewery.filedata.BConfig;
import com.dre.brewery.integration.item.ItemSadderIntegration;
import com.dre.brewery.integration.item.MMOItemsPluginItem;
import com.dre.brewery.integration.item.SlimefunPluginItem;
import com.dre.brewery.recipe.BCauldronRecipe;
import com.dre.brewery.recipe.RecipeItem;
import com.dre.brewery.utility.LegacyUtil;
import dev.lone.itemsadder.api.CustomCrop;
import dev.lone.itemsadder.api.CustomStack;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.lumine.mythic.lib.api.item.NBTItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class ItemsAdderListener implements Listener {

	@EventHandler
	void interact(PlayerInteractEvent e)
	{
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK || e.getHand() == EquipmentSlot.OFF_HAND)
			return;
		if (e.hasItem()) {
			for (RecipeItem rItem : BCauldronRecipe.acceptedCustom) {
				if (rItem instanceof ItemSadderIntegration) {
					ItemSadderIntegration mmo = ((ItemSadderIntegration) rItem);
					if (mmo.matches(e.getItem())) {
						e.setCancelled(true);
						P.p.playerListener.onPlayerInteract(e);
						return;
					}
				}
			}
		}

	}
}

