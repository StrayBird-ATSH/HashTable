public class Student {
    private int studentID;
    private String name;
    private String major;
    private String gender;

    public Student(int studentID, String name, String major, String gender) {
        this.studentID = studentID;
        this.name = name;
        this.major = major;
        this.gender = gender;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
