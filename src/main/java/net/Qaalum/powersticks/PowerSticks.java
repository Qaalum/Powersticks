package net.Qaalum.powersticks;

import net.Qaalum.powersticks.item.PowerSticksItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerSticks implements ModInitializer {
	public static final String MOD_ID ="powersticks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		PowerSticksItems.registerModItems();
	}
}
