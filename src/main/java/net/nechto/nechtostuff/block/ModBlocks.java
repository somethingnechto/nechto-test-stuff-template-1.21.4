package net.nechto.nechtostuff.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nechto.nechtostuff.NechtoTestStuff;

public class ModBlocks {

    public static final Block MAGIC_ROCK_ORE = registerBlock("magic_rock_ore",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NechtoTestStuff.MOD_ID, "magic_rock_ore")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(NechtoTestStuff.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(NechtoTestStuff.MOD_ID, name), new BlockItem(block,
                new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NechtoTestStuff.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        NechtoTestStuff.LOGGER.info("Registering mod blocks for " + NechtoTestStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.MAGIC_ROCK_ORE);
        });
    }
}
