package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;

public class GelShovelItem extends ShovelItem {
    public static IItemTier tier = ItemUtils.buildItemTier(0, 1561, 8.0F, 0.3F, 10, "examplemod:gelore");
    public static Item INSTANCE = new GelShovelItem(tier,2, 100, new Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelshovel");

    public GelShovelItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
