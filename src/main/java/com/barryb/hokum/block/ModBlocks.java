package com.barryb.hokum.block;

import com.barryb.hokum.Hokum;
import com.barryb.hokum.block.custom.CelestineBlock;
import com.barryb.hokum.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Hokum.MODID);


    public static final RegistryObject<Block> ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.5f, 18).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LUNITE_ORE = registerBlock("lunite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.5f, 18).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ROSE_GOLD_BRICKS = registerBlock("rose_gold_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.5f, 18).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<StairBlock> ROSE_GOLD_BRICK_STAIRS = registerBlock("rose_gold_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.ROSE_GOLD_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.5f, 18).requiresCorrectToolForDrops()
                    ), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> ROSE_GOLD_BRICK_SLAB = registerBlock("rose_gold_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.5f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CELESTINE_BLOCK = registerBlock("celestine_block",
            () -> new CelestineBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(1.5f, 18).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LUNITE_BLOCK = registerBlock("lunite_block",
            () -> new CelestineBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(5.0f, 18).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> BARITE = registerBlock("barite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 18).requiresCorrectToolForDrops().sound(SoundType.TUFF)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> POLISHED_BARITE = registerBlock("polished_barite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.0f, 18).requiresCorrectToolForDrops().sound(SoundType.TUFF)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<StairBlock> POLISHED_BARITE_STAIRS = registerBlock("polished_barite_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_BARITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE)
                            .strength(2.0f, 18).requiresCorrectToolForDrops()
            ), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> POLISHED_BARITE_SLAB = registerBlock("polished_barite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.0f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);



    public static final RegistryObject<Block> JUNGLE_BRICKS = registerBlock("jungle_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(100f, 30).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_JUNGLE_BRICKS = registerBlock("mossy_jungle_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(100f, 30).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> JUNGLE_BRICK_PRESSURE_PLATE = registerBlock("jungle_brick_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> JUNGLE_DISPENSER = registerBlock("jungle_dispenser",
            () -> new DispenserBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(100f, 30).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> AMBER_GEMLIGHT = registerBlock("amber_gemlight",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2f).requiresCorrectToolForDrops().lightLevel((swag) -> {
                        return 15;
                    })), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DIAMOND_GEMLIGHT = registerBlock("diamond_gemlight",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2f).requiresCorrectToolForDrops().lightLevel((swag) -> {
                        return 15;
                    })), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> EMERALD_GEMLIGHT = registerBlock("emerald_gemlight",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2f).requiresCorrectToolForDrops().lightLevel((swag) -> {
                        return 15;
                    })), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> GOLD_GEMLIGHT = registerBlock("gold_gemlight",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2f).requiresCorrectToolForDrops().lightLevel((swag) -> {
                        return 15;
                    })), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LAPIS_GEMLIGHT = registerBlock("lapis_gemlight",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2f).requiresCorrectToolForDrops().lightLevel((swag) -> {
                        return 15;
                    })), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LUNITE_GEMLIGHT = registerBlock("lunite_gemlight",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2f).requiresCorrectToolForDrops().lightLevel((swag) -> {
                        return 15;
                    })), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> REDSTONE_GEMLIGHT = registerBlock("redstone_gemlight",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2f).requiresCorrectToolForDrops().lightLevel((swag) -> {
                        return 15;
                    })), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> ROSE_GOLD_GEMLIGHT = registerBlock("rose_gold_gemlight",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2f).requiresCorrectToolForDrops().lightLevel((swag) -> {
                        return 15;
                    })), CreativeModeTab.TAB_BUILDING_BLOCKS);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> g = BLOCKS.register(name, block);
        registerBlockItem(name, g, tab);
        return g;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
