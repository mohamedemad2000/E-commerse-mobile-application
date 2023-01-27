package com.example.new_mobile_project.Models;

public class CustomerModel {
    private int id;
    private String name,username,password,birthdate,job,gender;

    public CustomerModel(String custname,String custUsername, String custpassword,String custDate,String custJob,String custGender){
        this.name = custname;
        this.username = custUsername;
        this.password = custpassword;
        this.birthdate = custDate;
        this.job = custJob;
        this.gender = custGender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
