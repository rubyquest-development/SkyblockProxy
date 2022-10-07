package github.vortexren.skyblock.sql.tables;

import java.util.UUID;

public interface SQLTable {
    //Setters
    void createTable();
    void setString(UUID uuid, String valueToSet, String value);
    void setInt(UUID uuid, String valueToSet, int value);
    void addInt(UUID uuid, String valueToSet, int value);
    void subInt(UUID uuid, String valueToSet, int value);
    void setBoolean(UUID uuid, String valueToSet, boolean value);

    //Fetchers
    String fetchString(UUID uuid, String value);
    int fetchInt(UUID uuid, String value);
    boolean fetchBoolean(UUID uuid, String value);
}
