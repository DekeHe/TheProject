package com.example.springbootdemo2cruddeco.repository;

import com.example.springbootdemo2cruddeco.entity.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentRepository
{
    //
    private static Map<String,Student> studentHashMap=new HashMap<>();

    //
    public Student loadStudent(String id)
    {
        return studentHashMap.getOrDefault(id,null);
    }

    public List<Student> loadAllStudents()
    {
        return new ArrayList<>(studentHashMap.values());
    }

    public void saveStudent(Student student)
    {
        studentHashMap.put(student.getId(),student);
    }

    public void deleteStudent(String id)
    {
        studentHashMap.remove(id);
    }

    public void deleteAllStudents()
    {
        studentHashMap.clear();
    }

    public void setTeacherId(Student student,String teacherId)
    {
        student.setTeacherId(teacherId);
    }


}
