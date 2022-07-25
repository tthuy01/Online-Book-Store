/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author May Tinh Ha Anh
 */
public class DoanhThu {
    private int maSach;
    private String tenSach;
    private int tongDoanhThu;

    public DoanhThu() {
    }

    public DoanhThu(int maSach, String tenSach, int tongDoanhThu) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tongDoanhThu = tongDoanhThu;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(int tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }
    
}
