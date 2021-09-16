package com.idtech.item;

import javafx.scene.effect.Light;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class ItemMod {

    //BASIC ITEMS
    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", ItemGroup.MISC);
    public static final Item GEL_ORE = ItemUtils.buildBasicItem("gelore", ItemGroup.MISC);

    //FOODS

    public static Food PIZZA = (new Food.Builder()).hunger(5).saturation(1.4f).effect(new EffectInstance(Effects.LEVITATION, 1000, 1), 1.0F).setAlwaysEdible().build(); //hunger is half hearts, saturation is length of satisfaction
    public static Item PIZZAITEM = ItemUtils.buildFoodItem("pizza", PIZZA);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        event.getRegistry().register(STRUCTURE_GEL);
        event.getRegistry().register(GEL_ORE);

        // ITEMS
        event.getRegistry().register(TeleportRodItem.INSTANCE); //calls the file we just made
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        // TOOLS
        event.getRegistry().register(GelPickaxeItem.INSTANCE);
        event.getRegistry().register(GelSwordItem.INSTANCE);
        event.getRegistry().register(GelAxeItem.INSTANCE);
        event.getRegistry().register(GelHoeItem.INSTANCE);
        event.getRegistry().register(GelShovelItem.INSTANCE);
        // FOOD
        event.getRegistry().register(PIZZAITEM); //registering the item of pizza
        // ARMOR
        event.getRegistry().register(CustomArmorItem.BOOTS);
        event.getRegistry().register(CustomArmorItem.LEGGINGS);
        event.getRegistry().register(CustomArmorItem.CHEST);
        event.getRegistry().register(CustomArmorItem.HELM);
    }
}
