package com.example.demo2;

import java.util.List;

public class Info {
    private int id;
    private String fullName, fatherName, motherName, email, phone, photoPath;
    private String area, upazilla, district, division;
    private String jscSchool, jscYear, jscBoard, jscGpa;
    private String sscSchool, sscYear, sscBoard, sscGpa;
    private String hscCollege, hscYear, hscBoard, hscGpa;
    private String graduationUniversity, graduationDepartment, graduationYear, graduationCgpa;
    private List<String> skills, experience, projects;

    public Info(int id, String fullName, String fatherName, String motherName, String email, String phone, String photoPath,
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

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }
    public void setArea(String area) { this.area = area; }
    public void setUpazilla(String upazilla) { this.upazilla = upazilla; }
    public void setDistrict(String district) { this.district = district; }
    public void setDivision(String division) { this.division = division; }
    public void setJscSchool(String jscSchool) { this.jscSchool = jscSchool; }
    public void setJscYear(String jscYear) { this.jscYear = jscYear; }
    public void setJscBoard(String jscBoard) { this.jscBoard = jscBoard; }
    public void setJscGpa(String jscGpa) { this.jscGpa = jscGpa; }
    public void setSscSchool(String sscSchool) { this.sscSchool = sscSchool; }
    public void setSscYear(String sscYear) { this.sscYear = sscYear; }
    public void setSscBoard(String sscBoard) { this.sscBoard = sscBoard; }
    public void setSscGpa(String sscGpa) { this.sscGpa = sscGpa; }
    public void setHscCollege(String hscCollege) { this.hscCollege = hscCollege; }
    public void setHscYear(String hscYear) { this.hscYear = hscYear; }
    public void setHscBoard(String hscBoard) { this.hscBoard = hscBoard; }
    public void setHscGpa(String hscGpa) { this.hscGpa = hscGpa; }
    public void setGraduationUniversity(String graduationUniversity) { this.graduationUniversity = graduationUniversity; }
    public void setGraduationDepartment(String graduationDepartment) { this.graduationDepartment = graduationDepartment; }
    public void setGraduationYear(String graduationYear) { this.graduationYear = graduationYear; }
    public void setGraduationCgpa(String graduationCgpa) { this.graduationCgpa = graduationCgpa; }
    public void setSkills(List<String> skills) { this.skills = skills; }
    public void setExperience(List<String> experience) { this.experience = experience; }
    public void setProjects(List<String> projects) { this.projects = projects; }
}
