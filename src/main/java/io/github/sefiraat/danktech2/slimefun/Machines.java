package io.github.sefiraat.danktech2.slimefun;

import io.github.sefiraat.danktech2.DankTech2;
import io.github.sefiraat.danktech2.slimefun.machines.DankCrafter;
import io.github.sefiraat.danktech2.slimefun.machines.DankUnloader;
import io.github.sefiraat.danktech2.theme.ThemeType;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public class Machines {

    @Getter
    private static DankCrafter dankCrafter;
    @Getter
    private static DankUnloader dankUnloader;

    public static void setup() {
        final DankTech2 plugin = DankTech2.getInstance();

        final ItemStack cell4 = Materials.getDankCell4().getItem();

        // Crafter
        dankCrafter = new DankCrafter(
            ItemGroups.MACHINES,
            ThemeType.themedSlimefunItemStack(
                "DK2_CRAFTER_1",
                new ItemStack(Material.JUKEBOX),
                ThemeType.MACHINE,
                "丹克工匠",
                "工匠和升級丹克背包."
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE,
                SlimefunItems.REINFORCED_PLATE, SlimefunItems.RAINBOW_RUNE, SlimefunItems.REINFORCED_PLATE,
                SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE,
            }
        );

        // Unloader
        dankUnloader = new DankUnloader(
            ItemGroups.MACHINES,
            ThemeType.themedSlimefunItemStack(
                "DK2_UNLOADER_1",
                new ItemStack(Material.GLASS),
                ThemeType.MACHINE,
                "丹克卸載機",
                "從你丹克的背包取出物品"
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                cell4, cell4, cell4,
                cell4, new ItemStack(Material.HOPPER), cell4,
                cell4, cell4, cell4
            }
        );

        // Slimefun Registry
        dankCrafter.register(plugin);
        dankUnloader.register(plugin);
    }
}
