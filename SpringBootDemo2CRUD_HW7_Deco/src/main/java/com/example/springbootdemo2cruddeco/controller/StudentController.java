package com.example.springbootdemo2cruddeco.controller;

import com.example.springbootdemo2cruddeco.entity.Student;
//import com.example.springbootdemo2cruddeco.repository.StudentService;
import com.example.springbootdemo2cruddeco.service.StudentService;
import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController
{

    //
    private  StudentService studentService=new StudentService();

    //
     @GetMapping(value= "/student/{id}")
    public Student  loadStudent(@ PathVariable(value="id")String id )
     {
            return this.studentService.loadStudent(id);
     }

     @GetMapping(value="/students")
    public List<Student> loadAllStudents()
     {
         return this.studentService.loadAllStudents();
     }

     @PostMapping(value="/create/student")
     public String createStudent(@ RequestBody Student student)
     {
         return this.studentService.createStudent(student);
     }

     @DeleteMapping(value="/delete/student/{id}")
    public String deleteStudent(@  PathVariable(value="id")String id )
     {
         return this.studentService.deleteStudent(id);
     }

     @DeleteMapping(value="/delete/students")
     public String deleteAllStudents()
     {
         return this.studentService. deleteAllStudents();
     }

     @PutMapping(value= "/update/student")
     public String updateStudents(@RequestBody Student student)
     {
         return this.studentService.updateStudent(student);
     }

}
