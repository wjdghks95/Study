package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class User {

    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

//    @Size(min = 6, max = 6)
//    private String reqYearMonth;

//    @YearMonth
//    private String reqYearMonth;

    @Valid
    private List<Car> cars;

//    @AssertTrue(message = "yyyyMM형식에 맞지 않습니다") // return true면 정상 false면 비정상
//    public boolean isReqYearMonthValidation() {
//        try {
//            LocalDate localDate = LocalDate.parse(getReqYearMonth()+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//        }catch (Exception e){
//            return false;
//        }
//        return  true;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

//    public String getReqYearMonth() {
//        return reqYearMonth;
//    }
//
//    public void setReqYearMonth(String reqYearMonth) {
//        this.reqYearMonth = reqYearMonth;
//    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
