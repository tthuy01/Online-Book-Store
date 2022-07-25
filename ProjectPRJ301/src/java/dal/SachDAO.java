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
import model.Sach;
import model.TacGia;
import model.TheLoai;

/**
 *
 * @author May Tinh Ha Anh
 */
public class SachDAO extends DBContext {

    public List<Sach> getAll() {
        List<Sach> list = new ArrayList<>();
        String sql = "select * from Sach";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TheLoaiDAO tldao = new TheLoaiDAO();
                TheLoai tl = tldao.getTheLoaiByTheLoaiId(rs.getString("MaTheLoai"));
                NXBDAO ndao = new NXBDAO();
                NXB n = ndao.getNXBByNXBId(rs.getString("MaNXB"));
                TacGiaDAO tgdao = new TacGiaDAO();
                TacGia tg = tgdao.getTacGiaByTacGiaId(rs.getInt("MaTacGia"));
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                s.setTg(tg);
                s.setTl(tl);
                s.setN(n);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Sach> getListByPage(List<Sach> list, int start, int end) {
        List<Sach> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Sach> getBookByCatId(String maTheLoai) //Lay sach theo ma the loai 
    {
        List<Sach> list = new ArrayList<>();
        String sql = "select * from Sach where MaTheLoai = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maTheLoai);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TheLoaiDAO tldao = new TheLoaiDAO();
                TheLoai tl = tldao.getTheLoaiByTheLoaiId(rs.getString("MaTheLoai"));
                NXBDAO ndao = new NXBDAO();
                NXB n = ndao.getNXBByNXBId(rs.getString("MaNXB"));
                TacGiaDAO tgdao = new TacGiaDAO();
                TacGia tg = tgdao.getTacGiaByTacGiaId(rs.getInt("MaTacGia"));
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                s.setTg(tg);
                s.setTl(tl);
                s.setN(n);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Sach> searchByTacGia(String key) {
        List<Sach> list = new ArrayList<>();
        String sql = "select s.MaSach, s.TenSach, s.Anh, s.MaTheLoai, s.MaTacGia, t.TenTacGia, s.MaNXB, s.NgayXB, s.Gia, s.SoLuongTonKho\n"
                + "from TacGia t \n"
                + "inner join Sach s\n"
                + "on t.MaTacGia = s.MaTacGia\n"
                + "where t.TenTacGia like ? or s.TenSach like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + key + "%");
            st.setString(2, "%" + key + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TheLoaiDAO tldao = new TheLoaiDAO();
                TheLoai tl = tldao.getTheLoaiByTheLoaiId(rs.getString("MaTheLoai"));
                NXBDAO ndao = new NXBDAO();
                NXB n = ndao.getNXBByNXBId(rs.getString("MaNXB"));
                TacGiaDAO tgdao = new TacGiaDAO();
                TacGia tg = tgdao.getTacGiaByTacGiaId(rs.getInt("MaTacGia"));
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                s.setTg(tg);
                s.setTl(tl);
                s.setN(n);
                list.add(s);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public void insertBook(Sach s) {
        String sql = "insert into Sach values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getTenSach());
            st.setString(2, s.getAnh());
            st.setString(3, s.getMaTheLoai());
            st.setInt(4, s.getMaTacGia());
            st.setString(5, s.getMaNXB());
            st.setString(6, s.getNgayXB());
            st.setInt(7, s.getGia());
            st.setInt(8, s.getSoLuongTonKho());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int maSach) {
        String sql = "delete from Sach where MaSach = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, maSach);
            st.executeUpdate(); //Tra ve int
        } catch (SQLException e) {
        }
    }

    public Sach getBookByBookId(int maSach) {
        String sql = "select * from Sach where MaSach = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, maSach);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TheLoaiDAO tldao = new TheLoaiDAO();
                TheLoai tl = tldao.getTheLoaiByTheLoaiId(rs.getString("MaTheLoai"));
                NXBDAO ndao = new NXBDAO();
                NXB n = ndao.getNXBByNXBId(rs.getString("MaNXB"));
                TacGiaDAO tgdao = new TacGiaDAO();
                TacGia tg = tgdao.getTacGiaByTacGiaId(rs.getInt("MaTacGia"));
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                s.setTg(tg);
                s.setTl(tl);
                s.setN(n);
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void update(Sach s) {
        String sql = "update Sach set TenSach = ?, Anh = ?, MaTheLoai = ?, "
                + "MaTacGia = ?, MaNXB = ?, NgayXB = ?, Gia = ?, SoLuongTonKho = ? where MaSach = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getTenSach());
            st.setString(2, s.getAnh());
            st.setString(3, s.getMaTheLoai());
            st.setInt(4, s.getMaTacGia());
            st.setString(5, s.getMaNXB());
            st.setString(6, s.getNgayXB());
            st.setInt(7, s.getGia());
            st.setInt(8, s.getSoLuongTonKho());
            st.setInt(9, s.getMaSach());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Sach> filterNXB(String[] maNXB) {
        List<Sach> list = new ArrayList<>();
        String sql = "select distinct s.MaSach, s.TenSach, s.Anh, s.MaTheLoai, s.MaTacGia, s.MaNXB, s.NgayXB, s.Gia, s.SoLuongTonKho from Sach s\n"
                + "inner join NXB n\n"
                + "on s.MaNXB = s.MaNXB\n"
                + "where 1=1 ";

        if (maNXB != null) {
            sql += "and s.MaNXB in (";
            for (int i = 0; i < maNXB.length; i++) {
                sql += "'" + maNXB[i] + "'" + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Sach> getListBookByPriceAsc() {
        List<Sach> list = new ArrayList<>();
        String sql = "select * from Sach order by Gia asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TheLoaiDAO tldao = new TheLoaiDAO();
                TheLoai tl = tldao.getTheLoaiByTheLoaiId(rs.getString("MaTheLoai"));
                NXBDAO ndao = new NXBDAO();
                NXB n = ndao.getNXBByNXBId(rs.getString("MaNXB"));
                TacGiaDAO tgdao = new TacGiaDAO();
                TacGia tg = tgdao.getTacGiaByTacGiaId(rs.getInt("MaTacGia"));
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                s.setTg(tg);
                s.setTl(tl);
                s.setN(n);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Sach> getListBookByPriceDesc() {
        List<Sach> list = new ArrayList<>();
        String sql = "select * from Sach order by Gia desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TheLoaiDAO tldao = new TheLoaiDAO();
                TheLoai tl = tldao.getTheLoaiByTheLoaiId(rs.getString("MaTheLoai"));
                NXBDAO ndao = new NXBDAO();
                NXB n = ndao.getNXBByNXBId(rs.getString("MaNXB"));
                TacGiaDAO tgdao = new TacGiaDAO();
                TacGia tg = tgdao.getTacGiaByTacGiaId(rs.getInt("MaTacGia"));
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                s.setTg(tg);
                s.setTl(tl);
                s.setN(n);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Sach> searchByTacGiaOrderByPriceAsc(String key) {
        List<Sach> list = new ArrayList<>();
        String sql = "select s.MaSach, s.TenSach, s.Anh, s.MaTheLoai, s.MaTacGia, t.TenTacGia, s.MaNXB, s.NgayXB, s.Gia, s.SoLuongTonKho\n"
                + "from TacGia t \n"
                + "inner join Sach s\n"
                + "on t.MaTacGia = s.MaTacGia\n"
                + "where t.TenTacGia like ? or s.TenSach like ? order by s.Gia asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + key + "%");
            st.setString(2, "%" + key + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TheLoaiDAO tldao = new TheLoaiDAO();
                TheLoai tl = tldao.getTheLoaiByTheLoaiId(rs.getString("MaTheLoai"));
                NXBDAO ndao = new NXBDAO();
                NXB n = ndao.getNXBByNXBId(rs.getString("MaNXB"));
                TacGiaDAO tgdao = new TacGiaDAO();
                TacGia tg = tgdao.getTacGiaByTacGiaId(rs.getInt("MaTacGia"));
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                s.setTg(tg);
                s.setTl(tl);
                s.setN(n);
                list.add(s);
            }

        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Sach> searchByTacGiaOrderByPriceDesc(String key) {
        List<Sach> list = new ArrayList<>();
        String sql = "select s.MaSach, s.TenSach, s.Anh, s.MaTheLoai, s.MaTacGia, t.TenTacGia, s.MaNXB, s.NgayXB, s.Gia, s.SoLuongTonKho\n"
                + "from TacGia t \n"
                + "inner join Sach s\n"
                + "on t.MaTacGia = s.MaTacGia\n"
                + "where t.TenTacGia like ? or s.TenSach like ? order by s.Gia desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + key + "%");
            st.setString(2, "%" + key + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TheLoaiDAO tldao = new TheLoaiDAO();
                TheLoai tl = tldao.getTheLoaiByTheLoaiId(rs.getString("MaTheLoai"));
                NXBDAO ndao = new NXBDAO();
                NXB n = ndao.getNXBByNXBId(rs.getString("MaNXB"));
                TacGiaDAO tgdao = new TacGiaDAO();
                TacGia tg = tgdao.getTacGiaByTacGiaId(rs.getInt("MaTacGia"));
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                s.setTg(tg);
                s.setTl(tl);
                s.setN(n);
                list.add(s);
            }

        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Sach> sachBanChay() {
        String sql = "select b.MaSach, b.TenSach, b.Anh, b.MaTheLoai, b.MaTacGia, b.MaNXB, b.NgayXB, b.Gia, b.SoLuongTonKho, sum(od.SoLuong) as LuotBan from Sach b\n" +
                        "inner join HoaDonChiTiet od\n" +
                        "on b.MaSach = od.MaSach\n" +
                        "group by b.MaSach, b.TenSach, b.Anh, b.MaTheLoai, b.MaTacGia, b.MaNXB, b.NgayXB, b.Gia, b.SoLuongTonKho\n" +
                        "order by sum(od.SoLuong) desc";
        List<Sach> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TheLoaiDAO tldao = new TheLoaiDAO();
                TheLoai tl = tldao.getTheLoaiByTheLoaiId(rs.getString("MaTheLoai"));
                NXBDAO ndao = new NXBDAO();
                NXB n = ndao.getNXBByNXBId(rs.getString("MaNXB"));
                TacGiaDAO tgdao = new TacGiaDAO();
                TacGia tg = tgdao.getTacGiaByTacGiaId(rs.getInt("MaTacGia"));
                Sach s = new Sach();
                s.setMaSach(rs.getInt("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setAnh(rs.getString("Anh"));
                s.setMaTheLoai(rs.getString("MaTheLoai"));
                s.setMaTacGia(rs.getInt("MaTacGia"));
                s.setMaNXB(rs.getString("MaNXB"));
                s.setNgayXB(rs.getString("NgayXB"));
                s.setGia(rs.getInt("Gia"));
                s.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                s.setTg(tg);
                s.setTl(tl);
                s.setN(n);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        SachDAO sdao = new SachDAO();
//        List<Sach> list = sdao.getAll();
//        System.out.println(list.get(0).getTg().getTenTacGia());
//        List<Sach> list1 = sdao.searchByTacGia("ao");
//        if (list1 != null) {
//            for (int i = 0; i < list1.size(); i++) {
//                System.out.println(list1.get(i).getTg().getTenTacGia());
//            }
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getTenSach());
//        }
//        List<Sach> list1 = sdao.searchByTacGia("Cố Mạn");
//        System.out.println(list1.get(0).getTenSach());

//        Sach s = new Sach(0, "Thám tử lừng danh conan tập 90", "images/sconan90.jpg", "TT", 12, "KD", null, 20000, 5);
//        sdao.insertBook(s);
//        sdao.delete(23);
//        System.out.println(sdao.getBookByBookId(1).getTenSach());
//        Sach s = new Sach(1, "Thám tử lừng danh conan tập 90", "images/sconan90.jpg", "TT", 12, "KD", null, 20000, 5);
//        sdao.update(s);
//        String[] maNXB = {"KD"};
//        List<Sach> l = sdao.filterNXB(maNXB);
//        for (int i = 0; i < l.size(); i++) {
//            System.out.println(l.get(i).getTenSach());
//        }
//        Sach s1 = sdao.getBookByBookId(1);
//        if (s1!=null)
//        {
//            System.out.println(s1.getN().getTenNXB());
//        }
//        List<Sach> listAsc = sdao.searchByTacGiaOrderByPriceDesc("c");
//        System.out.println(listAsc.get(0).getGia());
        List<Sach> listBanChay = sdao.sachBanChay();
        System.out.println(listBanChay.get(0).getTenSach());
    }
}
