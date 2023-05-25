package net.Qaalum.powersticks.item;

import net.Qaalum.powersticks.PowerSticks;
import net.Qaalum.powersticks.item.custom.PowerStickItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PowerSticksItems {

    public static final ItemGroup POWER_STICKS = FabricItemGroup.builder(new Identifier(PowerSticks.MOD_ID))
            .displayName(Text.literal("Power Sticks"))
            .build();

    public static final Item SCEPTER = registerItem(
            "scepter",
            new PowerStickItem(new Item.Settings()),
            POWER_STICKS
    );
    public static final Item WAND = registerItem(
            "wand",
            new PowerStickItem(new Item.Settings()),
            POWER_STICKS
    );

    public static final Item HOCUS = registerItem(
            "hocus",
            new PowerStickItem.KillStickItem(new Item.Settings()),
            POWER_STICKS
    );
    public static final Item POCUS = registerItem(
            "pocus",
            new PowerStickItem.KillStickItem(new Item.Settings()),
            POWER_STICKS
    );



    private static Item registerItem(String name, Item item, ItemGroup group) {
        return Registry.register(Registries.ITEM, new Identifier(PowerSticks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PowerSticks.LOGGER.debug("Registering mod items for" + PowerSticks.MOD_ID);
    }
}
