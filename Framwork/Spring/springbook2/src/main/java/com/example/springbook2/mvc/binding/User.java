package com.example.springbook2.mvc.binding;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {
    int id;

    @NotNull
    String name;

    @Min(0)
    int age;
    Code userType;
    int userTypeId;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
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

    public Code getUserType() {
        return userType;
    }

    public void setUserType(Code userType) {
        this.userType = userType;
    }
}
