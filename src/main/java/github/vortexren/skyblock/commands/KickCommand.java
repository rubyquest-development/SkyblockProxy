package github.vortexren.skyblock.commands;

import github.vortexren.skyblock.SkyblockProxy;
import github.vortexren.skyblock.player.SkyblockPlayer;
import github.vortexren.skyblock.utilities.ChatUtils;
import github.vortexren.skyblock.utilities.ProxyUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class KickCommand extends Command{
    public KickCommand() {
        super("kick", "skyblock.kick", "sbkick", "proxydisconnect");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (args.length < 2) {
            ChatUtils.sendMessage("&cYou must supply the correct arguments to use this command!", sender);
            return;
        }

        ProxiedPlayer plrToKick = SkyblockProxy.getPlayer(args[0]);
        SkyblockPlayer sbPlayer = SkyblockPlayer.getPlayer(plrToKick);

        StringBuilder builder = new StringBuilder();

        int startArg = 1;
        int endArg = args.length;
        for(int i = startArg; i< endArg; i++){
            builder.append(args[i] + (args.length > (i+1) ? " " : ""));
        }

        sbPlayer.kick(builder.toString());

    }
}
