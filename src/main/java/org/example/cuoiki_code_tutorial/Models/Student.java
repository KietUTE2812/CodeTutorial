package org.example.cuoiki_code_tutorial.Models;

import java.time.LocalDate;

public class Student {
    private int id;
    private String code;
    private String lastName;
    private String firstName;
    private String gender;
    private LocalDate birthday;
    private String faculty;

    public Student() {
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Student(int id, String code, String lastName, String firstName, String gender, LocalDate birthday, String faculty) {
        this.id = id;
        this.code = code;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.birthday = birthday;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", faculty='" + faculty + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
