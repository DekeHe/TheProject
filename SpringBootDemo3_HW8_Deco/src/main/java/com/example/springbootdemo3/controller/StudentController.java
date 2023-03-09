package com.example.springbootdemo3.controller;

import com.example.springbootdemo3.entity.Student;
import com.example.springbootdemo3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    private StudentService studentService ;
    //
    @PostMapping(value="/create/student")
    public String  saveStudent(@RequestBody Student student)
    {
//        Student s=new Student("dafdsaf");
        return studentService.saveStudent(student);

    }
    @DeleteMapping(value="/delete/student/{id}" )
    public String deleteStudent(@PathVariable("id")String  id)
    {
        return studentService.deleteStudent( id);
    }

    @DeleteMapping(value="/delete/students")
    public  String deleteAllStudents()
    {
        return studentService.deleteAllStudents();
    }

    @PutMapping(value="/update/student")
    public  String  updateStudent(@RequestBody Student student)
    {
        return studentService. updateStudent(  student);
    }

    @GetMapping(value="/student/{id}")
    public Student loadStudent(@PathVariable("id")String id)
    {
        return studentService.loadStudent(id);
    }

    @GetMapping(value="/students")
    public List<Student> listStudents()
    {
        return studentService.listStudents();
    }

}
