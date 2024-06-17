package net.redllamaaa.variantchests.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.redllamaaa.variantchests.Initialise;

public class ModItemTags {

    public static final TagKey<Item> CHESTS = register("chests");

    private ModItemTags() {
    }

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(Initialise.MOD_ID, id));
    }
}