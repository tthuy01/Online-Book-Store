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
import model.TheLoai;

/**
 *
 * @author May Tinh Ha Anh
 */
public class TheLoaiDAO extends DBContext{
    public List<TheLoai> getAllTheLoai() {
        List<TheLoai> list = new ArrayList<>();
        String sql = "select * from TheLoai";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                TheLoai t = new TheLoai();
                t.setMaTheLoai(rs.getString("MaTheLoai"));
                t.setTheLoai(rs.getString("TheLoai"));
                list.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public TheLoai getTheLoaiByTheLoaiId(String maTheLoai) {
        String sql = "select * from TheLoai where MaTheLoai = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maTheLoai);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                TheLoai tl = new TheLoai();
                tl.setMaTheLoai(maTheLoai);
                tl.setTheLoai(rs.getString("TheLoai"));
                return tl;
            }           
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        TheLoaiDAO tldao = new TheLoaiDAO();
//        List<TheLoai> list = tldao.getAllTheLoai();
//        System.out.println(list.get(0).getTheLoai());
        TheLoai tl = tldao.getTheLoaiByTheLoaiId("VHVN");
        if(tl!=null)
        {
            System.out.println(tl.getTheLoai());
        }
    }
}
