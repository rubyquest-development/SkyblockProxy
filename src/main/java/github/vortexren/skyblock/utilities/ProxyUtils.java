package github.vortexren.skyblock.utilities;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ProxyUtils {
    public static ServerInfo getServer(String server) {
        return ProxyServer.getInstance().getServerInfo(server);
    }
}