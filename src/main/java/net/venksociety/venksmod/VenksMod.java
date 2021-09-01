package net.venksociety.venksmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.venksociety.venksmod.setup.Registration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VenksMod.MOD_ID)
public class VenksMod {
    public static final String MOD_ID = "venksmod";

    private static final Logger LOGGER = LogManager.getLogger();

    public VenksMod() {
        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
