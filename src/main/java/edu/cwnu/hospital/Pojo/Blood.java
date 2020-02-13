package edu.cwnu.hospital.Pojo;

import java.io.Serializable;
import java.util.Date;

public class Blood implements Serializable {
    private int b_id;
    private Date p_date;
    private Date e_date;
    private int capacity;
    private int u_id;
    private int h_id;
    private  String state;
    private User user;
    private Hospital hospital;

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public Date getE_date() {
        return e_date;
    }

    public void setE_date(Date e_date) {
        this.e_date = e_date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Blood{" +
                "b_id=" + b_id +
                ", p_date=" + p_date +
                ", e_date=" + e_date +
                ", capacity=" + capacity +
                ", u_id=" + u_id +
                ", h_id=" + h_id +
                ", state='" + state + '\'' +
                ", user=" + user +
                ", hospital=" + hospital +
                '}';
    }
}
