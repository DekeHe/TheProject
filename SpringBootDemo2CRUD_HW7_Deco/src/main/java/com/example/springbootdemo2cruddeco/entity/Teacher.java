package com.example.springbootdemo2cruddeco.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Teacher
{
    //
    @Getter @Setter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private String address;
    @Getter @Setter private Set<Student> students;

}
