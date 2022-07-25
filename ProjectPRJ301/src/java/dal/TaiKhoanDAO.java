/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.PhanQuyen;
import model.TaiKhoan;

/**
 *
 * @author May Tinh Ha Anh
 */
public class TaiKhoanDAO extends DBContext{
    public TaiKhoan check(String user, String pass)
    {
        String sql = "select * from TaiKhoan where TenDangNhap = ? and MatKhau = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next())
            {
                PhanQuyenDAO pqdao = new PhanQuyenDAO();
                PhanQuyen pq = pqdao.getQuyenByMaPhanQuyen(rs.getInt("MaPhanQuyen"));
                TaiKhoan t = new TaiKhoan();
                t.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                t.setTen(rs.getString("Ten"));
                t.setGioiTinh(rs.getBoolean("GioiTinh"));
                t.setNgaySinh(rs.getString("NgaySinh"));
                t.setSDT(rs.getString("SDT"));
                t.setEmail(rs.getString("Email"));
                t.setDiaChi(rs.getString("DiaChi"));
                t.setTenDangNhap(rs.getString("TenDangNhap"));
                t.setMatKhau(rs.getString("MatKhau"));
                t.setMaPhanQuyen(rs.getInt("MaPhanQuyen"));
                t.setPhanQuyen(pq);
                return t;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public TaiKhoan checkAccountExist(String user)
    {
        String sql = "select * from TaiKhoan where TenDangNhap = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next())
            {
                PhanQuyenDAO pqdao = new PhanQuyenDAO();
                PhanQuyen pq = pqdao.getQuyenByMaPhanQuyen(rs.getInt("MaPhanQuyen"));
                TaiKhoan t = new TaiKhoan();
                t.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                t.setTen(rs.getString("Ten"));
                t.setGioiTinh(rs.getBoolean("GioiTinh"));
                t.setNgaySinh(rs.getString("NgaySinh"));
                t.setSDT(rs.getString("SDT"));
                t.setEmail(rs.getString("Email"));
                t.setDiaChi(rs.getString("DiaChi"));
                t.setTenDangNhap(rs.getString("TenDangNhap"));
                t.setMatKhau(rs.getString("MatKhau"));
                t.setMaPhanQuyen(rs.getInt("MaPhanQuyen"));
                t.setPhanQuyen(pq);
                return t;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public void signUp(TaiKhoan tk) {
        String sql = "insert into TaiKhoan values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tk.getTen());
            st.setBoolean(2, tk.isGioiTinh());
            st.setString(3, tk.getNgaySinh());
            st.setString(4, tk.getSDT());
            st.setString(5, tk.getEmail());
            st.setString(6, tk.getDiaChi());
            st.setString(7, tk.getTenDangNhap());
            st.setString(8, tk.getMatKhau());
            st.setInt(9, 0);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void changePassword(String newpass, int maTaiKhoan) {
        String sql = "update TaiKhoan set MatKhau = ? where MaTaiKhoan = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newpass);
            st.setInt(2, maTaiKhoan);
            st.executeUpdate();           
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updateInformation(TaiKhoan a) {
        String sql = "update TaiKhoan set Ten = ?, GioiTinh = ?, NgaySinh = ?, SDT = ?, Email = ?, DiaChi =  ? where MaTaiKhoan = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getTen());
            st.setBoolean(2, a.isGioiTinh());
            st.setString(3, a.getNgaySinh());
            st.setString(4, a.getSDT());
            st.setString(5, a.getEmail());
            st.setString(6, a.getDiaChi());
            st.setInt(7, a.getMaTaiKhoan());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public TaiKhoan getAccountById(int maTaiKhoan)
    {
        String sql = "select * from TaiKhoan where MaTaiKhoan = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, maTaiKhoan);
            ResultSet rs = st.executeQuery();
            if (rs.next())
            {
                PhanQuyenDAO pqdao = new PhanQuyenDAO();
                PhanQuyen pq = pqdao.getQuyenByMaPhanQuyen(rs.getInt("MaPhanQuyen"));
                TaiKhoan t = new TaiKhoan();
                t.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                t.setTen(rs.getString("Ten"));
                t.setGioiTinh(rs.getBoolean("GioiTinh"));
                t.setNgaySinh(rs.getString("NgaySinh"));
                t.setSDT(rs.getString("SDT"));
                t.setEmail(rs.getString("Email"));
                t.setDiaChi(rs.getString("DiaChi"));
                t.setTenDangNhap(rs.getString("TenDangNhap"));
                t.setMatKhau(rs.getString("MatKhau"));
                t.setMaPhanQuyen(rs.getInt("MaPhanQuyen"));
                t.setPhanQuyen(pq);
                return t;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        TaiKhoanDAO tkdao = new TaiKhoanDAO();
//        TaiKhoan tk = tkdao.check("thuytran01", "123456");
//        System.out.println(tk.getPhanQuyen().getTenQuyen());
//        TaiKhoan tk1 = tkdao.checkAccountExist("admin");
//        System.out.println(tk1.getPhanQuyen().getTenQuyen());
//        tkdao.signUp(new TaiKhoan(0, "Nguyễn Thị B", true, "2001-10-10", "012345678", "bnguyen@gmail.com", "Hà Nội", "bnguyen01", "123456", 0));
//        TaiKhoan a = new TaiKhoan(2, "Tran Thi Thanh Thuy", true, "2001-03-10", "012345678", "thuytran01@mail.com", "TN", "", "", 0);
//        tkdao.updateInformation(a);

//        TaiKhoan a = tkdao.getAccountById(1);
//        System.out.println(a.getTen());
    }
}
