package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

import static java.sql.DriverManager.getConnection;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private Connection initConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        return DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists empty_table(%s, %s);",
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "empty_table"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection.close();
    }

    public void dropTable(String tableName) throws SQLException {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "drop table (%s)", tableName
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "empty_table"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection.close();
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table (%s)\nadd (%s, %s)",
                        tableName, columnName, type
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "empty_table"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection.close();
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table (%s)\ndrop column (%s)",
                        tableName, columnName
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "empty_table"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection.close();
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table (%s)\nrename column (%s) to (%s)",
                        tableName, columnName, newColumnName
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "empty_table"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection.close();
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
