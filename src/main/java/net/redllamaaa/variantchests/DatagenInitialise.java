package net.redllamaaa.variantchests;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.redllamaaa.variantchests.datagen.*;

public class DatagenInitialise implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BlockTagGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
        pack.addProvider(LangFileGenerator::new);
        pack.addProvider(LootTableGenerator::new);
        pack.addProvider(RecipeGenerator::new);
        pack.addProvider(ModelGenerator::new);
    }
}