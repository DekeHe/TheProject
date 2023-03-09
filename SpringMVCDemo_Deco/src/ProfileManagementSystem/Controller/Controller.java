package ProfileManagementSystem.Controller;

import ProfileManagementSystem.Models.Student;
import ProfileManagementSystem.Service.Service;
import ProfileManagementSystem.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

public class Controller
{
     private Service service=new ServiceImpl();
     public void createStudent(Student student)
     {
          service.createStudent(student);
     }

     public Optional<Student> deleteStudentById(String studentId)
     {
          return service.deleteStudentById(studentId);
     }

     public void updateStudentNameById(String studentId,String name)
     {
          service.updateStudentNameById(studentId, name);
     }

     public Student getStudentById(String studentId)
     {
          return service.getStudentById(studentId);
     }

     public List<Student> getAllStudents()
     {
          return service.getAllStudents();
     }
}
