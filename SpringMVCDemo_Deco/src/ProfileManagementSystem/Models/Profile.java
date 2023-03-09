package ProfileManagementSystem.Models;

public class Profile
{
    private String studentId;
    public Profile(String studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "studentId='" + studentId + '\'' +
                ',';
    }
}
