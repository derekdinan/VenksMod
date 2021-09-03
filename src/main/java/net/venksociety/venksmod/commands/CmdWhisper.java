package net.venksociety.venksmod.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.venksociety.venksmod.config.ConfigValues;
import net.venksociety.venksmod.util.ChatUtils;
import net.venksociety.venksmod.util.PlayerUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;

public class CmdWhisper extends BaseMessageCommand {

    public CmdWhisper(boolean enabled, String name, int permissionLevel) {
        super(enabled, name, permissionLevel);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ITextComponent textComponent = MessageArgument.getMessage(context, "message");
        CommandSource source = context.getSource();
        ServerPlayerEntity player = source.getPlayerOrException();
        String message = textComponent.getString();

        message = ChatUtils.translateColorCodes(message)
                .replaceAll("%player%", player.getName().getString())
                .replaceAll("%message%", message);

        return SINGLE_SUCCESS;
    }
}