package com.example.springbootdemo3.controller;

import com.example.springbootdemo3.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController
{
    @Autowired
    private SystemService systemService;
    //
    @PutMapping(value="/signup")
    public String signupStudentTeacher(@RequestParam(value="studentId")String studentId,
                                       @RequestParam(value="teacherId")String teacherId)
    {
        return  systemService.signupStudentTeacher(studentId , teacherId);
    }

    @PutMapping(value="/update/signup")
    public String updateStudentTeacher(@RequestParam(value="studentId")String studentId,
                                       @RequestParam(value="oldTeacherId") String oldTeacherId,
                                       @RequestParam(value="newTeacherId")String newTeacherId)
    {
        return systemService.updateStudentTeacher(studentId ,oldTeacherId,    newTeacherId);
    }

    @DeleteMapping(value="/delete/signup")
    public String deleteStudentTeacher(@RequestParam(value="studentId")String studentId,
                                       @RequestParam(value="teacherId")String teacherId)
    {
        return systemService.deleteStudentTeacher( studentId , teacherId) ;
    }

}
