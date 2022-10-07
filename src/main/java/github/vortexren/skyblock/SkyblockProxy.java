package github.vortexren.skyblock;

import github.vortexren.skyblock.commands.BanCommand;
import github.vortexren.skyblock.commands.KickCommand;
import github.vortexren.skyblock.commands.ServerCommand;
import github.vortexren.skyblock.listener.PlayerListener;
import github.vortexren.skyblock.player.SkyblockPlayer;
import github.vortexren.skyblock.sql.SQLConnection;
import lombok.Getter;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

import java.sql.SQLException;
import java.util.UUID;

public final class SkyblockProxy extends Plugin {
    @Getter
    private static SkyblockProxy plugin;

    @Getter
    public SQLConnection SQLConnection;

    @Override
    public void onEnable() {
        this.plugin = this;
        this.SQLConnection = new SQLConnection();

        try {
            this.SQLConnection.connect();
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }

        SkyblockPlayer.table.createTable();


        registerClasses();
    }

    //public utilities
    public static void sendConsoleMessage(String s){
        plugin.getProxy().getConsole().sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    //method for pure convenience
    public static ProxiedPlayer getPlayer(UUID uuid) {
        return plugin.getProxy().getPlayer(uuid);
    }

    //method for pure convenience
    public static ProxiedPlayer getPlayer(String name) {
        return plugin.getProxy().getPlayer(name);
    }

    //register all loadable classes
    private void registerClasses() {
        registerCommand(new ServerCommand());
        registerCommand(new KickCommand());
        registerCommand(new BanCommand());

        registerListener(new PlayerListener());
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
