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

/**
 *
 * @author May Tinh Ha Anh
 */
public class PhanQuyenDAO extends DBContext{
    public PhanQuyen getQuyenByMaPhanQuyen(int maPhanQuyen) {
        String sql = "select * from PhanQuyen where MaPhanQuyen = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, maPhanQuyen);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                PhanQuyen pq = new PhanQuyen();
                pq.setMaPhanQuyen(maPhanQuyen);
                pq.setTenQuyen(rs.getString("TenQuyen"));
                return pq;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        PhanQuyenDAO pqdao = new PhanQuyenDAO();
        PhanQuyen pq = pqdao.getQuyenByMaPhanQuyen(1);
        if(pq!=null)
        {
            System.out.println(pq.getTenQuyen());
        }
    }
}
