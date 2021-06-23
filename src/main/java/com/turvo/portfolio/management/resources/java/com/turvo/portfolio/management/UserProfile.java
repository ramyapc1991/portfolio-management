package com.turvo.portfolio.management.resources.java.com.turvo.portfolio.management;

import java.util.List;

public class UserProfile {
    private String name;
    private String gender;
    private int age;
    private List<String> hobbies;

    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }

    public UserProfile(String name, String gender, int age, List<String> hobbies) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
