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
public class HoaDon {
    private int maHoaDon;
    private int maTaiKhoan;
    private String SDTNguoiNhan;
    private int tongTien;
    private String diaChiShip;
    private String ngayDatHang;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, int maTaiKhoan, String SDTNguoiNhan, int tongTien, String diaChiShip, String ngayDatHang) {
        this.maHoaDon = maHoaDon;
        this.maTaiKhoan = maTaiKhoan;
        this.SDTNguoiNhan = SDTNguoiNhan;
        this.tongTien = tongTien;
        this.diaChiShip = diaChiShip;
        this.ngayDatHang = ngayDatHang;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getSDTNguoiNhan() {
        return SDTNguoiNhan;
    }

    public void setSDTNguoiNhan(String SDTNguoiNhan) {
        this.SDTNguoiNhan = SDTNguoiNhan;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getDiaChiShip() {
        return diaChiShip;
    }

    public void setDiaChiShip(String diaChiShip) {
        this.diaChiShip = diaChiShip;
    }

    public String getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    
}
