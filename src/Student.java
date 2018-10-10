public class Student {
    private int studentID;
    private String name;
    private String major;
    private String gender;
    private int age;
    private int tel;
    private boolean deleted = false;

    Student(int studentID, String name, String major, String gender, int age, int tel) {
        this.studentID = studentID;
        this.name = name;
        this.major = major;
        this.gender = gender;
        this.age = age;
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    boolean isDeleted() {
        return deleted;
    }

    void setDeleted() {
        this.deleted = true;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    String getName() {
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
