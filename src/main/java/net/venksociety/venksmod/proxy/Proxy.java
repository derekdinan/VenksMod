package net.venksociety.venksmod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface Proxy {

    void init();

    Minecraft getClient();

    World getWorld();

    PlayerEntity getPlayer();

}
