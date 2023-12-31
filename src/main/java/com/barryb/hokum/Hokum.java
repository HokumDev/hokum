package com.barryb.hokum;

import com.barryb.hokum.block.ModBlocks;
import com.barryb.hokum.client.renderer.entity.MommyRenderer;
import com.barryb.hokum.client.renderer.entity.SludgeonRenderer;
import com.barryb.hokum.client.renderer.entity.WidowRenderer;
import com.barryb.hokum.custom.CustomBrewingRecipe;
import com.barryb.hokum.custom.LootModifiers;
import com.barryb.hokum.entity.ModAttributes;
import com.barryb.hokum.entity.ModMobs;
import com.barryb.hokum.entity.effects.ModEffects;
import com.barryb.hokum.item.ModPotions;
import com.barryb.hokum.sound.ModSounds;
import com.barryb.hokum.world.feature.ModConfiguredFeatures;
import com.barryb.hokum.world.feature.ModPlacedFeatures;
import com.mojang.logging.LogUtils;
import com.barryb.hokum.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import javax.swing.text.html.parser.Entity;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Hokum.MODID)
public class Hokum
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "hokum";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public Hokum()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModMobs.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        LootModifiers.register(modEventBus);
        ModPotions.register(modEventBus);
        ModEffects.register(modEventBus);
        ModAttributes.register(modEventBus);








        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }



    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("im just remembered to change this (hokum)");
        BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe(Potions.AWKWARD,
                ModItems.WIDOW_EYE.get(), ModPotions.WIDOW_POTION.get()));

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModMobs.WIDOW.get(), WidowRenderer::new);
            EntityRenderers.register(ModMobs.MOMMY.get(), MommyRenderer::new);
            EntityRenderers.register(ModMobs.SLUDGEON.get(), SludgeonRenderer::new);


            ItemBlockRenderTypes.setRenderLayer(ModBlocks.AMBER_SCAFFOLDING.get(), RenderType.translucent());



        }
    }



}
