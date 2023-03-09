package com.example.springbootdemo2cruddeco.repository;

import com.example.springbootdemo2cruddeco.entity.*;
import com.example.springbootdemo2cruddeco.entity.Teacher;
import com.example.springbootdemo2cruddeco.entity.Teacher;
import com.example.springbootdemo2cruddeco.entity.Teacher;

import java.util.*;

public class TeacherRepository
{
    //
    private static Map<String,Teacher> teacherHashMap=new HashMap<>();

    //
    public Teacher loadTeacher(String id)
    {
        return teacherHashMap.getOrDefault(id,null);
    }

    public List<Teacher> loadAllTeachers()
    {
        return new ArrayList<>(teacherHashMap.values());
    }

    public void saveTeacher(Teacher teacher)
    {
        teacherHashMap.put(teacher.getId(),teacher);
    }

    public void deleteTeacher(String id)
    {
        teacherHashMap.remove(id);
    }

    public void deleteAllTeachers()
    {
        teacherHashMap.clear();
    }


//    public void addTeacherForTeacher(String id, Teacher teacher)
//    {
//        for( Map.Entry<String,Teacher> entry:teacherHashMap.entrySet())
//        {
//            if(entry.getKey()==id)
//            {
//                Teacher t=entry.getValue();
//                t.addTeacher(teacher);
//                entry.setValue(t);
//            }
//        }
//    }

//    public void updateTeacher( Teacher teacher,Teacher   oldTeacher,Teacher newTeacher)
//    {
//        teacher.updateTeacher(oldTeacher,newTeacher);
//        for( Map.Entry<String,Teacher> entry:teacherHashMap.entrySet())
//        {
//            if(entry.getKey()==teacher.getId())
//            {
//                entry.setValue(teacher);
//            }
//        }
//    }
//


    public void addStudent(Teacher teacher,Student student)
    {
        teacher.getStudents().add(student);
    }

    public void removeStudent(Teacher teacher,Student student)
    {
        teacher.getStudents().remove(student);
    }

}
