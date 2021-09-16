package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.Utils;
import com.idtech.block.CreepingMoldBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class ZomboEntity extends ZombieEntity {

    //TYPE
    public static EntityType<ZomboEntity> TYPE = (EntityType<ZomboEntity>) EntityType.Builder.create(ZomboEntity::new, EntityClassification.MONSTER).build("zombo").setRegistryName(BaseMod.MODID, "zombo");

    //EGG
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);

    //setupAttributes method.
    public static AttributeModifierMap.MutableAttribute setupAttributes() {

        return EntityUtils.addAttributes(true, 15, 35.0, 0.01, 0.43, 1.0, 2, 3);
    }

    //constructor
    public ZomboEntity(World worldIn) {
        super(TYPE, worldIn);
    }

    public ZomboEntity(EntityType type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public void registerGoals() { // ai programming
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new ZombieAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::isBreakDoorsTaskSet));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.TARGET_DRY_BABY));


    }

    @Nullable
    @Override // extra stuff for spawning
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        //necessary idk why but it throws an erro
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, null);
        this.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 1000, 2));
        int random = world.rand.nextInt(100);

        if (random < 10) {
            PolarBearEntity polarbear = (PolarBearEntity) Utils.spawnEntity(world, EntityType.POLAR_BEAR, this.getPositionUnderneath());
            this.startRiding(polarbear);
        }
        if (random > 10 && random < 25) {
            //set the held item to golden axe. and give it a helmet
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_AXE));
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.GOLDEN_HELMET));
        }
        if (random > 30 && random < 40) {
            SkeletonHorseEntity horse = (SkeletonHorseEntity) Utils.spawnEntity(world, EntityType.SKELETON_HORSE, this.getPositionUnderneath());
            this.startRiding(horse);
        }


        return spawnDataIn;
    }

    //inventory drop method
    @Override
    protected void dropInventory() {
        super.dropInventory();

        //check every slot in the entity
        for (EquipmentSlotType slot : EquipmentSlotType.values()) {
            //if there is something in that slot
            if (this.hasItemInSlot(slot)) {
                //drop it
                this.entityDropItem(this.getItemStackFromSlot(slot));
            }

        }


    }
}
