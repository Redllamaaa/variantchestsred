package net.redllamaaa.variantchests;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.redllamaaa.variantchests.block.Vanilla;
import net.redllamaaa.variantchests.entity.EntityInitialise;
import net.redllamaaa.variantchests.util.ModCreativeTab;
import net.redllamaaa.variantchests.util.ModFuelRegistry;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "variantchests";

    public static void ifModLoaded(String modId, Runnable... runnables) {
        if (FabricLoader.getInstance().isModLoaded(modId)) {
            for (Runnable runnable : runnables) {
                runnable.run();
            }
        }
    }

    @Override
    public void onInitialize() {

        Vanilla.registerVanillaChests();
        EntityInitialise.registerBlockEntities();
        ModCreativeTab.registerItemGroup();
        ModFuelRegistry.registerFuel();

        //SnifferPlus.registerChests();
    }
}