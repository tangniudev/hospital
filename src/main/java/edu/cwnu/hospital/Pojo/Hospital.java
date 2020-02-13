package edu.cwnu.hospital.Pojo;

import java.io.Serializable;

public class Hospital implements Serializable {
    private int h_id;
    private String h_address;
    private String h_name;
    private int h_total;
    private int typeA;
    private int typeB;
    private  int TypeAB;
    private  int TypeO;

    public int getTypeA() {
        return typeA;
    }

    public void setTypeA(int typeA) {
        this.typeA = typeA;
    }

    public int getTypeB() {
        return typeB;
    }

    public void setTypeB(int typeB) {
        this.typeB = typeB;
    }

    public int getTypeAB() {
        return TypeAB;
    }

    public void setTypeAB(int typeAB) {
        TypeAB = typeAB;
    }

    public int getTypeO() {
        return TypeO;
    }

    public void setTypeO(int typeO) {
        TypeO = typeO;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getH_address() {
        return h_address;
    }

    public void setH_address(String h_address) {
        this.h_address = h_address;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public int getH_total() {
        return h_total;
    }

    public void setH_total(int h_total) {
        this.h_total = h_total;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "h_id=" + h_id +
                ", h_address='" + h_address + '\'' +
                ", h_name='" + h_name + '\'' +
                ", h_total=" + h_total +
                ", typeA=" + typeA +
                ", typeB=" + typeB +
                ", TypeAB=" + TypeAB +
                ", TypeO=" + TypeO +
                '}';
    }
}
