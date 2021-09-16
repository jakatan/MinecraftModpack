package com.idtech.block;

import com.idtech.BaseMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Properties;

public class HotCoalsBlock extends Block {
    private static Properties properties = Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE);
    public static Block INSTANCE = new HotCoalsBlock(properties).setRegistryName(BaseMod.MODID, "hotcoals");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    public HotCoalsBlock(Properties properties) {
        super(properties);
    }
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityWalk(worldIn, pos, entityIn);
        entityIn.setFire(1);
    }

}
