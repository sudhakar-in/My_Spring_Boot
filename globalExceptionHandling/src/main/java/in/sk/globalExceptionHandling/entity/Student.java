package in.sk.globalExceptionHandling.entity;

import in.sk.globalExceptionHandling.Gender;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int rollNo;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
    private boolean active;

    public Student() {
    }

    public Student(String name, int rollNo, Gender gender, String email, boolean active) {
        this.name = name;
        this.rollNo = rollNo;
        this.gender = gender;
        this.email = email;
        this.active = active;
    }

    public long getId() {
        return id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
