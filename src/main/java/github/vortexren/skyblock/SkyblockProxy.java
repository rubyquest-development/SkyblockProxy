package github.vortexren.skyblock;

import github.vortexren.skyblock.commands.ServerCommand;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public final class SkyblockProxy extends Plugin {

    @Override
    public void onEnable() {
        registerCommands();
    }


    public void registerCommands() {
        registerCommand(new ServerCommand());
    }


    //method to make registering commands faster
    private void registerCommand(Command command) {
        getProxy().getPluginManager().registerCommand(this, command);
    }
}
