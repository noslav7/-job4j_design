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
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                String[] arrayLine = line.split("=", 2);
                if (arrayLine.length != 2 || arrayLine[0].isEmpty() || arrayLine[1].isEmpty()) {
                    throw new IllegalArgumentException(String.format("Invalid line: %s", line));
                }
                values.put(arrayLine[0], arrayLine[1]);
                }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String url = values.get("hibernate.connection.url");
        String login = values.get("hibernate.connection.login");
        String password = values.get("hibernate.connection.password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metadata = connection.getMetaData();
            System.out.println(metadata.getUserName());
            System.out.println(metadata.getURL());
        }
    }
}
