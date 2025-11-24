package com.example.demo2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CVDatabaseHelper {

    private static final String DB_URL = "jdbc:sqlite:cv_data.db";
    private static Connection connection;
    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS cv_data (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "json_data TEXT NOT NULL" +
                    ");";

    public static void initDatabase() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL);
                createTable();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_SQL)) {
            statement.executeUpdate();
        }
    }

    public static int insertCV(String json) throws SQLException {
        String sql = "INSERT INTO cv_data (json_data) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, json);
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
                else throw new SQLException("Failed to retrieve generated id.");
            }
        }
    }

    public static void updateCV(int id, String json) throws SQLException {
        String sql = "UPDATE cv_data SET json_data = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, json);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

    public static void deleteCV(int id) throws SQLException {
        String sql = "DELETE FROM cv_data WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public static List<String> getAllCVs() throws SQLException {
        List<String> list = new ArrayList<>();
        String sql = "SELECT json_data FROM cv_data ORDER BY id ASC";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                list.add(rs.getString("json_data"));
            }
        }
        return list;
    }
    public static String getCVById(int id) throws SQLException {
        String sql = "SELECT json_data FROM cv_data WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) return rs.getString("json_data");
                else return null;
            }
        }
    }
}
