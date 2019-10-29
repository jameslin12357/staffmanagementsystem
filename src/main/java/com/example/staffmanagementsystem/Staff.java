package com.example.staffmanagementsystem;

public class Staff {

    private String firstName;
    private String lastName;
    private String major;
    private String bio;
    private int age;
    private int grade;
    private float gpa;
    private char gender;

    public Staff(String firstName, String lastName, String major, String bio, int age, int grade, float gpa, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.bio = bio;
        this.age = age;
        this.grade = grade;
        this.gpa = gpa;
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMajor() {
        return this.major;
    }

    public String getBio() {
        return this.bio;
    }

    public int getAge() {
        return this.age;
    }

    public int getGrade() {
        return this.grade;
    }

    public float getGpa() {
        return this.gpa;
    }

    public char getGender() {
        return this.gender;
    }

    public String getInfo() {
        return this.firstName + "" + this.lastName + "" + this.major + "" + this.bio + "" + this.age + "" + this.grade + "" + this.gpa + "" + this.gender;
    }

}
