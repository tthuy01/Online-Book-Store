/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.GioHang;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.Item;
import model.Sach;
import model.TaiKhoan;

/**
 *
 * @author May Tinh Ha Anh
 */
public class HoaDonDAO extends DBContext {

    public void addOrder(TaiKhoan c, GioHang cart, String phone, String address) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            //add vao order
            String sql = "insert into HoaDon values (?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getMaTaiKhoan());
            st.setString(2, phone);
            st.setInt(3, cart.getTotalMoney());
            st.setString(4, address);
            st.setString(5, date);
            st.executeUpdate();

            //lay ra ma hoa don cua order vua add
            String sql1 = "select top 1 MaHoaDon from HoaDon order by MaHoaDon desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();

            //add vao order detail
            if (rs.next()) {
                int oid = rs.getInt("MaHoaDon");
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into HoaDonChiTiet values (?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, i.getSach().getMaSach());
                    st2.setInt(3, i.getSoLuong());
                    st2.setInt(4, i.getGia());
                    st2.executeUpdate();
                }
            }

            //Giam so luong trong hang ton kho - Cap nhat lai so luong
            String sql3 = "update Sach set SoLuongTonKho = SoLuongTonKho - ? where MaSach = ?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (Item i : cart.getItems()) {
                st3.setInt(1, i.getSoLuong());
                st3.setInt(2, i.getSach().getMaSach());
                st3.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<HoaDon> getAllHoaDon() {
        String sql = "select * from HoaDon";
        List<HoaDon> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt("MaHoaDon"));
                hd.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                hd.setSDTNguoiNhan(rs.getString("SDTNguoiNhan"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setDiaChiShip(rs.getString("DiaChiShip"));
                hd.setNgayDatHang(rs.getString("NgayDatHang"));
                list.add(hd);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public HoaDon getAllHoaDonByMaHoaDon(int maHoaDon) {
        String sql = "select * from HoaDon where MaHoaDon = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, maHoaDon);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt("MaHoaDon"));
                hd.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                hd.setSDTNguoiNhan(rs.getString("SDTNguoiNhan"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setDiaChiShip(rs.getString("DiaChiShip"));
                hd.setNgayDatHang(rs.getString("NgayDatHang"));
                return hd;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<HoaDon> getAllHoaDonByMaTaiKhoan(TaiKhoan a) {
        String sql = "select * from HoaDon where MaTaiKhoan = ?";
        List<HoaDon> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getMaTaiKhoan());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt("MaHoaDon"));
                hd.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                hd.setSDTNguoiNhan(rs.getString("SDTNguoiNhan"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setDiaChiShip(rs.getString("DiaChiShip"));
                hd.setNgayDatHang(rs.getString("NgayDatHang"));
                list.add(hd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<HoaDonChiTiet> getOrderDetailByMaTaiKhoanAndMaHoaDon(int a, int o) {
        SachDAO sdao = new SachDAO();
        HoaDonDAO hddao = new HoaDonDAO();
        String sql = "select od.MaHoaDon, od.MaSach, od.SoLuong, od.Gia, o.MaTaiKhoan, o.SDTNguoiNhan, o.TongTien, o.DiaChiShip, o.NgayDatHang from HoaDonChiTiet od\n" +
                        "inner join HoaDon o on od.MaHoaDon = o.MaHoaDon\n" +
                        "where MaTaiKhoan = ? and o.MaHoaDon = ?";
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a);
            st.setInt(2, o);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Sach s = sdao.getBookByBookId(rs.getInt("MaSach"));
                HoaDon h = hddao.getAllHoaDonByMaHoaDon(rs.getInt("MaHoaDon"));
                HoaDonChiTiet od = new HoaDonChiTiet();
                od.setMaHoaDon(rs.getInt("MaHoaDon"));
                od.setMaSach(rs.getInt("MaSach"));
                od.setSoLuong(rs.getInt("SoLuong"));
                od.setGia(rs.getInt("Gia"));
                od.setSach(s);
                od.setHoaDon(h);
                list.add(od);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        HoaDonDAO hddao = new HoaDonDAO();
        List<HoaDonChiTiet> list = hddao.getOrderDetailByMaTaiKhoanAndMaHoaDon(2, 1);
        System.out.println(list.get(0).getSach().getTenSach());
    }
}
