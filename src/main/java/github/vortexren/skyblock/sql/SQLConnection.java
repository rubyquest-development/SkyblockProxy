package github.vortexren.skyblock.sql;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private final String host = "na02-db.cus.mc-panel.net";
    private final String port = "3306";

    private final String database_name = "no";
    private final String database_username = "no";
    private final String database_password = "no";

    @Getter
    private Connection connection;

    public boolean isConnected() {
        return (connection != null);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database_name + "?useSSL=false", database_username, database_password);
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

}
