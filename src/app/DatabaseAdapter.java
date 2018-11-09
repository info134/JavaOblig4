package app;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DatabaseAdapter {

    private String dbpath = "src/app/s.db";
    private String filepath = "src/app/schema2.sql";
    private String dburl = "jdbc:sqlite:" + dbpath;
    private Connection conn;
    private static DatabaseAdapter instance;

    private DatabaseAdapter() {
        try {
            getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getConnection() throws SQLException {
        File file = new File(dbpath);
        if (file.exists() && !file.isDirectory()) {
            conn = DriverManager.getConnection(dburl);
        } else {
            noDbFile();
            getConnection();
        }
    }

    private void noDbFile() {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filepath));
            String input2 = new String(encoded);
            String[] queryArray = input2.split(";");
            Connection conn = DriverManager.getConnection(dburl);
            for (String query : queryArray) {
                if (!query.trim().isEmpty()) {
                    conn.prepareStatement(query).execute();
                }
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public Connection theConnection() {
        return conn;
    }

    public static DatabaseAdapter getInstance() {
        try {
            if (instance == null) {
                instance = new DatabaseAdapter();
            } else if (instance.theConnection().isClosed()) {
                instance = new DatabaseAdapter();
            }
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return instance;
    }
}
