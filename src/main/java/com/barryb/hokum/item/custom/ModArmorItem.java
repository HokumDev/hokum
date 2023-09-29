package com.barryb.hokum.item.custom;

import com.barryb.hokum.entity.ModAttributes;
import com.barryb.hokum.item.ModItems;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ModArmorItem extends ArmorItem {
    private static final UUID[] ARMOR_MODIFIER_UUID_PER_SLOT = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private final EquipmentSlot slot;
    private final int defense;
    private final float toughness;
    protected final float knockbackResistance;
    protected final ArmorMaterial material;


    public ModArmorItem(ArmorMaterial p_40386_, EquipmentSlot p_40387_, double speedBoost, int maxHealth, Properties p_40388_) {
        super(p_40386_, p_40387_, p_40388_);
        this.material = p_40386_;
        this.slot = p_40387_;
        this.defense = p_40386_.getDefenseForSlot(p_40387_);
        this.toughness = p_40386_.getToughness();
        this.knockbackResistance = p_40386_.getKnockbackResistance();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        UUID uuid = ARMOR_MODIFIER_UUID_PER_SLOT[p_40387_.getIndex()];
        builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", (double)this.defense, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", (double)this.toughness, AttributeModifier.Operation.ADDITION));
        if (this.knockbackResistance > 0) {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", (double)this.knockbackResistance, AttributeModifier.Operation.ADDITION));
        }
        if(speedBoost > 0){ builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "Speed Modifier", speedBoost, AttributeModifier.Operation.ADDITION));
        }

        builder.put(Attributes.MAX_HEALTH, new AttributeModifier(uuid, "Max Health", maxHealth, AttributeModifier.Operation.ADDITION));

        this.defaultModifiers = builder.build();
    }

    public ModArmorItem(ArmorMaterial p_40386_, EquipmentSlot p_40387_, double speedBoost, Properties p_40388_, int stealth) {
        super(p_40386_, p_40387_, p_40388_);
        this.material = p_40386_;
        this.slot = p_40387_;
        this.defense = p_40386_.getDefenseForSlot(p_40387_);
        this.toughness = p_40386_.getToughness();
        this.knockbackResistance = p_40386_.getKnockbackResistance();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        UUID uuid = ARMOR_MODIFIER_UUID_PER_SLOT[p_40387_.getIndex()];
        builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", (double)this.defense, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", (double)this.toughness, AttributeModifier.Operation.ADDITION));
        if (this.knockbackResistance > 0) {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", (double)this.knockbackResistance, AttributeModifier.Operation.ADDITION));
        }
        if(speedBoost > 0){ builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "Speed Modifier", speedBoost, AttributeModifier.Operation.ADDITION));
        }
        if(stealth > 0){ builder.put(ModAttributes.STEALTH.get(), new AttributeModifier(uuid, "Stealth", stealth, AttributeModifier.Operation.ADDITION));
        }

        this.defaultModifiers = builder.build();
    }


    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_40390_) {
        return p_40390_ == this.slot ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_40390_);
    }

    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        if(material == ModItems.ArmorTiers.LUNITE || material == ModItems.ArmorTiers.LUNITE_CROWN){
            components.add(Component.literal("Unbreakable").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));
        }
    }




}
