package net.redllamaaa.variantchests.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.redllamaaa.variantchests.block.Vanilla;

import java.util.Map;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        for (Block block : Vanilla.VANILLA_CHESTS.values()) {
            addDrop(block, this::nameableContainerDrops);
        }
    }

    public void registerSpecialLootTable(Map<Identifier, Block> chests, String modId) {
        for (Map.Entry<Identifier, Block> entry : chests.entrySet()) {
            Identifier chestId = entry.getKey();
            Block chest = entry.getValue();
            String path = chestId.getPath();
            String name = path.replace("variantchests:", "").replace("_chest", "").replaceFirst("^[^_]+_", "");
            withConditions(DefaultResourceConditions.and(
                    DefaultResourceConditions.allModsLoaded(modId),
                    DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier(modId + ":" + name + "_planks")))
            )).addDrop(chest, this::nameableContainerDrops);
        }
    }
}