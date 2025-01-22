package net.nechto.nechtostuff.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nechto.nechtostuff.NechtoTestStuff;


public class ModItems {
    public static final Item MAGIC_ROCK = registerItem("magic_rock", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NechtoTestStuff.MOD_ID,"magic_rock")))));
    public static final Item MAGIC_GEODE = registerItem("magic_geode", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NechtoTestStuff.MOD_ID,"magic_geode")))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(NechtoTestStuff.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NechtoTestStuff.LOGGER.info("Registering mod items for - " + NechtoTestStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(MAGIC_ROCK);
            fabricItemGroupEntries.add(MAGIC_GEODE);
        });
    }

}
