package com.dre.brewery.integration.item;

import com.dre.brewery.Brew;
import com.dre.brewery.P;
import com.dre.brewery.filedata.BConfig;
import com.dre.brewery.recipe.BRecipe;
import com.dre.brewery.recipe.CustomItem;
import com.dre.brewery.recipe.PluginItem;
import dev.lone.itemsadder.api.CustomStack;
import dev.lone.itemsadder.api.ItemsAdder;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.lumine.mythic.lib.api.item.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ItemSadderIntegration extends PluginItem {

	private Map<String, CustomStack> customStackMap = new HashMap<>();



	@Override
	public boolean matchesWithCustomStack(CustomStack item) {
		if (!BConfig.hasItemsAdder) return false;

		try {
			if (item != null) {
				return item.getNamespacedID().equalsIgnoreCase(getItemId());
			}
		} catch (Exception | LinkageError e) {
			e.printStackTrace();
			P.p.errorLog("Could not check ItemsAdder for Item ID");
			BConfig.hasItemsAdder = false;
			return false;
		}
		return false;
	}

	@Override
	public boolean matches(ItemStack item) {
		if (!BConfig.hasItemsAdder) return false;

		try {
			if (item != null) {
				CustomStack customStack = CustomStack.byItemStack(item);
				if (CustomStack.getInstance(customStack.getNamespace()) != null) {
					return customStack.getId().equalsIgnoreCase(getItemId());
				}

			}
		} catch (Exception | LinkageError e) {
			e.printStackTrace();
			P.p.errorLog("Could not check ItemsAdder for Item ID");
			BConfig.hasItemsAdder = false;
			return false;
		}
		return false;
	}

	@Override
	public boolean matchesWithCustomItem(CustomStack item) {
		return false;
	}
}
