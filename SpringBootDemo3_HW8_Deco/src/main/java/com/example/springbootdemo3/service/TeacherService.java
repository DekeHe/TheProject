package com.example.springbootdemo3.service;

import com.example.springbootdemo3.entity.Student;
import com.example.springbootdemo3.entity.Teacher;
import com.example.springbootdemo3.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService
{
    @Autowired
    private TeacherRepository teacherRepository  ;
    public String saveTeacher(Teacher teacher)
    {
        Optional<Teacher> teacher1=Optional.ofNullable(this.loadTeacher(teacher.getId()));
        if(teacher1.isPresent())
        {
            return "teacher already exists!";
        }
        else
        {
            teacherRepository.saveTeacher(teacher);
            return "created.";
        }
    }
    public String deleteTeacher(String id)
    {
        Optional<Teacher> teacher1=Optional.ofNullable(this.loadTeacher(id));
        if(teacher1.isPresent())
        {
            teacherRepository.deleteTeacher(id);
            return "deleted.";
        }
        else
        {
            return "teacher not exists!";
        }
    }
    public String deleteAllTeachers()
    {
        teacherRepository.deleteAllTeachers();
        return "deleted.";

    }
    public String  updateTeacher(  Teacher teacher)
    {
        Optional<Teacher> teacher1=Optional.ofNullable(this.loadTeacher(teacher.getId()));
        if(teacher1.isPresent())
        {
            teacherRepository. updateTeacher(  teacher);
            return "updated.";
        }
        else
        {
            return "teacher not exists" ;
        }

    }
    public Teacher loadTeacher(String teacherId)
    {
        return teacherRepository.loadTeacher(teacherId);
    }

    public List<Teacher> listTeachers()
    {
        return teacherRepository.listTeachers();
    }


    public void  addStudent(Teacher teacher,   Student student)
    {
        teacherRepository.addStudent(teacher,student);
    }

    public void   removeStudent(Teacher teacher,Student student)
    {
        teacherRepository.  removeStudent(teacher,student);
    }

}
