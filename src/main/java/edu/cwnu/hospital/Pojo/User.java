package edu.cwnu.hospital.Pojo;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {
    private int u_id;
    private int u_number;
    private String u_name;
    private String u_gender;
    private int u_password;
    private String u_type;
    private int u_totle;
    private String u_address;
    private String u_mail;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date u_birthday;
    private  String u_phone;

    public int getId() {
        return u_id;
    }

    public void setId(int id) {
        this.u_id = id;
    }

    public int getU_number() {
        return u_number;
    }

    public void setU_number(int u_number) {
        this.u_number = u_number;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_gender() {
        return u_gender;
    }

    public void setU_gender(String u_gender) {
        this.u_gender = u_gender;
    }

    public int getU_password() {
        return u_password;
    }

    public void setU_password(int u_password) {
        this.u_password = u_password;
    }

    public String getU_type() {
        return u_type;
    }

    public void setU_type(String u_type) {
        this.u_type = u_type;
    }

    public int getU_totle() {
        return u_totle;
    }

    public void setU_totle(int u_totle) {
        this.u_totle = u_totle;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public String getU_mail() {
        return u_mail;
    }

    public void setU_mail(String u_mail) {
        this.u_mail = u_mail;
    }

    public Date getU_birthday() {
        return u_birthday;
    }

    public void setU_birthday(Date u_birthday) {
        this.u_birthday = u_birthday;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_number=" + u_number +
                ", u_name='" + u_name + '\'' +
                ", u_gender='" + u_gender + '\'' +
                ", u_password=" + u_password +
                ", u_type='" + u_type + '\'' +
                ", u_totle=" + u_totle +
                ", u_address='" + u_address + '\'' +
                ", u_mail='" + u_mail + '\'' +
                ", u_birthday=" + u_birthday +
                ", u_phone='" + u_phone + '\'' +
                '}';
    }
}
