package com.barryb.hokum.world.feature;

import com.barryb.hokum.Hokum;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Hokum.MODID);


    public static final RegistryObject<PlacedFeature> LUNITE_ORE_PLACED = PLACED_FEATURES.register("lunite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LUNITE_ORE.getHolder().get(), commonOrePlacement(30,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-40), VerticalAnchor.aboveBottom(20)))));

    public static final RegistryObject<PlacedFeature> CELESTINE_GEODE_PLACED = PLACED_FEATURES.register("celestine_geode_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CELESTINE_GEODE.getHolder().get(), List.of(
                    RarityFilter.onAverageOnceEvery(140), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(10)),
                    BiomeFilter.biome())));


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
