package net.venksociety.venksmod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ServerProxy implements Proxy {

    @Override
    public void init() {

    }

    @Override
    public Minecraft getClient() {
        return null;
    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public PlayerEntity getPlayer() {
        return null;
    }

}