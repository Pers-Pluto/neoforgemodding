package net.asrin.neoforgemodding.registry;

import java.util.function.Supplier;

import net.asrin.neoforgemodding.NeoforgeModding;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NeoforgeModding.MODID);

    public static final Supplier<CreativeModeTab> NEOFORGEMODDING_TAB = CREATIVE_MODE_TABS.register("neoforgemodding", 
        () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.BAKLAVA.get())) // Icon
            .title(Component.translatable("creativetab.neoforgemodding.maintab")) // Name of main tab in lang file
            .displayItems((ItemDisplayParameters, output) -> {
                output.accept(ModItems.BAKLAVA);
                output.accept(ModItems.UNCOOKED_BAKLAVA);
            })
            .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
