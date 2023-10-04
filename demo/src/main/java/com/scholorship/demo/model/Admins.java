package com.scholorship.demo.model;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "admins")
public class Admins {
    @Id
    @Basic
    private int Admin_Id;
    private String Admin_name;

    public void setAdmin_Id(int admin_Id) {
        Admin_Id = admin_Id;
    }

    public void setAdmin_name(String admin_Name) {
        Admin_name = admin_Name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setContact_Number(long contact_Number) {
        Contact_Number = contact_Number;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setFoundation_id(int foundation_id) {
        Foundation_id = foundation_id;
    }

    private String Address;
    private long Contact_Number;
    private String Email;
    private int Foundation_id;

    public Admins(int admin_Id, String admin_Name, String address, long contact_Number, String email, int foundation_id) {
        Admin_Id = admin_Id;
        Admin_name = admin_Name;
        Address = address;
        Contact_Number = contact_Number;
        Email = email;
        Foundation_id = foundation_id;
    }
    public Admins(){}
}
