package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class CreepingMoldBlock extends Block {

    private static Properties properties = Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).tickRandomly();
    public static Block INSTANCE = new CreepingMoldBlock(properties).setRegistryName(BaseMod.MODID, "creepingmoldblock");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);
    public CreepingMoldBlock(Properties properties){
        super(properties);
    }
    @Override
    public void randomTick(BlockState block, ServerWorld world, BlockPos pos, Random rand) {
        super.tick(block, world, pos, rand);
        BlockPos blockPos = Utils.findNeightborBlock(pos);
        if (blockPos != null) {
            world.setBlockState(blockPos, this.getDefaultState());
        }
    }

}
