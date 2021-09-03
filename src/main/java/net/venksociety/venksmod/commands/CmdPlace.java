package net.venksociety.venksmod.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.venksociety.venksmod.util.ChatUtils;

public class CmdPlace extends BaseMessageCommand {

    public CmdPlace(boolean enabled, String name, int permissionLevel) {
        super(enabled, name, permissionLevel);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ITextComponent textComponent = MessageArgument.getMessage(context, "message");
        CommandSource source = context.getSource();

        ServerPlayerEntity player = source.getPlayerOrException();
        World world = player.getCommandSenderWorld();
        String message = textComponent.getString();

        message = ChatUtils.translateColorCodes(message)
                .replaceAll("%player%", player.getName().getString())
                .replaceAll("%message%", message);

        MinecraftServer server = world.getServer();

        //player.sendMessage("hi");

        //ITextComponent textComponent2 = MessageArgument.getMessage(context, "message test");
        //player.sendMessage(textComponent2, player.getUUID());

        world.addBlockEntity(stone)

        ChatUtils.sendToAllPlayers(server, player, message, "Hello, world.");

        return SINGLE_SUCCESS;
    }
}