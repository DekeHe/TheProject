package com.example.springbootdemo3.service;

import com.example.springbootdemo3.entity.Student;
import com.example.springbootdemo3.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Service
public class SystemService
{
    @Autowired
    private StudentService studentService;
    @Autowired
     private TeacherService teacherService;

    private String name;
//    private HashMap<String,String> storage;
//    private HashMap<String,String>  profiles;

    public SystemService()
    {
        super();
    }

    public SystemService(String name)
    {
        this.name=name;
    }

    //
    public String signupStudentTeacher(String studentId,String teacherId)
    {
        Student student=this.studentService.loadStudent(studentId);
        Teacher teacher=this.teacherService.loadTeacher(teacherId);

        if(student!=null && teacher!=null)
        {
            student.setTeacherId(teacherId);
            studentService.saveStudent(student);

            teacherService.addStudent(teacher,student);
            teacherService.saveTeacher(teacher);

            return "signed up.";
        }
        else
        {
            return "not both existed!";
        }

    }

    @PutMapping(value="/update/signup")
    public String updateStudentTeacher(@RequestParam(value="studentId")String studentId,
                                       @RequestParam(value="oldTeacherId") String oldTeacherId,
                                       @RequestParam(value="newTeacherId")String newTeacherId)
    {
        Student student=this.studentService.loadStudent(studentId);
        Teacher oldTeacher=this.teacherService.loadTeacher(oldTeacherId);
        Teacher newTeacher=this.teacherService.loadTeacher(newTeacherId);

        if(student!=null && student.getTeacherId().equals(oldTeacherId ) && oldTeacher!=null && newTeacher!=null)
        {
            teacherService. removeStudent(oldTeacher,student);
            teacherService.  addStudent(newTeacher,student);

            student.setTeacherId(newTeacherId);
            studentService.saveStudent(student);

            return "updated.";
        }
        else
        {
            return  "cannot work!";
        }
    }

    @DeleteMapping(value="/delete/signup")
    public String deleteStudentTeacher(@RequestParam(value="studentId")String studentId,
                                       @RequestParam(value="teacherId")String teacherId)
    {
        Student student=this.studentService.loadStudent(studentId);
        Teacher teacher=this.teacherService.loadTeacher(teacherId);

        if(student!=null && student.getTeacherId().equals(teacherId) &&  teacher!=null)
        {

            teacherService.removeStudent(teacher,student);
            teacherService.saveTeacher(teacher);

            student.setTeacherId(null);
            studentService.saveStudent(student);
            return "deleted.";
        }
        else
        {
            return "cannot work!";
        }

    }

}
