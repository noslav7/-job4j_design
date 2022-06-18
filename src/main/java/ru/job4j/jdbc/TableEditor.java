package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

import static ru.job4j.io.UsageLog4j.LOG;


public class TableEditor implements AutoCloseable {
    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
                config.load(in);
        }
        try (TableEditor tableEditor = new TableEditor(config)) {
            tableEditor.createTable("empty_table");
            tableEditor.addColumn("empty_table", "color", "varchar");
            tableEditor.renameColumn("empty_table", "color", "shade");
            tableEditor.dropColumn("empty_table", "shade");
            tableEditor.dropTable("empty_table");
        }
    }

    private void initConnection() throws SQLException {
        connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("login"), properties.getProperty("password"));
    }

    public void statementCreation(String query) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (Exception e) {
            LOG.error("Sql exception", e);
        }
    }

    public void createTable(String tableName) throws Exception {
                String sql = String.format(
                        "create table if not exists %s "
                                + "(id serial primary key, name varchar(255))",
                        tableName
                );
                statementCreation(sql);
                System.out.println(getTableScheme(connection, "empty_table"));
    }

    public void dropTable(String tableName) throws SQLException {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "drop table %s", tableName
                );
                statementCreation(sql);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
       try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table %s add %s %s",
                        tableName, columnName, type
                );
                statementCreation(sql);
                System.out.println(getTableScheme(connection, "empty_table"));
            } catch (Exception e) {
                throw new RuntimeException(e);
       }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table %s drop column %s",
                        tableName, columnName
                );
                statementCreation(sql);
                System.out.println(getTableScheme(connection, "empty_table"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table %s rename column %s to %s",
                        tableName, columnName, newColumnName
                );
                statementCreation(sql);
                System.out.println(getTableScheme(connection, "empty_table"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
