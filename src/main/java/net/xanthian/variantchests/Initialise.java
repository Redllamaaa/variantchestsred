package net.xanthian.variantchests;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;

import net.xanthian.variantchests.block.Vanilla;
import net.xanthian.variantchests.block.compatability.*;
import net.xanthian.variantchests.entity.EntityInitialise;
import net.xanthian.variantchests.util.ModCreativeTab;
import net.xanthian.variantchests.util.ModFuelRegistry;

public class Initialise  implements ModInitializer {

    public static final String MOD_ID = "variantchests";

    @Override
    public void onInitialize() {

        Vanilla.registerVanillaChests();
        EntityInitialise.registerBlockEntities();
        ModCreativeTab.registerItemGroup();
        ModFuelRegistry.registerFuel();

        ifModLoaded("ad_astra", AdAstra::registerChests, EntityInitialise::registerAABlockEntities);
        ifModLoaded("beachparty", BeachParty::registerChests, EntityInitialise::registerLDBPBlockEntities);
        ifModLoaded("betterarcheology", BetterArcheology::registerChests, EntityInitialise::registerBABlockEntities);
        ifModLoaded("deeperdarker", DeeperAndDarker::registerChests, EntityInitialise::registerDADBlockEntities);
        ifModLoaded("minecells", MineCells::registerChests, EntityInitialise::registerMCBlockEntities);
        ifModLoaded("snifferplus", SnifferPlus::registerChests, EntityInitialise::registerSPBlockEntities);
        ifModLoaded("techreborn", TechReborn::registerChests, EntityInitialise::registerTRBlockEntities);
        ifModLoaded("vinery", Vinery::registerChests, EntityInitialise::registerLDVBlockEntities);
    }

    public static void ifModLoaded(String modId, Runnable... runnables) {
        if (FabricLoader.getInstance().isModLoaded(modId)) {
            for (Runnable runnable : runnables) {
                runnable.run();
            }
        }
    }
}