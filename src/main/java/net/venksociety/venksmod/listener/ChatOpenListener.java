package net.venksociety.venksmod.listener;

import net.venksociety.venksmod.VenksMod;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = VenksMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChatOpenListener {
    public static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public void onOpenGui(GuiScreenEvent.InitGuiEvent event) {
        if (event.getGui().getClass() == ChatScreen.class) {
            ClientPlayerEntity player = event.getGui().getMinecraft().player;

            /*LOGGER.info("player == null | " + (player == null));
            if (player == null) return;*/
        }
    }
}