package com.barryb.hokum.item;

import com.barryb.hokum.Hokum;
import com.barryb.hokum.block.ModBlocks;
import com.barryb.hokum.custom.ArmorMaterials;
import com.barryb.hokum.entity.ModMobs;
import com.barryb.hokum.item.custom.*;
import com.barryb.hokum.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//it its time
public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Hokum.MODID);
    //rose gold

    public static final RegistryObject<Item> ROSEGOLD = ITEMS.register("rose_gold",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<SwordItem> ROSE_GOLD_SWORD = ITEMS.register("rose_gold_sword",
            () -> new SwordItem(ToolTiers.ROSEGOLD, 5, -2.2f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<PickaxeItem> ROSE_GOLD_PICKAXE = ITEMS.register("rose_gold_pickaxe",
            () -> new PickaxeItem(ToolTiers.ROSEGOLD, 1, -2.7f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<ShovelItem> ROSE_GOLD_SHOVEL = ITEMS.register("rose_gold_shovel",
            () -> new ShovelItem(ToolTiers.ROSEGOLD, 0, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<AxeItem> ROSE_GOLD_AXE = ITEMS.register("rose_gold_axe",
            () ->  new AxeItem(ToolTiers.ROSEGOLD, 6, -2.9f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<HoeItem> ROSE_GOLD_HOE = ITEMS.register("rose_gold_hoe",
            () ->  new HoeItem(ToolTiers.ROSEGOLD, 0, 0, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<StaffItem> ROSE_GOLD_STAFF = ITEMS.register("rose_gold_staff",
            () -> new RoseStaffItem(ToolTiers.ROSEGOLD, 0, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));


    //rose gold armor
    public static final RegistryObject<ArmorItem> ROSE_GOLD_HELMET = ITEMS.register("rose_gold_helmet",
            () -> new ArmorItem(ArmorTiers.ROSE_GOLD, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> ROSE_GOLD_CHESTPLATE = ITEMS.register("rose_gold_chestplate",
            () -> new ArmorItem(ArmorTiers.ROSE_GOLD, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> ROSE_GOLD_LEGGINGS  = ITEMS.register("rose_gold_leggings",
            () -> new ArmorItem(ArmorTiers.ROSE_GOLD, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> ROSE_GOLD_BOOTS = ITEMS.register("rose_gold_boots",
            () -> new ArmorItem(ArmorTiers.ROSE_GOLD, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> ROSE_GOLD_CROWN = ITEMS.register("rose_gold_crown",
            () -> new ArmorItem(ArmorTiers.ROSE_GOLD_CROWN, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<CleansingItem> AMETHYST_FOCUS = ITEMS.register("amethyst_focus",
            () -> new CleansingItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(16)));
    public static final RegistryObject<Item> LUNITE_DUST = ITEMS.register("lunite_dust",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> CELESTINE_DUST = ITEMS.register("celestine_dust",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));


    public static final RegistryObject<Item> ROSE_GOLD_CARROT = ITEMS.register("rose_gold_carrot",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(Foodstuffs.ROSE_GOLD_CARROT)));

    public static final RegistryObject<Item> ROSE_GOLD_NUGGET = ITEMS.register("rose_gold_nugget",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    //Flower Crowns
    public static final RegistryObject<ArmorItem> RED_FLOWER_CROWN = ITEMS.register("red_flower_crown",
            () -> new ArmorItem(ArmorTiers.RED_FLOWER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ArmorItem> ORANGE_FLOWER_CROWN = ITEMS.register("orange_flower_crown",
            () -> new ArmorItem(ArmorTiers.ORANGE_FLOWER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ArmorItem> YELLOW_FLOWER_CROWN = ITEMS.register("yellow_flower_crown",
            () -> new ArmorItem(ArmorTiers.YELLOW_FLOWER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ArmorItem> BLUE_FLOWER_CROWN = ITEMS.register("blue_flower_crown",
            () -> new ArmorItem(ArmorTiers.BLUE_FLOWER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ArmorItem> PURPLE_FLOWER_CROWN = ITEMS.register("purple_flower_crown",
            () -> new ArmorItem(ArmorTiers.PURPLE_FLOWER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ArmorItem> PINK_FLOWER_CROWN = ITEMS.register("pink_flower_crown",
            () -> new ArmorItem(ArmorTiers.PINK_FLOWER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ArmorItem> WHITE_FLOWER_CROWN = ITEMS.register("white_flower_crown",
            () -> new ArmorItem(ArmorTiers.WHITE_FLOWER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<ArmorItem> BLACK_FLOWER_CROWN = ITEMS.register("black_flower_crown",
            () -> new ArmorItem(ArmorTiers.BLACK_FLOWER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    //celestine
    public static final RegistryObject<Item> CELESTINE_INGOT = ITEMS.register("celestine_ingot",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<SwordItem> CELESTINE_SWORD = ITEMS.register("celestine_sword",
            () -> new CelestineSwordItem(ToolTiers.CELESTINE, 6, -2.2f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<PickaxeItem> CELESTINE_PICKAXE = ITEMS.register("celestine_pickaxe",
            () -> new PickaxeItem(ToolTiers.CELESTINE, 4, -2.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<ShovelItem> CELESTINE_SHOVEL = ITEMS.register("celestine_shovel",
            () -> new ShovelItem(ToolTiers.CELESTINE, 3, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<AxeItem> CELESTINE_AXE = ITEMS.register("celestine_axe",
            () ->  new AxeItem(ToolTiers.CELESTINE, 8, -2.9f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<HoeItem> CELESTINE_HOE = ITEMS.register("celestine_hoe",
            () ->  new HoeItem(ToolTiers.CELESTINE, 0, 0, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<StaffItem> CELESTINE_STAFF = ITEMS.register("celestine_staff",
            () -> new CelestineStaffItem(ToolTiers.CELESTINE, 0, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<Item> CELESTINE_CRYSTAL = ITEMS.register("celestine_crystal",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<ModArmorItem> CELESTINE_HELMET = ITEMS.register("celestine_helmet",
            () -> new ModArmorItem(ArmorTiers.CELESTINE, EquipmentSlot.HEAD, 0.02, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> CELESTINE_CHESTPLATE = ITEMS.register("celestine_chestplate",
            () -> new ModArmorItem(ArmorTiers.CELESTINE, EquipmentSlot.CHEST, 0.02, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> CELESTINE_LEGGINGS = ITEMS.register("celestine_leggings",
            () -> new ModArmorItem(ArmorTiers.CELESTINE, EquipmentSlot.LEGS, 0.02, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> CELESTINE_BOOTS = ITEMS.register("celestine_boots",
            () -> new ModArmorItem(ArmorTiers.CELESTINE, EquipmentSlot.FEET, 0.02, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> CELESTINE_CROWN = ITEMS.register("celestine_crown",
            () -> new ModArmorItem(ArmorTiers.CELESTINE_CROWN, EquipmentSlot.HEAD, 0.02, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));


    public static final RegistryObject<Item> RECORD_CHIRP = ITEMS.register("record_chirp",
            () -> new RecordItem(2, ModSounds.RECORD_CHIRP,
                    new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC).rarity(Rarity.RARE), 2160));


    //Lunite

    public static final RegistryObject<Item> LUNITE_INGOT = ITEMS.register("lunite_ingot",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> RAW_LUNITE = ITEMS.register("raw_lunite",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<SwordItem> LUNITE_SWORD = ITEMS.register("lunite_sword",
            () -> new SwordItem(ToolTiers.LUNITE, 10, -2.7f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<PickaxeItem> LUNITE_PICKAXE = ITEMS.register("lunite_pickaxe",
            () -> new PickaxeItem(ToolTiers.LUNITE, 6, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<ShovelItem> LUNITE_SHOVEL = ITEMS.register("lunite_shovel",
            () -> new ShovelItem(ToolTiers.LUNITE, 5, -2.9f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<AxeItem> LUNITE_AXE = ITEMS.register("lunite_axe",
            () ->  new AxeItem(ToolTiers.LUNITE, 14, -3.2f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<HoeItem> LUNITE_HOE = ITEMS.register("lunite_hoe",
            () ->  new HoeItem(ToolTiers.LUNITE, 1, 0, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<StaffItem> LUNITE_STAFF = ITEMS.register("lunite_staff",
            () -> new LuniteStaffItem(ToolTiers.LUNITE, 0, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<ModArmorItem> LUNITE_HELMET = ITEMS.register("lunite_helmet",
            () -> new ModArmorItem(ArmorTiers.LUNITE, EquipmentSlot.HEAD, 0, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> LUNITE_CHESTPLATE = ITEMS.register("lunite_chestplate",
            () -> new ModArmorItem(ArmorTiers.LUNITE, EquipmentSlot.CHEST, 0, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> LUNITE_LEGGINGS = ITEMS.register("lunite_leggings",
            () -> new ModArmorItem(ArmorTiers.LUNITE, EquipmentSlot.LEGS, 0, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> LUNITE_BOOTS = ITEMS.register("lunite_boots",
            () -> new ModArmorItem(ArmorTiers.LUNITE, EquipmentSlot.FEET, 0, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> LUNITE_CROWN = ITEMS.register("lunite_crown",
            () -> new ModArmorItem(ArmorTiers.LUNITE_CROWN, EquipmentSlot.HEAD, 0, 0, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> WIDOW_SPAWN_EGG = ITEMS.register("widow_spawn_egg",
            () -> new ForgeSpawnEggItem(ModMobs.WIDOW, 0x100700, 0xef9805,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));


    public static final RegistryObject<Item> AMBER_STAFF = ITEMS.register("amber_staff",
            () -> new BambooStaffItem(ModBlocks.AMBER_SCAFFOLDING.get(), new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<AxeItem> DOOM_PENDULUM = ITEMS.register("doom_pendulum",
            () ->  new PendulumOfDoomItem(ToolTiers.DOOM, 1, -3.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.RARE)));
    public static final RegistryObject<SwordItem> AMBER_SWORD = ITEMS.register("amber_sword",
            () -> new AmberSwordItem(ToolTiers.AMBER, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<AxeItem> AMBER_AXE = ITEMS.register("amber_axe",
            () ->  new AxeItem(ToolTiers.AMBER, 7, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<PickaxeItem> AMBER_PICKAXE = ITEMS.register("amber_pickaxe",
            () ->  new PickaxeItem(ToolTiers.AMBER, 4, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<ShovelItem> AMBER_SHOVEL = ITEMS.register("amber_shovel",
            () ->  new ShovelItem(ToolTiers.AMBER, 4, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<HoeItem> AMBER_HOE = ITEMS.register("amber_hoe",
            () ->  new HoeItem(ToolTiers.AMBER, 1, 0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<Item> WIDOW_EYE = ITEMS.register("widow_eye",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_BREWING).food(Foodstuffs.WIDOW_EYE)));

    public static final RegistryObject<StaffItem> SPIDER_STAFF = ITEMS.register("spider_staff",
            () -> new SpiderStaffItem(ToolTiers.AMBER, 8, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<StaffItem> NETHERITE_STAFF = ITEMS.register("netherite_staff",
            () -> new NetheriteStaffItem(Tiers.NETHERITE, 2, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));


    //

    public static final RegistryObject<ModArmorItem> AMBER_HELMET = ITEMS.register("amber_helmet",
            () -> new ModArmorItem(ArmorTiers.AMBER, EquipmentSlot.HEAD, 0, 3, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> AMBER_CHESTPLATE = ITEMS.register("amber_chestplate",
            () -> new ModArmorItem(ArmorTiers.AMBER, EquipmentSlot.CHEST, 0, 8, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> AMBER_LEGGINGS = ITEMS.register("amber_leggings",
            () -> new ModArmorItem(ArmorTiers.AMBER, EquipmentSlot.LEGS, 0, 6, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> AMBER_BOOTS = ITEMS.register("amber_boots",
            () -> new ModArmorItem(ArmorTiers.AMBER, EquipmentSlot.FEET, 0, 3, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ModArmorItem> AMBER_CROWN = ITEMS.register("amber_crown",
            () -> new ModArmorItem(ArmorTiers.AMBER_CROWN, EquipmentSlot.HEAD, 0, 3, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static class ToolTiers {
        public static final Tier ROSEGOLD = new ForgeTier(2, 280, 12f, 0, 12, null, () -> Ingredient.of(ModItems.ROSEGOLD.get()));
        public static final Tier CELESTINE = new ForgeTier(5, 1200, 10f, 0, 8, null, () -> Ingredient.of(ModItems.CELESTINE_CRYSTAL.get()));
        public static final Tier LUNITE = new ForgeTier(5, -1, 8f, 0, 8, null, () -> Ingredient.of(ModItems.LUNITE_DUST.get()));
        public static final Tier BAMBOO = new ForgeTier(1, 20, 8f, 0, 0, null, () -> Ingredient.of(ModItems.LUNITE_DUST.get()));
        public static final Tier DOOM = new ForgeTier(1, 100, 8f, 0, 5, null, () -> Ingredient.of(Items.MAGMA_CREAM));
        public static final Tier AMBER = new ForgeTier(3, 777, 4f, 0, 10, null, () -> Ingredient.of(ModItems.LUNITE_DUST.get()));

        public static final Tier AMBER_HOE = new ForgeTier(3, 999, 4f, 0, 10, null, () -> Ingredient.of(ModItems.LUNITE_DUST.get()));

    }

    public static class ArmorTiers {
        public static final ArmorMaterial ROSE_GOLD = new com.barryb.hokum.custom.ArmorMaterials("rose_gold", 12, new int[] {2, 5, 6, 2}, 12, SoundEvents.ARMOR_EQUIP_GOLD,1, 0, () -> Ingredient.of(ModItems.ROSEGOLD.get()));
        public static final ArmorMaterial ROSE_GOLD_CROWN = new com.barryb.hokum.custom.ArmorMaterials("rose_crown", 12, new int[] {1, 1, 1, 2}, 12, SoundEvents.ARMOR_EQUIP_GOLD, 0, 0, () -> Ingredient.of(ModItems.ROSEGOLD.get()));
        public static final ArmorMaterial CELESTINE = new ArmorMaterials("celestine", 31, new int[] {3, 6, 8, 3}, 10, SoundEvents.ENCHANTMENT_TABLE_USE, 2, 0, () -> Ingredient.of(ModItems.ROSEGOLD.get()));
        public static final ArmorMaterial CELESTINE_CROWN = new ArmorMaterials("celestine_crown", 31, new int[] {1, 1, 1, 3}, 10, SoundEvents.ENCHANTMENT_TABLE_USE, 2, 0, () -> Ingredient.of(ModItems.ROSEGOLD.get()));
        public static final ArmorMaterial LUNITE = new com.barryb.hokum.custom.ArmorMaterials("lunite", -1, new int[] {3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_GOLD, 3, 0.3f, () -> Ingredient.of(ModItems.LUNITE_DUST.get()));
        public static final ArmorMaterial LUNITE_CROWN = new ArmorMaterials("lunite_crown", -1, new int[] {1, 1, 1, 3}, 10, SoundEvents.ARMOR_EQUIP_GOLD, 3, 0.3f, () -> Ingredient.of(ModItems.LUNITE_DUST.get()));

        public static final ArmorMaterial AMBER = new ArmorMaterials("amber", 28, new int[] {2, 3, 4, 2}, 10, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () -> Ingredient.of(ModItems.ROSEGOLD.get()));
        public static final ArmorMaterial AMBER_CROWN = new ArmorMaterials("amber_crown", 28, new int[] {0, 0, 0, 2}, 10, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () -> Ingredient.of(ModItems.ROSEGOLD.get()));

        public static final FlowerCrownMaterial BLINDFOLD = new FlowerCrownMaterial("blindfold", () -> Ingredient.of(ItemTags.WOOL));

        public static final FlowerCrownMaterial RED_FLOWER = new FlowerCrownMaterial("red_flower", () -> Ingredient.of(Items.VINE));
        public static final FlowerCrownMaterial ORANGE_FLOWER = new FlowerCrownMaterial("orange_flower", () -> Ingredient.of(Items.VINE));
        public static final FlowerCrownMaterial YELLOW_FLOWER = new FlowerCrownMaterial("yellow_flower", () -> Ingredient.of(Items.VINE));
        public static final FlowerCrownMaterial BLUE_FLOWER = new FlowerCrownMaterial("blue_flower", () -> Ingredient.of(Items.VINE));
        public static final FlowerCrownMaterial PURPLE_FLOWER = new FlowerCrownMaterial("purple_flower", () -> Ingredient.of(Items.VINE));

        public static final FlowerCrownMaterial PINK_FLOWER = new FlowerCrownMaterial("pink_flower", () -> Ingredient.of(Items.VINE));

        public static final FlowerCrownMaterial BLACK_FLOWER = new FlowerCrownMaterial("black_flower", () -> Ingredient.of(Items.VINE));

        public static final FlowerCrownMaterial WHITE_FLOWER = new FlowerCrownMaterial("white_flower", () -> Ingredient.of(Items.VINE));

    }

    public static class Foodstuffs {
        public static final FoodProperties ROSE_GOLD_CARROT = new FoodProperties.Builder().nutrition(6).saturationMod(1.1f).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 60, 0), 1.0f).build();
        public static final FoodProperties WIDOW_EYE = new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.POISON, 120, 2), 1.0f).build();

    }
}

