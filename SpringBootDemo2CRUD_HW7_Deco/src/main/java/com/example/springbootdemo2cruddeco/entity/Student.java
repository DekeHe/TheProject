package com.example.springbootdemo2cruddeco.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Student
{
    //
    @Getter @Setter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private int age;
    @Getter @Setter private String address;
    @Getter @Setter private String email;
    @Getter @Setter private String phoneNumber;
    @Getter @Setter private String teacherId;
}
