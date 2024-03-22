package com.LAB.ABCLab;

import org.springframework.data.annotation.Id;

public class Test {

    @Id
    private Integer id;
    private String name;
    private String date;
    private String doctor; // doctor

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}





