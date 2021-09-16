package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class GelAxeItem extends AxeItem {
    public static IItemTier tier = ItemUtils.buildItemTier(0, 1561, 12.0F, 2.0F, 10, "examplemod:gelore");
    public static Item INSTANCE = new GelAxeItem(tier,6, 100, new Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelaxe");

    public GelAxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
