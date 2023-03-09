package com.example.springbootdemo2cruddeco.service;

import com.example.springbootdemo2cruddeco.entity.Student;
import com.example.springbootdemo2cruddeco.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService
{
    //
    private StudentRepository studentRepository=new StudentRepository();

    //
    public Student loadStudent(String id)
    {
        return this.studentRepository.loadStudent(id);
    }

    public List<Student> loadAllStudents()
    {
        return this.studentRepository.loadAllStudents();
    }

    public String createStudent(Student student)
    {
        Student temp=this.loadStudent(student.getId());
        Optional<Student> optionalStudent=Optional.ofNullable(temp);
        if(optionalStudent.isPresent())
        {
            return "student id already exists, canont save! ";
        }
        else
        {
            this.studentRepository.saveStudent(student);
            return "created. ";
        }
    }

    public String deleteStudent(String id)
    {
        Student temp=this.loadStudent(id);
        Optional<Student> optionalStudent=Optional.ofNullable(temp);
        if(optionalStudent.isPresent())
        {
            this.studentRepository.deleteStudent(id);
            return "deleted. ";
        }
        else
        {
            return "student not existed, no delete! ";
        }
    }

    public   String deleteAllStudents()
    {
        this.studentRepository.deleteAllStudents();
        return  "deleted. ";
    }

    public String updateStudent (Student student)
    {
        Student temp=this.loadStudent(student.getId());
        Optional<Student> optionalStudent=Optional.ofNullable(temp);
        if(optionalStudent.isPresent())
        {
            this.studentRepository.saveStudent(student);
            return "updated. ";
        }
        else
        {
            return "student id not existed, cannot updated! ";
        }
    }

    public void setTeacherId(Student student, String teacherId)
    {
        student.setTeacherId(teacherId);
    }

}
