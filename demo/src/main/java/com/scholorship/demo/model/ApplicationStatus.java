//package com.scholorship.demo.model;
//
//public class ApplicationStatus {
//}

package com.scholorship.demo.model;
import jakarta.persistence.*;
@Entity
@Table(name = "application_status")
public class ApplicationStatus {
    @Id
    @Basic
    private int Application_id;
    private int College_id;
    private int User_id;
    private String Status_Of_Student;
    private int Admin_id;
    private int Foundation_id;

    public int getApplication_id() {
        return Application_id;
    }

    public ApplicationStatus(int application_id, int college_id, int user_id, String status_Of_Student, int admin_id, int foundation_id) {
        Application_id = application_id;
        College_id = college_id;
        User_id = user_id;
        Status_Of_Student = status_Of_Student;
        Admin_id = admin_id;
        Foundation_id = foundation_id;
    }

    public void setApplication_id(int application_id) {
        Application_id = application_id;
    }

    public int getCollege_id() {
        return College_id;
    }

    public void setCollege_id(int college_id) {
        College_id = college_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getStatus_Of_Student() {
        return Status_Of_Student;
    }

    public void setStatus_Of_Student(String status_Of_Student) {
        Status_Of_Student = status_Of_Student;
    }

    public int getAdmin_id() {
        return Admin_id;
    }

    public void setAdmin_id(int admin_id) {
        Admin_id = admin_id;
    }

    public int getFoundation_id() {
        return Foundation_id;
    }

    public void setFoundation_id(int foundation_id) {
        Foundation_id = foundation_id;
    }
}