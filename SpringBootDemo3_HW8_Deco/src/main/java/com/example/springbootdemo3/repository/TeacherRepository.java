package com.example.springbootdemo3.repository;

import com.example.springbootdemo3.entity.Student;
import com.example.springbootdemo3.entity.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherRepository
{
    static Map<String, Teacher> teacherHashMap=new HashMap<>();
    public void saveTeacher(Teacher teacher)
    {
        String id=teacher.getId();
        if(!teacherHashMap.containsKey(id))
        {
            teacherHashMap.put(id,teacher);
        }

    }
    public void deleteTeacher(String id)
    {
        if(teacherHashMap.containsKey(id))
        {
            teacherHashMap.remove(id);
        }
    }

    public void deleteAllTeachers()
    {
        teacherHashMap.clear();
    }

    public void  updateTeacher(Teacher teacher)
    {
        String id=teacher.getId();
        if(teacherHashMap.containsKey(id))
        {
            teacherHashMap.put(id,teacher);
        }
    }

    public Teacher loadTeacher(String id)
    {
        return teacherHashMap.getOrDefault(id,null);
    }

    public List<Teacher> listTeachers()
    {
//        return teacherHashMap.values().stream(). collect(Collectors.toList());
        return new ArrayList<>(teacherHashMap.values());
    }

    public void addStudent(Teacher teacher, Student student)
    {
        teacher.addStudent(student);
        for( Map.Entry<String,Teacher> entry:teacherHashMap.entrySet())
        {
            if(entry.getKey()==teacher.getId())
            {
                entry.setValue(teacher);
            }
        }
    }

    public void removeStudent(Teacher teacher,Student student)
    {
        teacher.removeStudent(student);
        for( Map.Entry<String,Teacher> entry:teacherHashMap.entrySet())
        {
            if(entry.getKey()==teacher.getId())
            {
                entry.setValue(teacher);
            }
        }
    }
}
