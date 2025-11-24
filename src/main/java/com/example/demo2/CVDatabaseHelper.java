package com.example.demo2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CVDatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:cv_database.db";

    public CVDatabaseHelper() {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS cv_info (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    full_name TEXT,
                    father_name TEXT,
                    mother_name TEXT,
                    email TEXT,
                    phone TEXT,
                    photo_path TEXT,
                    area TEXT,
                    upazilla TEXT,
                    district TEXT,
                    division TEXT,
                    jsc_school TEXT,
                    jsc_year TEXT,
                    jsc_board TEXT,
                    jsc_gpa TEXT,
                    ssc_school TEXT,
                    ssc_year TEXT,
                    ssc_board TEXT,
                    ssc_gpa TEXT,
                    hsc_college TEXT,
                    hsc_year TEXT,
                    hsc_board TEXT,
                    hsc_gpa TEXT,
                    graduation_university TEXT,
                    graduation_department TEXT,
                    graduation_year TEXT,
                    graduation_cgpa TEXT,
                    skills TEXT,
                    experience TEXT,
                    projects TEXT
                );
                """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertCV(Info info) {
        String insertSQL = """
                INSERT INTO cv_info (
                    full_name, father_name, mother_name, email, phone, photo_path,
                    area, upazilla, district, division,
                    jsc_school, jsc_year, jsc_board, jsc_gpa,
                    ssc_school, ssc_year, ssc_board, ssc_gpa,
                    hsc_college, hsc_year, hsc_board, hsc_gpa,
                    graduation_university, graduation_department, graduation_year, graduation_cgpa,
                    skills, experience, projects
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, info.getFullName());
            pstmt.setString(2, info.getFatherName());
            pstmt.setString(3, info.getMotherName());
            pstmt.setString(4, info.getEmail());
            pstmt.setString(5, info.getPhone());
            pstmt.setString(6, info.getPhotoPath());
            pstmt.setString(7, info.getArea());
            pstmt.setString(8, info.getUpazilla());
            pstmt.setString(9, info.getDistrict());
            pstmt.setString(10, info.getDivision());
            pstmt.setString(11, info.getJscSchool());
            pstmt.setString(12, info.getJscYear());
            pstmt.setString(13, info.getJscBoard());
            pstmt.setString(14, info.getJscGpa());
            pstmt.setString(15, info.getSscSchool());
            pstmt.setString(16, info.getSscYear());
            pstmt.setString(17, info.getSscBoard());
            pstmt.setString(18, info.getSscGpa());
            pstmt.setString(19, info.getHscCollege());
            pstmt.setString(20, info.getHscYear());
            pstmt.setString(21, info.getHscBoard());
            pstmt.setString(22, info.getHscGpa());
            pstmt.setString(23, info.getGraduationUniversity());
            pstmt.setString(24, info.getGraduationDepartment());
            pstmt.setString(25, info.getGraduationYear());
            pstmt.setString(26, info.getGraduationCgpa());
            pstmt.setString(27, String.join(",", info.getSkills()));
            pstmt.setString(28, String.join(",", info.getExperience()));
            pstmt.setString(29, String.join(",", info.getProjects()));

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Info> getAllCVs() {
        List<Info> cvList = new ArrayList<>();
        String query = "SELECT * FROM cv_info";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                List<String> skills = Arrays.asList(rs.getString("skills").split(","));
                List<String> experience = Arrays.asList(rs.getString("experience").split(","));
                List<String> projects = Arrays.asList(rs.getString("projects").split(","));

                Info info = new Info(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("father_name"),
                        rs.getString("mother_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("photo_path"),
                        rs.getString("area"),
                        rs.getString("upazilla"),
                        rs.getString("district"),
                        rs.getString("division"),
                        rs.getString("jsc_school"),
                        rs.getString("jsc_year"),
                        rs.getString("jsc_board"),
                        rs.getString("jsc_gpa"),
                        rs.getString("ssc_school"),
                        rs.getString("ssc_year"),
                        rs.getString("ssc_board"),
                        rs.getString("ssc_gpa"),
                        rs.getString("hsc_college"),
                        rs.getString("hsc_year"),
                        rs.getString("hsc_board"),
                        rs.getString("hsc_gpa"),
                        rs.getString("graduation_university"),
                        rs.getString("graduation_department"),
                        rs.getString("graduation_year"),
                        rs.getString("graduation_cgpa"),
                        skills,
                        experience,
                        projects
                );

                cvList.add(info);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cvList;
    }

    public boolean deleteCV(int id) {
        String deleteSQL = "DELETE FROM cv_info WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCV(Info info) {
        String updateSQL = """
                UPDATE cv_info SET
                    full_name=?, father_name=?, mother_name=?, email=?, phone=?, photo_path=?,
                    area=?, upazilla=?, district=?, division=?,
                    jsc_school=?, jsc_year=?, jsc_board=?, jsc_gpa=?,
                    ssc_school=?, ssc_year=?, ssc_board=?, ssc_gpa=?,
                    hsc_college=?, hsc_year=?, hsc_board=?, hsc_gpa=?,
                    graduation_university=?, graduation_department=?, graduation_year=?, graduation_cgpa=?,
                    skills=?, experience=?, projects=?
                WHERE id=?
                """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setString(1, info.getFullName());
            pstmt.setString(2, info.getFatherName());
            pstmt.setString(3, info.getMotherName());
            pstmt.setString(4, info.getEmail());
            pstmt.setString(5, info.getPhone());
            pstmt.setString(6, info.getPhotoPath());
            pstmt.setString(7, info.getArea());
            pstmt.setString(8, info.getUpazilla());
            pstmt.setString(9, info.getDistrict());
            pstmt.setString(10, info.getDivision());
            pstmt.setString(11, info.getJscSchool());
            pstmt.setString(12, info.getJscYear());
            pstmt.setString(13, info.getJscBoard());
            pstmt.setString(14, info.getJscGpa());
            pstmt.setString(15, info.getSscSchool());
            pstmt.setString(16, info.getSscYear());
            pstmt.setString(17, info.getSscBoard());
            pstmt.setString(18, info.getSscGpa());
            pstmt.setString(19, info.getHscCollege());
            pstmt.setString(20, info.getHscYear());
            pstmt.setString(21, info.getHscBoard());
            pstmt.setString(22, info.getHscGpa());
            pstmt.setString(23, info.getGraduationUniversity());
            pstmt.setString(24, info.getGraduationDepartment());
            pstmt.setString(25, info.getGraduationYear());
            pstmt.setString(26, info.getGraduationCgpa());
            pstmt.setString(27, String.join(",", info.getSkills()));
            pstmt.setString(28, String.join(",", info.getExperience()));
            pstmt.setString(29, String.join(",", info.getProjects()));
            pstmt.setInt(30, info.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
