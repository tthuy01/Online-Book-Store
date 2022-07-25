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
public class Item {
    private Sach sach;
    private int soLuong;
    private int gia;

    public Item() {
    }

    public Item(Sach sach, int soLuong, int gia) {
        this.sach = sach;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
}
