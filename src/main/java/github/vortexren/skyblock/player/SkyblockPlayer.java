package github.vortexren.skyblock.player;

import github.vortexren.skyblock.SkyblockProxy;
import github.vortexren.skyblock.sql.tables.PlayerTable;
import github.vortexren.skyblock.utilities.ChatUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkyblockPlayer {
    public static File PLAYER_FOLDER = new File(SkyblockProxy.getPlugin().getDataFolder(), "./players");
    public static Map<UUID, SkyblockPlayer> PLAYER_CACHE = new HashMap<>();

    public static PlayerTable table = new PlayerTable();

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
        player.disconnect(ChatColor.translateAlternateColorCodes('&', reason));
        SkyblockProxy.sendConsoleMessage("&c" + player.getName() + " has been kicked from the server for: " + reason);
    }

    public void ban(String reason) {
        StringBuilder builder = new StringBuilder();
        builder.append(ChatColor.translateAlternateColorCodes('&', "&cYou are permanently banned from this server!"));
        builder.append("\n");
        builder.append("\n");
        builder.append(ChatColor.translateAlternateColorCodes('&', "&7Reason: &f" + reason));
        builder.append("\n");
        builder.append(ChatColor.translateAlternateColorCodes('&', "&7Find out more: &bhttps://discord.gg/kKEYcZpfbj"));

        player.disconnect(builder.toString());

        table.setBoolean(player.getUniqueId(), "BANNED",  true);
        table.setString(player.getUniqueId(), "BANREASON", reason);
    }

    //SQL

    public void createPlayer(UUID uuid) {
        try {
            if (!playerSQLExists(uuid)) {
                PreparedStatement statement2;
                statement2 = SkyblockProxy.getPlugin().getSQLConnection().getConnection().prepareStatement("INSERT IGNORE INTO playerTable(NAME,UUID) VALUES (?,?)");
                statement2.setString(1, player.getName());
                statement2.setString(2, uuid.toString());

                statement2.executeUpdate();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public boolean playerSQLExists(UUID uuid) {
        try {
            PreparedStatement statement;
            statement = SkyblockProxy.getPlugin().getSQLConnection().getConnection().prepareStatement("SELECT * from playerTable WHERE UUID=?");
            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()) {
                return true;
            }
            return false;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
