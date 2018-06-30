package com.bashfan.domain;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String department;
    private String phone;
    private String website;
    private List<Post> posts;
    private List<Group> groups;

    public User() {
    }

    public User(String name, String department, String phone, String website) {
        this.name = name;
        this.department = department;
        this.phone = phone;
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", posts=" + posts +
                ", groups=" + groups +
                '}';
    }
}