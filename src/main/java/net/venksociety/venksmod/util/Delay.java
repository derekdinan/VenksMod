package net.venksociety.venksmod.util;

import net.venksociety.venksmod.VenksMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VenksMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Delay {
    private final Runnable runnable;
    private final int delay;
    int pressTime;

    public Delay(Runnable runnable, int ticks) {
        this.runnable = runnable;
        this.delay = ticks;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.ClientTickEvent event) {
        if (pressTime == delay) {
            runnable.run();
            MinecraftForge.EVENT_BUS.unregister(this);
        }
        pressTime++;
    }

}