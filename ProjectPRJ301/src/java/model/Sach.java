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
public class Sach {
    private int maSach;
    private String tenSach;
    private String anh;
    private String maTheLoai;
    private int maTacGia;
    private String maNXB;
    private String ngayXB;
    private int gia;
    private int soLuongTonKho;
    private TheLoai tl;
    private TacGia tg;
    private NXB n;

    public Sach() {
    }

    public Sach(int maSach, String tenSach, String anh, String maTheLoai, int maTacGia, String maNXB, String ngayXB, int gia, int soLuongTonKho) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.anh = anh;
        this.maTheLoai = maTheLoai;
        this.maTacGia = maTacGia;
        this.maNXB = maNXB;
        this.ngayXB = ngayXB;
        this.gia = gia;
        this.soLuongTonKho = soLuongTonKho;
    }

    public Sach(int maSach, String tenSach, String anh, String maTheLoai, int maTacGia, String maNXB, String ngayXB, int gia, int soLuongTonKho, TheLoai tl, TacGia tg, NXB n) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.anh = anh;
        this.maTheLoai = maTheLoai;
        this.maTacGia = maTacGia;
        this.maNXB = maNXB;
        this.ngayXB = ngayXB;
        this.gia = gia;
        this.soLuongTonKho = soLuongTonKho;
        this.tl = tl;
        this.tg = tg;
        this.n = n;
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

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public int getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getNgayXB() {
        return ngayXB;
    }

    public void setNgayXB(String ngayXB) {
        this.ngayXB = ngayXB;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public TheLoai getTl() {
        return tl;
    }

    public void setTl(TheLoai tl) {
        this.tl = tl;
    }

    public TacGia getTg() {
        return tg;
    }

    public void setTg(TacGia tg) {
        this.tg = tg;
    }

    public NXB getN() {
        return n;
    }

    public void setN(NXB n) {
        this.n = n;
    }
   
}
