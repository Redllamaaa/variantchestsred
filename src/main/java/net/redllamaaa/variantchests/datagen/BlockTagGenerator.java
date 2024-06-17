package net.redllamaaa.variantchests.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.redllamaaa.variantchests.Initialise;
import net.redllamaaa.variantchests.block.Vanilla;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public static final TagKey<Block> CHESTS = TagKey.of(Registries.BLOCK.getKey(), new Identifier(Initialise.MOD_ID, "chests"));
    public static final TagKey<Block> C_CHESTS = TagKey.of(Registries.BLOCK.getKey(), new Identifier("c:chests"));
    public static final TagKey<Block> C_WOODEN_CHESTS = TagKey.of(Registries.BLOCK.getKey(), new Identifier("c:wooden_chests"));

    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        registerTags(Vanilla.VANILLA_CHESTS);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .forceAddTag(CHESTS);

        getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
                .forceAddTag(CHESTS);

        getOrCreateTagBuilder(C_CHESTS)
                .forceAddTag(CHESTS);

        getOrCreateTagBuilder(C_WOODEN_CHESTS)
                .forceAddTag(CHESTS);
    }

    private void registerTags(Map<Identifier, Block> blockMap) {
        for (Block block : blockMap.values()) {
            Identifier lootTableId = block.getLootTableId();
            String newPath = lootTableId.getPath().replaceFirst("blocks/", "");
            Identifier modifiedId = new Identifier(lootTableId.getNamespace(), newPath);

            getOrCreateTagBuilder(CHESTS)
                    .addOptional(modifiedId);
        }
    }
}