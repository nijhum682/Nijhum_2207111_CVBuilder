package com.example.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

        private static final String DB_URL = "jdbc:sqlite:sample.db";
        private static Connection connection;
        private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS sample_nodes (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,json_data TEXT NOT NULL);";

        public static void initDatabase() throws SQLException {
            try {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
                    if (connection != null) {
                        System.out.println("Connected to SQLite!");
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


}
