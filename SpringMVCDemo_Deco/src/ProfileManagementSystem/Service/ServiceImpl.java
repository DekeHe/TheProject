package ProfileManagementSystem.Service;

import ProfileManagementSystem.Dao.Dao;
import ProfileManagementSystem.Dao.DaoImpl;
import ProfileManagementSystem.Models.Student;

import java.util.List;
import java.util.Optional;

public class ServiceImpl implements Service
{
    private Dao dao =new DaoImpl();
    public void createStudent(Student student)
    {
        dao.createStudent(student);
    }

    public Optional<Student> deleteStudentById(String studentId)
    {
        return dao.deleteStudentById(studentId);
    }

    public void updateStudentNameById(String studentId,String name)
    {
        dao.updateStudentNameById(studentId, name);
    }

    public Student getStudentById(String studentId)
    {
        return dao.getStudentById(studentId);
    }

    public List<Student> getAllStudents()
    {
        return dao.getAllStudents();
    }
}
