package net.venksociety.venksmod.listener;

import net.venksociety.venksmod.VenksMod;
import net.venksociety.venksmod.config.ConfigHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = VenksMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModConfigListener {

    @SubscribeEvent
    public static void onModConfigEvent(ModConfig.ModConfigEvent event) {
        final ModConfig config = event.getConfig();
        ConfigHelper.init(config);
    }

}