package com.example.springbootdemo3.repository;

import com.example.springbootdemo3.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository
{
    static Map<String, Student> studentHashMap=new HashMap<>();
    public void saveStudent(Student student)
    {
        String id=student.getId();
        if(!studentHashMap.containsKey(id))
        {
            studentHashMap.put(id,student);
        }

    }
    public void deleteStudent(String id)
    {
        if(studentHashMap.containsKey(id))
        {
            studentHashMap.remove(id);
        }
    }

    public void deleteAllStudents()
    {
        studentHashMap.clear();
    }

    public void  updateStudent(Student student)
    {
        String id=student.getId();
        if(studentHashMap.containsKey(id))
        {
            studentHashMap.put(id,student);
        }
    }

    public Student loadStudent(String id)
    {
        return studentHashMap.getOrDefault(id,null);
    }

    public List<Student> listStudents()
    {
//        return studentHashMap.values().stream(). collect(Collectors.toList());
        return new ArrayList<>(studentHashMap.values());
    }
}
