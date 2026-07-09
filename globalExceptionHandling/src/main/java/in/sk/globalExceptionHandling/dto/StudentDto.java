package in.sk.globalExceptionHandling.dto;

import in.sk.globalExceptionHandling.Gender;

public class StudentDto {
    private long id;
    private String name;
    private int rollNo;
    private Gender gender;
    private String email;

    public StudentDto() {}

    public StudentDto(long id, String name, int rollNo, Gender gender, String email) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.gender = gender;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
