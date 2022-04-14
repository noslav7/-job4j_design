package ru.job4j.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.sql.DatabaseMetaData;

import ru.job4j.io.Config;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        File file = new File("./app.properties");
        Config config = new Config("./app.properties");
        Class.forName("org.postgresql.Driver");
        Map<String, String> values = new HashMap<String, String>();
        config.load();
        String url = config.value("hibernate.connection.url");
        String username = config.value("hibernate.connection.username");
        String password = config.value("hibernate.connection.password");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metadata = connection.getMetaData();
            System.out.println(metadata.getUserName());
            System.out.println(metadata.getURL());
        }
    }
}
