package in.sk.globalExceptionHandling.dto;

import in.sk.globalExceptionHandling.Gender;
import jakarta.validation.constraints.*;

public class StudentRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 18)
    private String name;

    @NotNull(message = "RollNo is required")
    @Positive(message = "RollNo must be a positive number")
    private Integer rollNo;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    public StudentRequestDto() {
    }

    public StudentRequestDto(String name, Integer rollNo, Gender gender, String email) {
        this.name = name;
        this.rollNo = rollNo;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
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
