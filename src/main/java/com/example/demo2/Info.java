package com.example.demo2;
import java.util.List;

public class Info {
    private final int id;

    private final String fullName;
    private final String fatherName;
    private final String motherName;
    private final String email;
    private final String phone;
    private final String photoPath;

    private final String area;
    private final String upazilla;
    private final String district;
    private final String division;

    private final String jscSchool;
    private final String jscYear;
    private final String jscBoard;
    private final String jscGpa;

    private final String sscSchool;
    private final String sscYear;
    private final String sscBoard;
    private final String sscGpa;

    private final String hscCollege;
    private final String hscYear;
    private final String hscBoard;
    private final String hscGpa;

    private final String graduationUniversity;
    private final String graduationDepartment;
    private final String graduationYear;
    private final String graduationCgpa;

    private final List<String> skills;
    private final List<String> experience;
    private final List<String> projects;

    public Info(
            int id,
            String fullName, String fatherName, String motherName, String email, String phone, String photoPath,
            String area, String upazilla, String district, String division,
            String jscSchool, String jscYear, String jscBoard, String jscGpa,
            String sscSchool, String sscYear, String sscBoard, String sscGpa,
            String hscCollege, String hscYear, String hscBoard, String hscGpa,
            String graduationUniversity, String graduationDepartment, String graduationYear, String graduationCgpa,
            List<String> skills, List<String> experience, List<String> projects
    ) {
        this.id = id;
        this.fullName = fullName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.email = email;
        this.phone = phone;
        this.photoPath = photoPath;
        this.area = area;
        this.upazilla = upazilla;
        this.district = district;
        this.division = division;
        this.jscSchool = jscSchool;
        this.jscYear = jscYear;
        this.jscBoard = jscBoard;
        this.jscGpa = jscGpa;
        this.sscSchool = sscSchool;
        this.sscYear = sscYear;
        this.sscBoard = sscBoard;
        this.sscGpa = sscGpa;
        this.hscCollege = hscCollege;
        this.hscYear = hscYear;
        this.hscBoard = hscBoard;
        this.hscGpa = hscGpa;
        this.graduationUniversity = graduationUniversity;
        this.graduationDepartment = graduationDepartment;
        this.graduationYear = graduationYear;
        this.graduationCgpa = graduationCgpa;
        this.skills = skills;
        this.experience = experience;
        this.projects = projects;
    }

    public Info(
            String fullName, String fatherName, String motherName, String email, String phone, String photoPath,
            String area, String upazilla, String district, String division,
            String jscSchool, String jscYear, String jscBoard, String jscGpa,
            String sscSchool, String sscYear, String sscBoard, String sscGpa,
            String hscCollege, String hscYear, String hscBoard, String hscGpa,
            String graduationUniversity, String graduationDepartment, String graduationYear, String graduationCgpa,
            List<String> skills, List<String> experience, List<String> projects
    ) {
        this(
                -1,
                fullName, fatherName, motherName, email, phone, photoPath,
                area, upazilla, district, division,
                jscSchool, jscYear, jscBoard, jscGpa,
                sscSchool, sscYear, sscBoard, sscGpa,
                hscCollege, hscYear, hscBoard, hscGpa,
                graduationUniversity, graduationDepartment, graduationYear, graduationCgpa,
                skills, experience, projects
        );
    }
    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getFatherName() {
        return fatherName;
    }
    public String getMotherName() {
        return motherName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getPhotoPath() {
        return photoPath;
    }
    public String getArea() {
        return area;
    }
    public String getUpazilla() {
        return upazilla;
    }
    public String getDistrict() {
        return district;
    }
    public String getDivision() {
        return division;
    }
    public String getJscSchool() {
        return jscSchool;
    }
    public String getJscYear() {
        return jscYear;
    }

    public String getJscBoard() {
        return jscBoard;
    }

    public String getJscGpa() {
        return jscGpa;
    }

    public String getSscSchool() {
        return sscSchool;
    }

    public String getSscYear() {
        return sscYear;
    }

    public String getSscBoard() {
        return sscBoard;
    }
    public String getSscGpa() {
        return sscGpa;
    }
    public String getHscCollege() {
        return hscCollege;
    }
    public String getHscYear() {
        return hscYear;
    }

    public String getHscBoard() {
        return hscBoard;
    }

    public String getHscGpa() {
        return hscGpa;
    }

    public String getGraduationUniversity() {
        return graduationUniversity;
    }

    public String getGraduationDepartment() {
        return graduationDepartment;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public String getGraduationCgpa() {
        return graduationCgpa;
    }

    public List<String> getSkills() {
        return skills;
    }
    public List<String> getExperience() {
        return experience;
    }
    public List<String> getProjects() {
        return projects;
    }
}
