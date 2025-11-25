package com.example.demo2;

import java.util.List;

public class Info {
    private final int id;
    private final String fullName, fatherName, motherName, email, phone, photoPath;
    private final String area, upazilla, district, division;
    private final String jscSchool, jscYear, jscBoard, jscGpa;
    private final String sscSchool, sscYear, sscBoard, sscGpa;
    private final String hscCollege, hscYear, hscBoard, hscGpa;
    private final String graduationUniversity, graduationDepartment, graduationYear, graduationCgpa;
    private final List<String> skills, experience, projects;

    public Info(int id,
                String fullName, String fatherName, String motherName, String email, String phone, String photoPath,
                String area, String upazilla, String district, String division,
                String jscSchool, String jscYear, String jscBoard, String jscGpa,
                String sscSchool, String sscYear, String sscBoard, String sscGpa,
                String hscCollege, String hscYear, String hscBoard, String hscGpa,
                String graduationUniversity, String graduationDepartment, String graduationYear, String graduationCgpa,
                List<String> skills, List<String> experience, List<String> projects) {
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

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getFatherName() { return fatherName; }
    public String getMotherName() { return motherName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPhotoPath() { return photoPath; }
    public String getArea() { return area; }
    public String getUpazilla() { return upazilla; }
    public String getDistrict() { return district; }
    public String getDivision() { return division; }
    public String getJscSchool() { return jscSchool; }
    public String getJscYear() { return jscYear; }
    public String getJscBoard() { return jscBoard; }
    public String getJscGpa() { return jscGpa; }
    public String getSscSchool() { return sscSchool; }
    public String getSscYear() { return sscYear; }
    public String getSscBoard() { return sscBoard; }
    public String getSscGpa() { return sscGpa; }
    public String getHscCollege() { return hscCollege; }
    public String getHscYear() { return hscYear; }
    public String getHscBoard() { return hscBoard; }
    public String getHscGpa() { return hscGpa; }
    public String getGraduationUniversity() { return graduationUniversity; }
    public String getGraduationDepartment() { return graduationDepartment; }
    public String getGraduationYear() { return graduationYear; }
    public String getGraduationCgpa() { return graduationCgpa; }
    public List<String> getSkills() { return skills; }
    public List<String> getExperience() { return experience; }
    public List<String> getProjects() { return projects; }
}
