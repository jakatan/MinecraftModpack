package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Properties;

public class CreeperSurpriseBlock extends Block {

    private static Properties properties = Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE);
    public static Block INSTANCE = new CreeperSurpriseBlock(properties).setRegistryName(BaseMod.MODID, "creeper_surprise_block");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);


    public CreeperSurpriseBlock(Properties properties) {
        super(properties);

    }


    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState blockstate, PlayerEntity player) {
        super.onBlockHarvested(worldIn, pos, blockstate, player);
        ExperienceOrbEntity exp = new ExperienceOrbEntity(worldIn, player.getPosX(), player.getPosY(),
                player.getPosZ(), 1000);
        worldIn.addEntity(exp);
        Utils.spawnEntity(worldIn, EntityType.CREEPER, pos);

    }
}