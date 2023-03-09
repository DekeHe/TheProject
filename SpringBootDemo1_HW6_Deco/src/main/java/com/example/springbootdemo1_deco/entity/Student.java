package com.example.springbootdemo1_deco.entity;

public class Student
{
    private String id;
    private String name;
    private int age;
    private String address;
    private String email;
    private String phoneNumber;
    private String teacherId;

    //
    public Student(String id) {this.id=id;}

    //
    public String getId(){return this.id;}
    public void setId(String id){this.id=id;}

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public int getAge(){return this.age;}
    public void setAge(int age){this.age=age;}
    public String getAddress(){return this.address;}
    public void setAddress(String address){this.address=address;}

    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email=email;}

    public String getPhoneNumber(){return this.phoneNumber;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}

    public String getTeacherId(){return this.teacherId;}
    public void setTeacherId(String teacherId){this.teacherId=teacherId;}
}
