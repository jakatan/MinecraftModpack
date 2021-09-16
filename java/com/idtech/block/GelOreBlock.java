package com.idtech.block;

import com.idtech.BaseMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class GelOreBlock extends Block {

    private static Properties properties = Properties.create(Material.ROCK).func_235861_h_().hardnessAndResistance(1.5f,3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(3);
    public static Block INSTANCE = new GelOreBlock(properties).setRegistryName(BaseMod.MODID, "geloreblock");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    public GelOreBlock(Properties properties) {
        super(properties);
    }
}
