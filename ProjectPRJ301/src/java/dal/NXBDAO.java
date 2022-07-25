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
import model.NXB;

/**
 *
 * @author May Tinh Ha Anh
 */
public class NXBDAO extends DBContext {

    public List<NXB> getAllNXB() {
        List<NXB> list = new ArrayList<>();
        String sql = "select * from NXB";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                NXB n = new NXB();
                n.setMaNXB(rs.getString("MaNXB"));
                n.setTenNXB(rs.getString("TenNXB"));
                n.setDiaChi(rs.getString("DiaChi"));
                list.add(n);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void insertNXB(NXB n)
    {
        String sql = "insert into NXB values(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, n.getMaNXB());
            st.setString(2, n.getTenNXB());
            st.setString(3, n.getDiaChi());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public NXB getNXBByNXBId(String maNXB) {
        String sql = "select * from NXB where MaNXB = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maNXB);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                NXB n = new NXB();
                n.setMaNXB(maNXB);
                n.setTenNXB(rs.getString("TenNXB"));
                n.setDiaChi(rs.getString("DiaChi"));
                return n;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public static void main(String[] args) {
        NXBDAO ndao = new NXBDAO();
//        List<NXB> list = ndao.getAllNXB();
//        System.out.println(list.get(0).getTenNXB());;
        NXB n = new NXB("a", "Nhà xuất bản nghệ thuật", "Hà Nội");
//        ndao.insertNXB(n);
//        System.out.println(list.get(0).getMaNXB().equalsIgnoreCase("a"));
        NXB n1 = ndao.getNXBByNXBId("KD");
        if(n1!=null)
            System.out.println(n1.getDiaChi());
    }
}
