package com.example.springbootdemo1_deco.service;

import com.example.springbootdemo1_deco.entity.Student;
import com.example.springbootdemo1_deco.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService
{
    private StudentRepository studentRepository =new StudentRepository();
    public String saveStudent(Student student)
    {
        Optional<Student> student1=Optional.ofNullable(this.loadStudent(student.getId()));
        if(student1.isPresent())
        {
            return "student already exists!";
        }
        else
        {
            studentRepository.saveStudent(student);
            return "created.";
        }
    }
    public String deleteStudent(String id)
    {
        Optional<Student> student1=Optional.ofNullable(this.loadStudent(id));
        if(student1.isPresent())
        {
            studentRepository.deleteStudent(id);
            return "deleted.";
        }
        else
        {
            return "student not exists!";
        }
    }
    public String deleteAllStudents()
    {
        studentRepository.deleteAllStudents();
        return "deleted.";

    }
    public String  updateStudent(  Student student)
    {
        Optional<Student> student1=Optional.ofNullable(this.loadStudent(student.getId()));
        if(student1.isPresent())
        {
            studentRepository. updateStudent(  student);
            return "updated.";
        }
        else
        {
            return "student not exists" ;
        }

    }
    public Student loadStudent(String studentId)
    {
        return studentRepository.loadStudent(studentId);
    }

    public List<Student> listStudents()
    {
        return studentRepository.listStudents();
    }

}
