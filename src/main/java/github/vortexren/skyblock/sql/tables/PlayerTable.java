package github.vortexren.skyblock.sql.tables;

import github.vortexren.skyblock.SkyblockProxy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerTable implements SQLTable{
    SkyblockProxy plugin = SkyblockProxy.getPlugin();
    
    @Override
    public void createTable() {
        PreparedStatement statement;

        try {
            statement = plugin.getSQLConnection().getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS playerTable" + "(NAME VARCHAR(100),UUID VARCHAR(100),BANREASON VARCHAR(100),BANNED BOOLEAN,PRIMARY KEY (UUID))");
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public String fetchString(UUID uuid, String value) {
        PreparedStatement statement;

        try {
            statement = plugin.getSQLConnection().getConnection().prepareStatement("SELECT " + value + " FROM playerTable WHERE UUID=?");
            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return set.getString(value);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "RESULT_NOT_SET";
    }

    @Override
    public int fetchInt(UUID uuid, String value) {
        PreparedStatement statement;

        try {
            statement = plugin.getSQLConnection().getConnection().prepareStatement("SELECT " + value + " FROM playerTable WHERE UUID=?");
            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return set.getInt(value);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean fetchBoolean(UUID uuid, String value) {
        PreparedStatement statement;

        try {
            statement = plugin.getSQLConnection().getConnection().prepareStatement("SELECT " + value + " FROM playerTable WHERE UUID=?");
            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return set.getBoolean(value);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public void setString(UUID uuid, String valueToSet, String value) {
        PreparedStatement statement;

        try {
            statement = plugin.getSQLConnection().getConnection().prepareStatement("UPDATE playerTable SET " + valueToSet + "=? WHERE UUID=?");
            statement.setString(1, value);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void setInt(UUID uuid, String valueToSet, int value) {
        PreparedStatement statement;

        try {
            statement = plugin.getSQLConnection().getConnection().prepareStatement("UPDATE playerTable SET " + valueToSet + "=? WHERE UUID=?");
            statement.setInt(1, value);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void addInt(UUID uuid, String valueToSet, int value) {
        PreparedStatement statement;

        try {
            statement = plugin.getSQLConnection().getConnection().prepareStatement("UPDATE playerTable SET " + valueToSet + "=? WHERE UUID=?");
            statement.setInt(1, value + fetchInt(uuid, valueToSet));
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void subInt(UUID uuid, String valueToSet, int value) {
        PreparedStatement statement;

        try {
            statement = plugin.getSQLConnection().getConnection().prepareStatement("UPDATE playerTable SET " + valueToSet + "=? WHERE UUID=?");
            statement.setInt(1, value - fetchInt(uuid, valueToSet));
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void setBoolean(UUID uuid, String valueToSet, boolean value) {
        PreparedStatement statement;

        try {
            statement = plugin.getSQLConnection().getConnection().prepareStatement("UPDATE playerTable SET " + valueToSet + "=? WHERE UUID=?");
            statement.setBoolean(1, value);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
