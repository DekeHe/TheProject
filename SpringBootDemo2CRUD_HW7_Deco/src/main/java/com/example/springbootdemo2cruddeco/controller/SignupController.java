package com.example.springbootdemo2cruddeco.controller;

import com.example.springbootdemo2cruddeco.service.SignupService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignupController
{
    //
    private SignupService  signupService=new SignupService();

    //
    @PostMapping (value="/signup")
    public String signupStudentTeacher(@RequestParam String studentId,
                                       @RequestParam String teacherId)
    {
        return this.signupService.signupStudentTeacher(studentId ,teacherId);
    }

    @PutMapping(value="/update/signup")
    public String updateStudentTeacher(@RequestParam String studentId,
                                     @RequestParam String teacherId )
    {
        return this.signupService.updateStudentTeacher(studentId,teacherId);
    }

    @DeleteMapping(value= "/delete/signup")
    public String deleteStudentTeacher(@RequestParam String studentId,
                                     @RequestParam String teacherId )
    {
        return this.signupService.deleteStudentTeacher (studentId,teacherId);
    }

}
