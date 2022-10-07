package github.vortexren.skyblock.listener;

import github.vortexren.skyblock.player.SkyblockPlayer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerListener implements Listener {
    @EventHandler
    public void PostLoginEvent(PostLoginEvent event) {
        SkyblockPlayer.getPlayer(event.getPlayer()).createPlayer();

        if (SkyblockPlayer.table.fetchBoolean(event.getPlayer().getUniqueId(), "BANNED")) {
            StringBuilder builder = new StringBuilder();
            builder.append(ChatColor.translateAlternateColorCodes('&', "&cYou are permanently banned from this server!"));
            builder.append("\n");
            builder.append("\n");
            builder.append(ChatColor.translateAlternateColorCodes('&', "&7Reason: &f" + SkyblockPlayer.table.fetchString(event.getPlayer().getUniqueId(), "BANREASON")));
            builder.append("\n");
            builder.append(ChatColor.translateAlternateColorCodes('&', "&7Find out more: &bhttps://discord.gg/kKEYcZpfbj"));

            event.getPlayer().disconnect(builder.toString());
        }
    }
}
