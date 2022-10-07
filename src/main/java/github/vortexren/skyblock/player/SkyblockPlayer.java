package github.vortexren.skyblock.player;

import github.vortexren.skyblock.SkyblockProxy;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.io.File;
import java.util.Map;
import java.util.UUID;

public class SkyblockPlayer {
    public static File PLAYER_FOLDER = new File(SkyblockProxy.getPlugin().getDataFolder(), "./players");
    public static Map<UUID, SkyblockPlayer> PLAYER_CACHE;

    private ProxiedPlayer player;

    public SkyblockPlayer(ProxiedPlayer player) {
        //this.PLAYER_FILE = new File(PLAYER_FOLDER, player.getUniqueId().toString());

        PLAYER_CACHE.put(player.getUniqueId(), this);
        this.player = player;
    }

    public static SkyblockPlayer getPlayer(ProxiedPlayer player) {
        if (PLAYER_CACHE.containsKey(player.getUniqueId())) {
            return PLAYER_CACHE.get(player.getUniqueId());
        } else {
            return new SkyblockPlayer(player);
        }
    }

    public void kick(String reason) {
        player.disconnect(reason);
        SkyblockProxy.sendConsoleMessage("&c" + player.getName() + " has been kicked from the server for: " + reason);
    }
}
