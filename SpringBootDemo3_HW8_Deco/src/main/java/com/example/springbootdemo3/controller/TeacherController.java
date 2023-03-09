package com.example.springbootdemo3.controller;

import com.example.springbootdemo3.entity.Teacher;
import com.example.springbootdemo3.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController
{
    @Autowired
    private TeacherService teacherService ;
    //
    @PostMapping(value="/create/teacher")
    public String  saveTeacher(@RequestBody Teacher teacher)
    {
        return teacherService.saveTeacher(teacher);

    }
    @DeleteMapping(value="/delete/teacher/{id}" )
    public String deleteTeacher(@PathVariable("id")String  id)
    {
        return teacherService.deleteTeacher( id);
    }

    @DeleteMapping(value="/delete/teachers")
    public  String deleteAllTeachers()
    {
        return teacherService.deleteAllTeachers();
    }

    @PutMapping(value="/update/teacher")
    public String  updateTeacher(@RequestBody Teacher teacher)
    {

        return teacherService. updateTeacher(  teacher);
    }

    @GetMapping(value="/teacher/{id}")
    public Teacher loadTeacher(@PathVariable("id")String id)
    {
        return teacherService.loadTeacher(id);
    }

    @GetMapping(value="/teachers")
    public List<Teacher> listTeachers()
    {
        return teacherService.listTeachers();
    }

}
