package net.redllamaaa.variantchests.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.TextureMap;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.redllamaaa.variantchests.block.Vanilla;
import net.redllamaaa.variantchests.block.VariantChests;
import net.redllamaaa.variantchests.util.ModModel;
import net.redllamaaa.variantchests.util.ModTextureKey;

import java.util.Map;
import java.util.function.Function;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    public static Identifier getId(Block block) {
        Identifier identifier = Registries.BLOCK.getId(block);
        return identifier.withPrefixedPath("chest/");
    }

    public static void registerModel(BlockStateModelGenerator blockStateModelGenerator, Map<Identifier, Block> blockMap, String modId, Function<String, String> modelPathGenerator) {
        for (Block chest : blockMap.values()) {
            String blockName = chest.getTranslationKey();
            int firstUnderscoreIndex = blockName.indexOf('_');
            if (firstUnderscoreIndex != -1) {
                String plankName = blockName.substring(firstUnderscoreIndex + 1, blockName.lastIndexOf("_chest"));
                String modelPath = modId + ":block/" + modelPathGenerator.apply(plankName);
                blockStateModelGenerator.registerBuiltinWithParticle(chest, new Identifier(modelPath));
            } else {
                System.out.println("Invalid block name format: " + blockName);
            }
        }
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerBuiltin(VariantChests.OAK.getId().withPrefixedPath("block/"), Blocks.OAK_PLANKS).includeWithoutItem(Vanilla.OAK_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.ACACIA.getId().withPrefixedPath("block/"), Blocks.ACACIA_PLANKS).includeWithoutItem(Vanilla.ACACIA_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.BAMBOO.getId().withPrefixedPath("block/"), Blocks.BAMBOO_PLANKS).includeWithoutItem(Vanilla.BAMBOO_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.BIRCH.getId().withPrefixedPath("block/"), Blocks.BIRCH_PLANKS).includeWithoutItem(Vanilla.BIRCH_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.CHERRY.getId().withPrefixedPath("block/"), Blocks.CHERRY_PLANKS).includeWithoutItem(Vanilla.CHERRY_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.CRIMSON.getId().withPrefixedPath("block/"), Blocks.CRIMSON_PLANKS).includeWithoutItem(Vanilla.CRIMSON_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.DARK_OAK.getId().withPrefixedPath("block/"), Blocks.DARK_OAK_PLANKS).includeWithoutItem(Vanilla.DARK_OAK_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.JUNGLE.getId().withPrefixedPath("block/"), Blocks.JUNGLE_PLANKS).includeWithoutItem(Vanilla.JUNGLE_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.MANGROVE.getId().withPrefixedPath("block/"), Blocks.MANGROVE_PLANKS).includeWithoutItem(Vanilla.MANGROVE_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.SPRUCE.getId().withPrefixedPath("block/"), Blocks.SPRUCE_PLANKS).includeWithoutItem(Vanilla.SPRUCE_CHEST);
        blockStateModelGenerator.registerBuiltin(VariantChests.WARPED.getId().withPrefixedPath("block/"), Blocks.WARPED_PLANKS).includeWithoutItem(Vanilla.WARPED_CHEST);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        chestItem(itemModelGenerator, Vanilla.OAK_CHEST);
        chestItem(itemModelGenerator, Vanilla.ACACIA_CHEST);
        chestItem(itemModelGenerator, Vanilla.BAMBOO_CHEST);
        chestItem(itemModelGenerator, Vanilla.BIRCH_CHEST);
        chestItem(itemModelGenerator, Vanilla.CHERRY_CHEST);
        chestItem(itemModelGenerator, Vanilla.CRIMSON_CHEST);
        chestItem(itemModelGenerator, Vanilla.DARK_OAK_CHEST);
        chestItem(itemModelGenerator, Vanilla.JUNGLE_CHEST);
        chestItem(itemModelGenerator, Vanilla.MANGROVE_CHEST);
        chestItem(itemModelGenerator, Vanilla.SPRUCE_CHEST);
        chestItem(itemModelGenerator, Vanilla.WARPED_CHEST);

    }

    public final void chestItem(ItemModelGenerator itemModelGenerator, Block block) {
        TextureMap textureMap = new TextureMap().put(ModTextureKey.CHEST, getId(block));
        ModModel.CHEST.upload(ModelIds.getItemModelId(block.asItem()), textureMap, itemModelGenerator.writer);
    }
}