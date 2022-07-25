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
public class HoaDonChiTiet {
    private int maHoaDon;
    private int maSach;
    private int soLuong;
    private int gia;
    private HoaDon hoaDon;
    private Sach sach;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maHoaDon, int maSach, int soLuong, int gia) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public HoaDonChiTiet(int maHoaDon, int maSach, int soLuong, int gia, HoaDon hoaDon, Sach sach) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.gia = gia;
        this.hoaDon = hoaDon;
        this.sach = sach;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
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

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }
    
    
}
