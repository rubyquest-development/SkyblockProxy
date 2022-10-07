package github.vortexren.skyblock.utilities;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;

public class ChatUtils {
    public static void sendMessage(String message, CommandSender sender) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
