package net.venksociety.venksmod;

import com.mojang.brigadier.CommandDispatcher;
import net.venksociety.venksmod.commands.*;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public final class CommandRegistry {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final List<BaseMessageCommand> commands = new ArrayList<>();

    private static final CmdHelloWorld helloworld = new CmdHelloWorld(true, "helloworld", 0);

    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();

        commands.add(helloworld);

        commands.forEach(command -> {
            LOGGER.debug("COMMAND: /" + command.getName() + " => enabled: " + String.valueOf(command.isEnabled()).toUpperCase());
            if (command.isEnabled()) {
                dispatcher.register(command.register());
            }
        });
    }
}