package com.example.springbootdemo2cruddeco.service;

import com.example.springbootdemo2cruddeco.entity.*;
import com.example.springbootdemo2cruddeco.entity.Teacher;
import com.example.springbootdemo2cruddeco.entity.Teacher;
import com.example.springbootdemo2cruddeco.entity.Teacher;
import com.example.springbootdemo2cruddeco.repository.*;
import com.example.springbootdemo2cruddeco.repository.TeacherRepository;
import com.example.springbootdemo2cruddeco.repository.TeacherRepository;
import com.example.springbootdemo2cruddeco.repository.TeacherRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TeacherService
{
    //
    private TeacherRepository teacherRepository=new TeacherRepository();

    //
    public Teacher loadTeacher(String id)
    {
        return this.teacherRepository.loadTeacher(id);
    }

    public List<Teacher> loadAllTeachers()
    {
        return this.teacherRepository.loadAllTeachers();
    }

    public String createTeacher(Teacher teacher)
    {
        Teacher temp=this.loadTeacher(teacher.getId());
        Optional<Teacher> optionalTeacher=Optional.ofNullable(temp);
        if(optionalTeacher.isPresent())
        {
            return "teacher id already exists, canont save! ";
        }
        else
        {
            this.teacherRepository.saveTeacher(teacher);
            return "created. ";
        }
    }

    public String deleteTeacher(String id)
    {
        Teacher temp=this.loadTeacher( id);
        Optional<Teacher> optionalTeacher=Optional.ofNullable(temp);
        if(optionalTeacher.isPresent())
        {
            this.teacherRepository.deleteTeacher( id);
            return "deleted. ";
        }
        else
        {
            return "teacher not existed, no delete! ";
        }
    }

    public  String deleteAllTeachers()
    {
        this.teacherRepository.deleteAllTeachers();
        return "deleted. ";
    }

    public String updateTeacher (Teacher teacher)
    {
        Teacher temp=this.loadTeacher(teacher.getId());
        Optional<Teacher> optionalTeacher=Optional.ofNullable(temp);
        if(optionalTeacher.isPresent())
        {
            this.teacherRepository.saveTeacher(teacher);
            return "updated. ";
        }
        else
        {
            this.teacherRepository.saveTeacher(teacher);
            return "teacher id not existed, cannot updated! ";
        }
    }


//    public void addTeacherForTeacher(String id, Teacher teacher)
//    {
//        teacherRepository.addTeacherForTeacher(id,teacher);
//    }

//    public void updateTeacher( Teacher teacher,Teacher oldTeacher,Teacher newTeacher)
//    {
//        teacherRepository.  updateTeacher( teacher,oldTeacher,newTeacher);
//    }

    public void  addStudent(Teacher teacher,Student student)
    {
        teacherRepository.addStudent(teacher,student);
    }

    public void   removeStudent(Teacher teacher,Student student)
    {
        teacherRepository.  removeStudent(teacher,student);
    }

}
