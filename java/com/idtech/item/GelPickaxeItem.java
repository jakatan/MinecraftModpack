package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GelPickaxeItem extends PickaxeItem {

    public static IItemTier tier = ItemUtils.buildItemTier(3, 1561, 8.0F, 0.3F, 10, "examplemod:gelore");
    public static Item INSTANCE = new GelPickaxeItem(tier,2, 100, new Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelpickaxe");

    public GelPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //get the held item for return
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        //find the location at the cursor
        BlockPos location = Utils.getBlockAtCursor(playerIn, 20.0d, true);
        //as long as the location exists
        if(location != null){
            //create an explosion
            playerIn.getCooldownTracker().setCooldown(this, 20);
            Utils.createExplosion(worldIn, location, 10.2f);
            //strike lightning
            Utils.strikeLightning(worldIn, location);
            //return success
            return ActionResult.resultSuccess(itemstack);
        } else {
            //return a fail
            return ActionResult.resultFail(itemstack);
        }
    }

}