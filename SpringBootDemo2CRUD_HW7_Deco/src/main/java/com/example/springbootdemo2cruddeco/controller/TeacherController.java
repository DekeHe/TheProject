package com.example.springbootdemo2cruddeco.controller;

import com.example.springbootdemo2cruddeco.entity.*;
import com.example.springbootdemo2cruddeco.entity.Teacher;
import com.example.springbootdemo2cruddeco.entity.Teacher;
import com.example.springbootdemo2cruddeco.entity.Teacher;
import com.example.springbootdemo2cruddeco.service.*;
import com.example.springbootdemo2cruddeco.service.TeacherService;
import com.example.springbootdemo2cruddeco.service.TeacherService;
import com.example.springbootdemo2cruddeco.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class TeacherController
{
    //
    private  TeacherService teacherService=new TeacherService();

    //
    @GetMapping(value= "/teacher/{id}")
    public Teacher  loadTeacher(@ PathVariable(value="id")String id )
    {
        return this.teacherService.loadTeacher(id);
    }

    @GetMapping(value="/teachers")
    public List<Teacher> loadAllTeachers()
    {
        return this.teacherService.loadAllTeachers();
    }

    @PostMapping(value= "/create/teacher")
    public String createTeacher(@ RequestBody Teacher teacher)
    {
        return this.teacherService.createTeacher(teacher);
    }

    @DeleteMapping(value="/delete/teacher/{id}")
    public String deleteTeacher(@  PathVariable(value="id")String id )
    {
        return this.teacherService.deleteTeacher(id);
    }

    @DeleteMapping(value="/delete/teachers")
    public String deleteAllTeachers()
    {
        return this.teacherService. deleteAllTeachers();
    }

    @PutMapping(value=  "/update/teacher")
    public String updateTeachers(@RequestBody Teacher teacher)
    {
        return this.teacherService.updateTeacher(teacher);
    }

}
