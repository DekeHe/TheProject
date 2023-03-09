package ProfileManagementSystem.Dao;

import ProfileManagementSystem.Models.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DaoImpl implements Dao
{
    Map<String,Student> m=new HashMap<>();
    public void createStudent(Student student)
    {
        m.put(student.getStudentId(),student);
    }

    public Optional<Student> deleteStudentById(String studentId)
    {
        return Optional.ofNullable(m.remove(studentId));
    }

    public void updateStudentNameById(String studentId,String name)
    {
        Student t=m. get(studentId);
        t.setName(name);
        m.put(studentId,t);
    }

    public Student getStudentById(String studentId)
    {
        return m.getOrDefault(studentId,null);
    }

     public List<Student>  getAllStudents()
     {
         return m.values().stream(). collect(Collectors.toList());
     }
}
