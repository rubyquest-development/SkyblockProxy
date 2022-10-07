package github.vortexren.skyblock.player;

import github.vortexren.skyblock.SkyblockProxy;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SkyblockPlayer {
    public static File PLAYER_FOLDER = new File(SkyblockProxy.getPlugin().getDataFolder(), "./players");
    public static Map<UUID, SkyblockPlayer> PLAYER_CACHE;

    public File PLAYER_FILE;

    public SkyblockPlayer(ProxiedPlayer player) {
        this.PLAYER_FILE = new File(PLAYER_FOLDER, player.getUniqueId().toString());

        PLAYER_CACHE.put(player.getUniqueId(), this);

    }
}
