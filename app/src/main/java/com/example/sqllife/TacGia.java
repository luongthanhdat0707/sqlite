package com.example.sqllife;

public class TacGia {
    private int maso;
    private String ten;
    private String diachi;
    private String email;

    public TacGia() {
        this.maso = 0;
        this.ten = null;
        this.diachi = null;
        this.email = null;
    }

    public TacGia(int maso, String ten, String diachi, String email) {
        this.maso = maso;
        this.ten = ten;
        this.diachi = diachi;
        this.email = email;
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


