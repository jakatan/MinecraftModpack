package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

public class GelSwordItem extends SwordItem {
    public static IItemTier tier = ItemUtils.buildItemTier(0, 1561, 8.0F, 8.0F, 10, "examplemod:gelore");
    public static Item INSTANCE = new GelSwordItem(tier,50, 100, new Properties().group(ItemGroup.COMBAT)).setRegistryName(BaseMod.MODID,"gelsword");

    public GelSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
