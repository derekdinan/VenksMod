package net.venksociety.venksmod.listener;

import net.venksociety.venksmod.VenksMod;
import net.venksociety.venksmod.config.ConfigValues;
import net.venksociety.venksmod.util.ChatUtils;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = VenksMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ChatListener {

    // Local Chat Override
    @SubscribeEvent
    public void onChatMessage(ServerChatEvent event) {
        /*if (!ConfigValues.LOCAL_ENABLED || !ConfigValues.LOCAL_OVERRIDE) return;

        ServerPlayerEntity player = event.getPlayer();
        String message = ChatUtils.translateColorCodes(event.getMessage())
                .replaceAll("%player%", player.getName().getString())
                .replaceAll("%message%", event.getMessage());

        event.setCanceled(true);*/
    }
}