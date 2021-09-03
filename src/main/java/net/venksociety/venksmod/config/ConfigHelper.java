package net.venksociety.venksmod.config;

import net.minecraftforge.fml.config.ModConfig;

public class ConfigHelper {
    private static net.minecraftforge.fml.config.ModConfig config;

    public static void init(final ModConfig config) {
        ConfigHelper.config = config;
    }
}