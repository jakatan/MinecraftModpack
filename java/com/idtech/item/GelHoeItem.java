package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class GelHoeItem extends HoeItem {
    public static IItemTier tier = ItemUtils.buildItemTier(0, 1561, 8.0F, 0.3F, 10, "examplemod:gelore");
    public static Item INSTANCE = new GelHoeItem(tier,2, 50, new Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelhoe");

    public GelHoeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
