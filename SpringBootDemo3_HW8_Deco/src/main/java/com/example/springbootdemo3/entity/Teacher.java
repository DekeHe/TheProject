package com.example.springbootdemo3.entity;

import java.util.HashSet;
import java.util.Set;

public class Teacher
{
    //
    private String id;
    private String name;
    private String address;
    private Set<Student> students;
    public Teacher(String id)
    {
        this.id=id;
        students=new HashSet<>();
    }

    public Teacher(String id, String name, String address, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.students = students;
        this.students=new HashSet<>();
    }

    //
    public String getId(){return this.id;}
    public void setId(String id){this.id=id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}
    public String getAddress(){return this.address;}
    public void setAddress(String address){this.address=address;}
    public Set<Student> getStudents(){return this.students;}
    public void setStudents(HashSet<Student> students){this.students=students;}

    public void addStudent(Student student)
    {
        this.students.add(student);
    }

    public void removeStudent(Student student)
    {
        this.students.remove(student);
    }

    public void updateStudent(Student oddStudent,Student newStudent )
    {
        if(this.students.contains(oddStudent))
        {
            this.students.remove(oddStudent);
            this.students.add(newStudent);
        }
    }

    //
    @Override
    public String toString()
    {
        return
                "id:"+this.id+"\n"
                        +"name:"+this.name+"\n"
                        +"address:"+this.address+"\n"
                        +"students:"+this.students+"\n";
    }
}
