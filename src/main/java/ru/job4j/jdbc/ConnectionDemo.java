package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import ru.job4j.io.Config;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        File file = new File("./app.properties");
        Config config = new Config("./app.properties");
        Class.forName("org.postgresql.Driver");
        Map<String, String> values = new HashMap<String, String>();
        config.load();
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metadata = connection.getMetaData();
            System.out.println(metadata.getUserName());
            System.out.println(metadata.getURL());
        }
    }
}
