package net.redllamaaa.variantchests.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.redllamaaa.variantchests.Initialise;
import net.redllamaaa.variantchests.block.Vanilla;

public class ModCreativeTab {

    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Initialise.MOD_ID, "variantchestsred"),

            FabricItemGroup.builder()
                    .displayName(Text.literal("Variant Chests"))
                    .icon(() -> new ItemStack(Vanilla.MANGROVE_CHEST))
                    .entries((context, entries) -> {

                        entries.add(Vanilla.OAK_CHEST);
                        entries.add(Vanilla.ACACIA_CHEST);
                        entries.add(Vanilla.BAMBOO_CHEST);
                        entries.add(Vanilla.BIRCH_CHEST);
                        entries.add(Vanilla.CHERRY_CHEST);
                        entries.add(Vanilla.CRIMSON_CHEST);
                        entries.add(Vanilla.DARK_OAK_CHEST);
                        entries.add(Vanilla.JUNGLE_CHEST);
                        entries.add(Vanilla.MANGROVE_CHEST);
                        entries.add(Blocks.CHEST);
                        entries.add(Vanilla.SPRUCE_CHEST);
                        entries.add(Vanilla.WARPED_CHEST);
                    })
                    .texture("variantchests.png").noRenderedName().build());

    public static void registerItemGroup() {
    }
}