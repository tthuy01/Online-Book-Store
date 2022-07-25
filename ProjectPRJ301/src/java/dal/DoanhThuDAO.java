/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DoanhThu;

/**
 *
 * @author May Tinh Ha Anh
 */
public class DoanhThuDAO extends DBContext{
    public List<DoanhThu> getListTopDoanhThu() {
        String sql = "select top 10 b.MaSach, b.TenSach, sum(od.SoLuong * b.Gia) as DoanhThu from Sach b\n" +
                        "inner join HoaDonChiTiet od\n" +
                        "on b.MaSach = od.MaSach\n" +
                        "group by b.MaSach, b.TenSach\n" +
                        "order by sum(od.SoLuong) desc";
        List<DoanhThu> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                DoanhThu d = new DoanhThu();
                d.setMaSach(rs.getInt("MaSach"));
                d.setTenSach(rs.getString("TenSach"));
                d.setTongDoanhThu(rs.getInt("DoanhThu"));
                list.add(d);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public List<String> getTime() {
        List<String> list = new ArrayList<>();
        String sql = "select distinct YEAR(NgayDatHang) as Nam, MONTH(NgayDatHang) as Thang, CONCAT(MONTH(NgayDatHang),'/',YEAR(NgayDatHang)) as ThoiGian from HoaDon\n" +
                                "order by YEAR(NgayDatHang) desc, MONTH(NgayDatHang) desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                list.add(rs.getString("ThoiGian"));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public int doanhThuTheoThang(int m, int y) {
        int d = 0;
        String sql = "select sum(od.SoLuong * od.Gia) as DoanhThu from HoaDonChiTiet od\n" +
                        "inner join HoaDon o\n" +
                        "on o.MaHoaDon = od.MaHoaDon\n" +
                        "where MONTH(o.NgayDatHang) = ? and YEAR(o.NgayDatHang) = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, m);
            st.setInt(2, y);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                d = rs.getInt("DoanhThu");
            }
        } catch (SQLException e) {
        }
        return d;
    }
    
    public List<Integer> listSaleByTime(List<String> time) {
        DoanhThuDAO d = new DoanhThuDAO();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < time.size(); i++) {
            String[] t = time.get(i).split("/");
            list.add(d.doanhThuTheoThang(Integer.parseInt(t[0]), Integer.parseInt(t[1])));
        }
        return list;
    }
    
    public List<Integer> soLuongBanTheoTheLoai() {
        List<Integer> list = new ArrayList<>();
        String sql = "select g.TheLoai ,sum(od.SoLuong) as LuotBan from Sach b\n" +
                        "inner join HoaDonChiTiet od on b.MaSach = od.MaSach\n" +
                        "inner join TheLoai g on b.MaTheLoai = g.MaTheLoai\n" +
                        "group by g.TheLoai, b.MaTheLoai";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                list.add(rs.getInt("LuotBan"));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public static void main(String[] args) {
        DoanhThuDAO dao = new DoanhThuDAO();
        List<DoanhThu> list = dao.getListTopDoanhThu();
//        System.out.println(list.get(0).getTongDoanhThu());
//        int d = dao.doanhThuTheoThang(2,2022);
//        System.out.println(d);
        List<String> list1 = dao.getTime();
//        System.out.println(list1.get(0));
        List<Integer> list2 = dao.listSaleByTime(list1);
        System.out.println(list2.get(0));
        List<Integer> list3 = dao.soLuongBanTheoTheLoai();
        System.out.println(list3.get(0));
        
    }
}
