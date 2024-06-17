package net.redllamaaa.variantchests;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.redllamaaa.variantchests.renderer.EntityRenderInitialise;

@Environment(EnvType.CLIENT)
public class ClientInitialise implements ClientModInitializer {
    public static void ifModLoaded(String modId, Runnable... runnables) {
        if (FabricLoader.getInstance().isModLoaded(modId)) {
            for (Runnable runnable : runnables) {
                runnable.run();
            }
        }
    }

    @Override
    public void onInitializeClient() {
        EntityRenderInitialise.register();
    }
}