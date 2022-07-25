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
public class PhanQuyen {
    private int maPhanQuyen;
    private String tenQuyen;

    public PhanQuyen() {
    }

    public PhanQuyen(int maPhanQuyen, String tenQuyen) {
        this.maPhanQuyen = maPhanQuyen;
        this.tenQuyen = tenQuyen;
    }

    public int getMaPhanQuyen() {
        return maPhanQuyen;
    }

    public void setMaPhanQuyen(int maPhanQuyen) {
        this.maPhanQuyen = maPhanQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    
}
