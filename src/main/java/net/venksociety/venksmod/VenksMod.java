package net.venksociety.venksmod;

import net.venksociety.venksmod.config.ConfigPairing;
import net.venksociety.venksmod.listener.ChatListener;
import net.venksociety.venksmod.listener.ChatOpenListener;
import net.venksociety.venksmod.proxy.ClientProxy;
import net.venksociety.venksmod.proxy.Proxy;
import net.venksociety.venksmod.proxy.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VenksMod.MODID)
public class VenksMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Proxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    public static final String MODID = "venksmod";

    public VenksMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();

        modEventBus.addListener(this::onCommonSetup);
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigPairing.SPEC);

        MinecraftForge.EVENT_BUS.register(new ChatListener());
        MinecraftForge.EVENT_BUS.register(new ChatOpenListener());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        PROXY.init();
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        LOGGER.info("Commands registering...");
        CommandRegistry.registerCommands(event);
        LOGGER.info("Command registered!");
    }

    @SubscribeEvent
    public void onJoinWorld(EntityJoinWorldEvent event) {

    }
}