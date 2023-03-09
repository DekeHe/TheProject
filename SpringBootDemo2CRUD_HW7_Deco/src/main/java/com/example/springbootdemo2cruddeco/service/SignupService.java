package com.example.springbootdemo2cruddeco.service;

import com.example.springbootdemo2cruddeco.entity.Student;
import com.example.springbootdemo2cruddeco.entity.Teacher;
import com.example.springbootdemo2cruddeco.repository.StudentRepository;
import com.example.springbootdemo2cruddeco.repository.TeacherRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class SignupService
{
    //
    private StudentService studentService=new StudentService();
    private TeacherService teacherService=new TeacherService();

    //
    public String signupStudentTeacher(String studentId,String teacherId)
    {
        Optional<Student> optionalStudent=Optional.ofNullable(this.studentService.loadStudent(studentId) );
        Optional<Teacher> optionalTeacher=Optional.ofNullable(this.teacherService.loadTeacher(teacherId) );

        if(optionalStudent.isPresent() && optionalTeacher.isPresent())
        {
            studentService.setTeacherId(optionalStudent.get(),teacherId);
            studentService.updateStudent(optionalStudent.get());

            teacherService.addStudent(optionalTeacher.get(),optionalStudent.get());
            teacherService.updateTeacher(optionalTeacher.get());

            return "signed up.";
        }
        else
        {
            return "not both existed!";
        }

    }
    public String updateStudentTeacher(String studentId,String newTeacherId)
    {
        Optional<Student> optionalStudent=Optional.ofNullable(this.studentService.loadStudent(studentId));
        Optional<Teacher> optionalNewTeacher=Optional.ofNullable(this.teacherService.loadTeacher(newTeacherId));

        if(optionalStudent.isPresent() && optionalNewTeacher.isPresent()&&  newTeacherId!=null)
        {
            Optional<Teacher> optionalOldTeacher=Optional.ofNullable(this.teacherService.loadTeacher(optionalStudent.get().getTeacherId()) );
            if(optionalOldTeacher.isPresent())
            {
                this.teacherService. removeStudent(optionalOldTeacher.get(),optionalStudent.get());
            }


            teacherService.  addStudent(optionalNewTeacher.get(), optionalStudent.get());
            studentService.setTeacherId(  optionalStudent.get(),newTeacherId);

            return "updated.";
        }
        else
        {
            return  "cannot work!";
        }
    }

    public String deleteStudentTeacher(String studentId,String teacherId)
    {
        Optional<Student> optionalStudent=Optional.ofNullable(this.studentService.loadStudent(studentId));
        Optional<Teacher>  optionalNewTeacher=Optional.ofNullable(this.teacherService.loadTeacher(teacherId)) ;

        if(  optionalStudent.isPresent() &&  optionalNewTeacher.isPresent() )
        {
            Optional<Teacher> optionalOldTeacher=Optional.ofNullable(this. teacherService.loadTeacher (optionalStudent.get().getTeacherId()));

            teacherService.removeStudent(optionalOldTeacher.get(),optionalStudent.get());
            teacherService.updateTeacher(optionalOldTeacher.get());

            studentService.setTeacherId( optionalStudent .get(),null);
            studentService.updateStudent(optionalStudent .get());
            return "deleted.";
        }
        else
        {
            return "cannot work!";
        }

    }


}
