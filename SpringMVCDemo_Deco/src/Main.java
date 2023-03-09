import ProfileManagementSystem.Controller.Controller;
import ProfileManagementSystem.Models.Student;

import java.util.Optional;

public class Main
{
    public static void main(String[] args)
    {
        Controller controller =new Controller();


        Student student1=new Student("0001","Kim",20,"300 Rd, NJ");
        controller.createStudent(student1);
        System.out.println("all students after add one students:\t\t"+controller.getAllStudents());

        Student student2=new Student("0002","Tim",21,"678 Rd, NJ");
        controller.createStudent(student2);
        System.out.println("all students after add two students:\t\t"+controller.getAllStudents());

        System.out.println("getStudentById(\"0001\"):\t\t\t\t\t\t"+controller.getStudentById("0001"));

        controller.updateStudentNameById("0001","Kimmy");
        System.out.println("after update \"0001\" by name \"Kimmy\":\t\t"+controller.getAllStudents());

        Optional<Student> optional=controller.deleteStudentById("0001");
        System.out.println("deleted student with \"0001\":\t\t\t\t"+optional.get());
        System.out.print("after delete  \"0001\":\t\t\t\t\t\t"+controller.getAllStudents());
    }
}