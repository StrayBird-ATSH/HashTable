public class Student {
    private long studentID;
    private String name;
    private String major;
    private String gender;
    private int age;
    private long tel;
    private boolean deleted = false;

    long getStudentID() {
        return studentID;
    }

    public long getTel() {
        return tel;
    }

    Student(long studentID, String name, String major, String gender, int age, long tel) {
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
