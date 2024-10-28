package net.asrin.neoforgemodding.registry;

import net.asrin.neoforgemodding.NeoforgeModding;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NeoforgeModding.MODID);

    public static final DeferredItem<Item> BEESWAX = ITEMS.register("beeswax", () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> BAKLAVA = ITEMS.register("baklava", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UNCOOKED_BAKLAVA = ITEMS.register("uncooked_baklava", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
