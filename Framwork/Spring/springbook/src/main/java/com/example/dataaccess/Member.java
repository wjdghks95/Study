package com.example.dataaccess;

public class Member {
    int id;
    String name;
    double point;

    public Member() {
    }

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member(int id, String name, double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPoint() {
        return point;
    }
}
