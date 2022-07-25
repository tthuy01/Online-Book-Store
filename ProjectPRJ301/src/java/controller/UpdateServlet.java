/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.NXBDAO;
import dal.SachDAO;
import dal.TacGiaDAO;
import dal.TheLoaiDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NXB;
import model.Sach;
import model.TacGia;
import model.TheLoai;

/**
 *
 * @author May Tinh Ha Anh
 */
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maSach_raw = request.getParameter("masach");
        try {
            int maSach = Integer.parseInt(maSach_raw);
            SachDAO sdao = new SachDAO();
            Sach s = sdao.getBookByBookId(maSach);
            request.setAttribute("book", s);
            TheLoaiDAO tldao = new TheLoaiDAO();
            List<TheLoai> list2 = tldao.getAllTheLoai();
            request.setAttribute("alltheloai", list2);
            TacGiaDAO tgdao = new TacGiaDAO();
            List<TacGia> list1 = tgdao.getAllTacGia();
            request.setAttribute("alltacgia", list1);
            NXBDAO ndao = new NXBDAO();
            List<NXB> list3 = ndao.getAllNXB();
            request.setAttribute("allnxb", list3);

            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String maTheLoai = request.getParameter("matheloai");
        String maTacGia_raw = request.getParameter("matacgia");
        String maNXB = request.getParameter("manxb");
        String date = request.getParameter("date");
        String price_raw = request.getParameter("price");
        String inventory_raw = request.getParameter("inventory");
        try {
            int id = Integer.parseInt(id_raw);
            int price = Integer.parseInt(price_raw);
            int maTacGia = Integer.parseInt(maTacGia_raw);
            int inventory = Integer.parseInt(inventory_raw);
            SachDAO sdao = new SachDAO();
            Sach s = new Sach(id, name, image, maTheLoai, maTacGia, maNXB, date, price, inventory);
            sdao.update(s);
            response.sendRedirect("allbook");
        } catch (NumberFormatException e) {
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
