package com.example.demogridviewadvanced;

import java.io.Serializable;

public class HinhAnh implements Serializable {
    private int hinh;
    private String ten;

    public HinhAnh(int hinh, String ten) {
        this.hinh = hinh;
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}