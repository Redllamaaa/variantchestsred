package net.xanthian.variantchests.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.xanthian.variantchests.Initialise;
import net.xanthian.variantchests.block.Vanilla;
import net.xanthian.variantchests.block.compatability.*;

public class ModCreativeTab {

    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Initialise.MOD_ID, "variantchests"),

            FabricItemGroup.builder()
                    .displayName(Text.translatable("variantchests.itemgroup"))
                    .icon(() -> new ItemStack(Vanilla.WARPED_CHEST))
                    .entries((context, entries) -> {

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

                        if (FabricLoader.getInstance().isModLoaded("ad_astra")) {
                            entries.add(AdAstra.AA_GLACIAN_CHEST);
                        }
                        if (FabricLoader.getInstance().isModLoaded("beachparty")) {
                            entries.add(BeachParty.LDBP_PALM_CHEST);
                        }
                        if (FabricLoader.getInstance().isModLoaded("betterarcheology")) {
                            entries.add(BetterArcheology.BA_ROTTEN_CHEST);
                        }
                        if (FabricLoader.getInstance().isModLoaded("deeperdarker")) {
                            entries.add(DeeperAndDarker.DAD_ECHO_CHEST);
                        }
                        if (FabricLoader.getInstance().isModLoaded("minecells")) {
                            entries.add(MineCells.MC_PUTRID_CHEST);
                        }
                        if (FabricLoader.getInstance().isModLoaded("snifferplus")) {
                            entries.add(SnifferPlus.SP_STONE_PINE_CHEST);
                        }
                        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
                            entries.add(TechReborn.TR_RUBBER_CHEST);
                        }
                        if (FabricLoader.getInstance().isModLoaded("vinery")) {
                            entries.add(Vinery.LDV_CHERRY_CHEST);
                        }
                    })
                    .build());

    public static void registerItemGroup() {
    }
}