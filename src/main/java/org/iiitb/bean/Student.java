package org.iiitb.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true)
    private String rollNumber;
    
    @NotBlank
    private String firstName;
    private String middleName;
    private String lastName;
    
    @Column(unique = true)
    private String emailId;
    
    @NotBlank
    private String photograph;
    
    @ManyToOne
    private Domain domain = new Domain();

    @ManyToMany
    private List<Course> courses = new ArrayList<>();
    
    public Student() {
    }
    
    public Student(Integer id) {
        this.id = id;
    }
    
    public Student(String rollNumber, String firstName, String middleName, String lastName, String emailId, String photograph, Domain domain) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.photograph = photograph;
        this.domain = domain;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmailId() {
        return emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public String getPhotograph() {
        return photograph;
    }
    
    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }
    
    public Domain getDomain() {
        return domain;
    }
    
    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
