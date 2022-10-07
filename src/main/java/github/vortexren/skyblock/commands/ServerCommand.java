package github.vortexren.skyblock.commands;

import github.vortexren.skyblock.utilities.ChatUtils;
import github.vortexren.skyblock.utilities.ProxyUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class ServerCommand extends Command{
    public ServerCommand() {
        super("gotoserver", "skyblock.travelservers", "travel", "servertravel");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            ChatUtils.sendMessage("&cThis command can only be used by players, sorry!", sender);
            return;
        }

        if (args.length < 1) {
            ChatUtils.sendMessage("&cYou must supply a server destination!", sender);
            return;
        }

        String server = args[0].toLowerCase();

        if (server == "alpha") {
            ((ProxiedPlayer) sender).connect(ProxyUtils.getServer("alphaserver"));
        }
        if (server == "test") {
            ((ProxiedPlayer) sender).connect(ProxyUtils.getServer("testserver"));
        }

    }
}
