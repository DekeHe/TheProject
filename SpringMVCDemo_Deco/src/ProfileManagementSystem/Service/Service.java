package ProfileManagementSystem.Service;

import ProfileManagementSystem.Models.Student;

import java.util.List;
import java.util.Optional;

public interface Service
{
    void createStudent(Student student);
    Optional<Student> deleteStudentById(String studentId);
    void updateStudentNameById( String studentId,String  name);
    Student getStudentById(String studentId);
    List<Student> getAllStudents();
}
