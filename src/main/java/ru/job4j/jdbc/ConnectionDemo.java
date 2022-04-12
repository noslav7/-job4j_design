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

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Map<String, String> values = new HashMap<String, String>();
        String url = null;
        String login = null;
        String password = null;
        File file = new File("./app.properties");
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if (line.isEmpty()) {
                    continue;
                }
                if (line.startsWith("#")) {
                    continue;
                }
                String[] arrayLine = line.split(" = ", 2);
                if (arrayLine.length != 2 || arrayLine[0].isEmpty() || arrayLine[1].isEmpty()) {
                    throw new IllegalArgumentException(String.format("Invalid line: %s", line));
                }
                values.put(arrayLine[0], arrayLine[1]);
                if (url.equals(null)) {
                    url = values.get("url");
                } else if (login.equals(null)) {
                    login = values.get("login");
                } else if (password.equals(null)) {
                    password = values.get("password");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metadata = connection.getMetaData();
            System.out.println(metadata.getUserName());
            System.out.println(metadata.getURL());
        }
    }
}
