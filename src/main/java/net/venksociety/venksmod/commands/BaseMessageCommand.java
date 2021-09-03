package net.venksociety.venksmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.MessageArgument;

public abstract class BaseMessageCommand implements Command<CommandSource> {
    private final boolean enabled;
    private final String name;
    private final int permissionLevel;

    public BaseMessageCommand(boolean enabled, String name, int permissionLevel) {
        this.enabled = enabled;
        this.name = name;
        this.permissionLevel = permissionLevel;
    }

    public LiteralArgumentBuilder<CommandSource> register() {
        return Commands.literal(name)
                .requires(cs -> cs.hasPermission(permissionLevel))
                .then(Commands.argument("message", MessageArgument.message()).executes(this));
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public String getName() {
        return name;
    }
}