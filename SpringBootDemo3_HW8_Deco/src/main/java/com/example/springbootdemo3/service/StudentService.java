package com.example.springbootdemo3.service;

import com.example.springbootdemo3.entity.Student;
import com.example.springbootdemo3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;
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
