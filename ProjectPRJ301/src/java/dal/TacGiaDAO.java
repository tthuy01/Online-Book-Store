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
import model.TacGia;

/**
 *
 * @author May Tinh Ha Anh
 */
public class TacGiaDAO extends DBContext{
    public List<TacGia> getAllTacGia() {
        List<TacGia> list = new ArrayList<>();
        String sql = "select * from TacGia";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                TacGia t = new TacGia();
                t.setMaTacGia(rs.getInt("MaTacGia"));
                t.setTenTacGia(rs.getString("TenTacGia"));
                t.setGioiTinh(rs.getBoolean("GioiTinh"));
                t.setNgaySinh(rs.getString("NgaySinh"));
                t.setDiaChi(rs.getString("DiaChi"));
                list.add(t);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public void insertTacGia(TacGia tg)
    {
        String sql = "insert into TacGia values(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tg.getTenTacGia());
            st.setBoolean(2, tg.isGioiTinh());
            st.setString(3, tg.getNgaySinh());
            st.setString(4, tg.getDiaChi());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public TacGia getTacGiaByTacGiaId(int maTacGia) {
        String sql = "select * from TacGia where MaTacGia = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, maTacGia);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                TacGia tg = new TacGia();
                tg.setMaTacGia(maTacGia);
                tg.setTenTacGia(rs.getString("TenTacGia"));
                tg.setGioiTinh(rs.getBoolean("GioiTinh"));
                tg.setNgaySinh(rs.getString("NgaySinh"));
                tg.setDiaChi(rs.getString("DiaChi"));
                return tg;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        TacGiaDAO tgDAO = new TacGiaDAO();
        List<TacGia> list = tgDAO.getAllTacGia();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getTenTacGia());
//        }

//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).getTenTacGia().equalsIgnoreCase("a")&&list.get(i).getNgaySinh().contains("2000-02-02")&&list.get(i).getDiaChi().equalsIgnoreCase("TN")&&list.get(i).isGioiTinh()==true)
//            {
//                System.out.println("Hiển thị");
//            }
//        }
        
//        TacGia tg = new TacGia(0, "Trần Thị A", true, "2001-02-02", "Hà Nội");
//        tgDAO.insertTacGia(tg);

        TacGia tg = tgDAO.getTacGiaByTacGiaId(1);
        if(tg!=null)
            System.out.println(tg.isGioiTinh());
    }
}
