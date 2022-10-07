package github.vortexren.skyblock;

import github.vortexren.skyblock.commands.ServerCommand;
import lombok.Getter;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public final class SkyblockProxy extends Plugin {
    @Getter
    private static SkyblockProxy plugin;

    @Override
    public void onEnable() {
        this.plugin = plugin;

        registerClasses();
    }

    //public utilities
    public static void sendConsoleMessage(String s){
        plugin.getProxy().getConsole().sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }


    //register all loadable classes
    private void registerClasses() {
        registerCommand(new ServerCommand());
    }

    //method to make registering commands faster
    private void registerCommand(Command command) {
        getProxy().getPluginManager().registerCommand(this, command);
    }

    //method to register listeners easier
    private void registerListener(Listener listener) {
        getProxy().getPluginManager().registerListener(this, listener);
    }
}
