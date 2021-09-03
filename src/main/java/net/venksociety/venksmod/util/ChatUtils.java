package net.venksociety.venksmod.util;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.StringTextComponent;

public final class ChatUtils {

    public static void format(String format, String message) {

    }

    public static void sendToAllPlayers(MinecraftServer server, ServerPlayerEntity player, String message, String format) {
        String finalMessage = translateColorCodes(format
                .replaceAll("%player%", player.getName().getString())
                .replaceAll("%message%", message));

        for (ServerPlayerEntity serverPlayer : server.getPlayerList().getPlayers()) {
            serverPlayer.sendMessage(new StringTextComponent(finalMessage), player.getUUID());
        }
    }

    public static String translateColorCodes(String textToTranslate) {
        char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1) {
                b[i] = '\u00A7';
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }
        return new String(b);
    }
}