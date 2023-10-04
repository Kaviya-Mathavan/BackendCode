package com.scholorship.demo.model;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Basic
    private int User_Id;
    private String full_name;
    private String  email;
    private int phone_Number;
    private String Address;
    private String gender;
    private long Aadhar_Number;
    private String community;
    private Timestamp date_of_birth;
    private int Age;
    private String father_name;
    private String father_occupation;
    private int father_monthly_salary;
    private String mother_name;
    private String mother_occupation;
    private int mother_monthly_salary ;
    private String state;
    private String district;
    private int tenth_mark;
    private int register_number_10th ;
//    @Column(name = "11th_Mark_Sheet")
    private int Eleventh_mark;
    private int Twelth_mark;
    private int register_number_12th;
    private String own_house_or_rent_house;
    private int  If_No_Rent_paid_per_month ;
    private String course_type;
    private String reference_name;
    private String  school_type;
    @Lob
    private byte[] Tenth_Mark_Sheet;
    @Lob
    private  byte[] Eleventh_Mark_Sheet;
    @Lob
    private  byte[] Twelth_Mark_Sheet;
    @Lob
    private  byte[] aadhar_card;
    @Lob

    private  byte[] Passport_photo;
    @Lob
    private  byte[]  Community_Certificate;
    @Lob
    private  byte[]  Income_Certificate;
    private int   Year_Of_passing_10th;
    private int   Year_Of_Passing_11th;
    private int   Year_Of_Passing_12th;
    private int    School_id;
    private String School_name_12th;
    private String group_name;
    private String parent;
    private String application_status;
}

