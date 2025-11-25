package com.example.demo2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:cvdata.db";

    public DatabaseHelper() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            String sql = "CREATE TABLE IF NOT EXISTS info (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "fullName TEXT," +
                    "fatherName TEXT," +
                    "motherName TEXT," +
                    "email TEXT," +
                    "phone TEXT," +
                    "photoPath TEXT," +
                    "area TEXT," +
                    "upazilla TEXT," +
                    "district TEXT," +
                    "division TEXT," +
                    "jscSchool TEXT," +
                    "jscYear TEXT," +
                    "jscBoard TEXT," +
                    "jscGpa TEXT," +
                    "sscSchool TEXT," +
                    "sscYear TEXT," +
                    "sscBoard TEXT," +
                    "sscGpa TEXT," +
                    "hscCollege TEXT," +
                    "hscYear TEXT," +
                    "hscBoard TEXT," +
                    "hscGpa TEXT," +
                    "graduationUniversity TEXT," +
                    "graduationDepartment TEXT," +
                    "graduationYear TEXT," +
                    "graduationCgpa TEXT," +
                    "skills TEXT," +
                    "experience TEXT," +
                    "projects TEXT" +
                    ")";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Info insert(Info i) {
        String sql = "INSERT INTO info (fullName,fatherName,motherName,email,phone,photoPath,area,upazilla,district,division," +
                "jscSchool,jscYear,jscBoard,jscGpa,sscSchool,sscYear,sscBoard,sscGpa,hscCollege,hscYear,hscBoard,hscGpa," +
                "graduationUniversity,graduationDepartment,graduationYear,graduationCgpa,skills,experience,projects) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, i.getFullName());
            stmt.setString(2, i.getFatherName());
            stmt.setString(3, i.getMotherName());
            stmt.setString(4, i.getEmail());
            stmt.setString(5, i.getPhone());
            stmt.setString(6, i.getPhotoPath());
            stmt.setString(7, i.getArea());
            stmt.setString(8, i.getUpazilla());
            stmt.setString(9, i.getDistrict());
            stmt.setString(10, i.getDivision());
            stmt.setString(11, i.getJscSchool());
            stmt.setString(12, i.getJscYear());
            stmt.setString(13, i.getJscBoard());
            stmt.setString(14, i.getJscGpa());
            stmt.setString(15, i.getSscSchool());
            stmt.setString(16, i.getSscYear());
            stmt.setString(17, i.getSscBoard());
            stmt.setString(18, i.getSscGpa());
            stmt.setString(19, i.getHscCollege());
            stmt.setString(20, i.getHscYear());
            stmt.setString(21, i.getHscBoard());
            stmt.setString(22, i.getHscGpa());
            stmt.setString(23, i.getGraduationUniversity());
            stmt.setString(24, i.getGraduationDepartment());
            stmt.setString(25, i.getGraduationYear());
            stmt.setString(26, i.getGraduationCgpa());
            stmt.setString(27, String.join(",", i.getSkills()));
            stmt.setString(28, String.join(",", i.getExperience()));
            stmt.setString(29, String.join(",", i.getProjects()));

            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return new Info(
                            rs.getInt(1),
                            i.getFullName(),
                            i.getFatherName(),
                            i.getMotherName(),
                            i.getEmail(),
                            i.getPhone(),
                            i.getPhotoPath(),
                            i.getArea(),
                            i.getUpazilla(),
                            i.getDistrict(),
                            i.getDivision(),
                            i.getJscSchool(),
                            i.getJscYear(),
                            i.getJscBoard(),
                            i.getJscGpa(),
                            i.getSscSchool(),
                            i.getSscYear(),
                            i.getSscBoard(),
                            i.getSscGpa(),
                            i.getHscCollege(),
                            i.getHscYear(),
                            i.getHscBoard(),
                            i.getHscGpa(),
                            i.getGraduationUniversity(),
                            i.getGraduationDepartment(),
                            i.getGraduationYear(),
                            i.getGraduationCgpa(),
                            new ArrayList<>(i.getSkills()),
                            new ArrayList<>(i.getExperience()),
                            new ArrayList<>(i.getProjects())
                    );
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Info> getAllCVs() {
        List<Info> list = new ArrayList<>();
        String sql = "SELECT * FROM info";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                List<String> skills = List.of(rs.getString("skills").split(","));
                List<String> exp = List.of(rs.getString("experience").split(","));
                List<String> pro = List.of(rs.getString("projects").split(","));

                Info i = new Info(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("fatherName"),
                        rs.getString("motherName"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("photoPath"),
                        rs.getString("area"),
                        rs.getString("upazilla"),
                        rs.getString("district"),
                        rs.getString("division"),
                        rs.getString("jscSchool"),
                        rs.getString("jscYear"),
                        rs.getString("jscBoard"),
                        rs.getString("jscGpa"),
                        rs.getString("sscSchool"),
                        rs.getString("sscYear"),
                        rs.getString("sscBoard"),
                        rs.getString("sscGpa"),
                        rs.getString("hscCollege"),
                        rs.getString("hscYear"),
                        rs.getString("hscBoard"),
                        rs.getString("hscGpa"),
                        rs.getString("graduationUniversity"),
                        rs.getString("graduationDepartment"),
                        rs.getString("graduationYear"),
                        rs.getString("graduationCgpa"),
                        skills,
                        exp,
                        pro
                );
                list.add(i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public boolean deleteCV(int id) {
        String sql = "DELETE FROM info WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
