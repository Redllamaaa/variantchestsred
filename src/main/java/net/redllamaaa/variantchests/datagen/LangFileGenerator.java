package net.redllamaaa.variantchests.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.redllamaaa.variantchests.block.Vanilla;

import java.util.Map;

public class LangFileGenerator extends FabricLanguageProvider {
    public LangFileGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public static String generateBlockDisplayName(Block block) {
        Identifier name = Registries.BLOCK.getId(block);
        String blockName = name.getPath();
        int underscoreIndex = blockName.indexOf('_');
        if (underscoreIndex != -1 && underscoreIndex < blockName.length() - 1) {
            blockName = blockName.substring(underscoreIndex + 1);
        }
        String[] parts = blockName.split("_");
        StringBuilder displayName = new StringBuilder();
        for (String part : parts) {
            displayName.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1)).append(" ");
        }
        return displayName.toString().trim();
    }

    public static String generateContainerDisplayName(Block block) {
        Identifier name = Registries.BLOCK.getId(block);
        String blockName = name.getPath();
        int underscoreIndex = blockName.indexOf('_');
        if (underscoreIndex != -1 && underscoreIndex < blockName.length() - 1) {
            blockName = blockName.substring(underscoreIndex + 1);
        }
        String[] parts = blockName.split("_");
        StringBuilder displayName = new StringBuilder();
        for (String part : parts) {
            displayName.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1)).append(" ");
        }
        return displayName.toString().trim();
    }

    private static void registerTranslations(TranslationBuilder translationBuilder, Map<Identifier, Block> blockMap) {
        for (Block block : blockMap.values()) {
            translationBuilder.add(block, generateBlockDisplayName(block));
        }
    }

    private static void registerContainerTranslations(TranslationBuilder translationBuilder, Map<Identifier, Block> blockMap) {
        for (Block block : blockMap.values()) {
            translationBuilder.add(block.getTranslationKey().replace("block", "container"), generateBlockDisplayName(block));
        }
    }


    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        registerTranslations(translationBuilder, Vanilla.VANILLA_CHESTS);
        translationBuilder.add("container.variantchests.oak_chest", "Oak Chest");
        translationBuilder.add("container.variantchests.acacia_chest", "Acacia Chest");
        translationBuilder.add("container.variantchests.bamboo_chest", "Bamboo Chest");
        translationBuilder.add("container.variantchests.birch_chest", "Birch Chest");
        translationBuilder.add("container.variantchests.cherry_chest", "Cherry Chest");
        translationBuilder.add("container.variantchests.crimson_chest", "Crimson Chest");
        translationBuilder.add("container.variantchests.dark_oak_chest", "Dark Oak Chest");
        translationBuilder.add("container.variantchests.jungle_chest", "Jungle Chest");
        translationBuilder.add("container.variantchests.mangrove_chest", "Mangrove Chest");
        translationBuilder.add("container.variantchests.spruce_chest", "Spruce Chest");
        translationBuilder.add("container.variantchests.warped_chest", "Warped Chest");
    }
}