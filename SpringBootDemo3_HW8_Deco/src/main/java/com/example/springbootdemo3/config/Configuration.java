package com.example.springbootdemo3.config;

import com.example.springbootdemo3.repository.StudentRepository;
import com.example.springbootdemo3.repository.TeacherRepository;
import com.example.springbootdemo3.service.StudentService;
import com.example.springbootdemo3.service.SystemService;
import com.example.springbootdemo3.service.TeacherService;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration
{
    private String DEFAULT_SYSTEM_NAME="Profile";


    @Bean
    public StudentRepository buildStudentRepository()
    {
        return new StudentRepository();
    }

    @Bean
     public TeacherRepository buildTeacherRepository()
    {
        return new TeacherRepository();
    }

    @Bean
    public StudentService buildStudentService()
    {
        return new StudentService();
    }

    @Bean
    public TeacherService buildTeacherService()
    {
        return new TeacherService();
    }

    @Bean(value="basic")
    public SystemService buildSystemService()
    {
        return new SystemService();
    }

    @Bean(value="profile" )
    public SystemService buildProfileSystemService()
    {
        return new SystemService(DEFAULT_SYSTEM_NAME);
    }

}
