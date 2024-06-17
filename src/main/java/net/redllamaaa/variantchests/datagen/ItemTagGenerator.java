package net.redllamaaa.variantchests.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.redllamaaa.variantchests.block.Vanilla;
import net.redllamaaa.variantchests.util.ModItemTags;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> C_CHESTS = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:chests"));
    public static final TagKey<Item> C_WOODEN_CHESTS = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:wooden_chests"));

    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        registerTags(Vanilla.VANILLA_CHESTS);

        getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
                .add(Vanilla.CRIMSON_CHEST.asItem())
                .add(Vanilla.WARPED_CHEST.asItem());

        getOrCreateTagBuilder(C_CHESTS)
                .forceAddTag(ModItemTags.CHESTS);

        getOrCreateTagBuilder(C_WOODEN_CHESTS)
                .forceAddTag(ModItemTags.CHESTS);
    }

    private void registerTags(Map<Identifier, Block> blockMap) {
        for (Block block : blockMap.values()) {
            Identifier lootTableId = block.getLootTableId();
            String newPath = lootTableId.getPath().replaceFirst("blocks/", "");
            Identifier modifiedId = new Identifier(lootTableId.getNamespace(), newPath);

            getOrCreateTagBuilder(ModItemTags.CHESTS)
                    .addOptional(modifiedId);
        }
    }
}