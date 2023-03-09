package com.example.springbootdemo1_deco.controller;

import com.example.springbootdemo1_deco.entity.Student;
import com.example.springbootdemo1_deco.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController
{
    private StudentService studentService=new StudentService();

    @PostMapping(value="/create/student")
    public String  saveStudent(@RequestParam(value="id",required=false)String id,
                              @RequestParam(value="name",required=false)String name,
                              @RequestParam(value="age",required=false)int age)
    {
        Student student=new Student(id);
        student.setName(name);
        student.setAge(age);
        student.setAddress("address");
        student.setEmail("email");
        student.setPhoneNumber("phoneNumber");

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

    @PutMapping(value="/update/student/{id}")
    public void  updateStudent(@PathVariable("id")String id,
                                @RequestParam(value="name",required=false)String name,
                                @RequestParam(value="age",required=false)Integer age,
                                @RequestParam(value="address",required=false)String  address,
                                @RequestParam(value="email",required=false)String   email,
                                @RequestParam(value="phoneNumber",required=false)String   phoneNumber)
    {

        Student student=new Student(id);

        student.setName(name);
        student.setAddress(address);
        student.setAge(age);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);

        studentService. updateStudent(  student);
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

