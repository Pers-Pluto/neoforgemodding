package net.asrin.neoforgemodding.registry;

import java.util.function.Supplier;

import net.asrin.neoforgemodding.NeoforgeModding;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NeoforgeModding.MODID);

    public static final DeferredBlock<Block> COLORFUL_BEESWAX_BLOCK = registerBlock("colorful_beeswax_block", 
        () -> new Block(BlockBehaviour.Properties.of()));




    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block ) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block); // First we register a block as a block in the world.
        ModBlocks.registerBlockItem(name, toReturn); // then we register it as an item
        return toReturn;
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
